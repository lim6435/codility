#include <string>
#include <vector>
#include <algorithm>
using namespace std;


int solution(vector<int> people, int limit) {
    int answer = 0;
    
    //people을 작은 순부터 정열시킨다.
    sort(people.begin(),people.end());
    
    
    //무거운 쪽으로 갈수록 배가 1명만 나를 가능성이 많기     //때문에 가장 무거운 거랑 가장 가벼운거를 더해야 가장     //효율적일듯

    int start_idx=0;
    int end_idx= people.size()-1;
    
    while(start_idx<=end_idx){
        if(people[start_idx]+people[end_idx] <= limit){
            start_idx++;
            end_idx--;
        }
        else{
            end_idx--;
        }
        answer++;    
    }
    
    return answer;
}



