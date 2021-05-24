#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

bool comp(int a, int b){
    return a<b;
}
class Comp{
    public:
    bool operator()(int a,int b){
        return a>b;
    }
};

int solution(vector<int> scoville, int K) {
    int answer = 1;
    priority_queue<int,vector<int>,Comp> pq_scoville;
    //sort(scoville.begin(),scoville.end(),comp);
    for(int i=0; i < scoville.size();++i)
        pq_scoville.push(scoville[i]);
    
    while(pq_scoville.size()>=2){
        int min_scoville = pq_scoville.top();
       // printf("%d ",min_scoville);
        pq_scoville.pop();
        int second_min_scoville = pq_scoville.top();
        //printf("%d ",second_min_scoville);
        pq_scoville.pop();
        pq_scoville.push(min_scoville+(second_min_scoville*2));
        if(pq_scoville.size()==1 && pq_scoville.top() < K)
            return -1;
        if(pq_scoville.top() >= K){
            //printf("%d ",mix_scoville);
            break;
        }
        answer++;
    }
   
    return answer;
}