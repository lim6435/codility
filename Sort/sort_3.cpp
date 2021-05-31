#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(int a, int b){
    return a>b;
}

int solution(vector<int> citations) {
    int answer = 0;
    int cnt=0;
    
    sort(citations.begin(), citations.end(), compare);
    
    if(citations[0] == 0) return 0;
    for(int i = 0; i < citations.size();++i){
        if(citations[i] <= i){
            break;
        }
        answer++;
    }

        
    return answer;
}