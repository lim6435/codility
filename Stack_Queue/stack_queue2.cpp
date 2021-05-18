#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    int tmp,tmp2=0;
    
    queue<pair<int,int>> queue_priorities;
    for(int i=0;i<priorities.size();++i){
        queue_priorities.push(make_pair(priorities[i],i));
    }
    sort(priorities.begin(), priorities.end());
    while(!queue_priorities.empty()){
        
        while(queue_priorities.front().first!=priorities.back()){
            tmp=queue_priorities.front().first;      
            tmp2=queue_priorities.front().second;
            queue_priorities.pop();
            queue_priorities.push(make_pair(tmp,tmp2)); 
        }
        answer++;
        if(location == queue_priorities.front().second)
            break;
        queue_priorities.pop();
        priorities.pop_back();
        
    }
    
    
    
    
    
    return answer;
}