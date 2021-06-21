#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

bool compare(int a, int b){
    return a<b;
}


int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    
    vector<int> all(n,1);
    
    for(int i=0; i<lost.size(); ++i)
        all[lost[i]-1]--;
    for(int i = 0; i<reserve.size();++i)
        all[reserve[i]-1]++;
    
    for(int i = 0 ; i < n ; ++i){
        if(i>0 && all[i-1]==0 && all[i]==2)  {
            all[i-1]++;
            all[i]--;
        }
        if(i<n-1 && all[i+1] ==0 && all[i]==2){
            all[i+1]++;
            all[i]--;
        }
    }
    
    for(int i = 0 ; i < n; ++i)
        if(all[i]>0)
            answer++;
        
    return answer;
}