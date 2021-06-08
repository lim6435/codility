#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(int a, int b){
    return a>b;
}

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> firstPersonPattern = {1,2,3,4,5};
    vector<int> secondPersonPattern = {2,1,2,3,2,4,2,5};
    vector<int> thirdPersonPattern = {3,3,1,1,2,2,4,4,5,5};
    
    int total[3] = {0,0,0}; 
    
    
    for(int i = 0 ; i < answers.size(); ++i){
        if(firstPersonPattern[i%5]==answers[i]){
            total[0]++;
        }
        if(secondPersonPattern[i%8]==answers[i]){
            total[1]++;
        }
        if(thirdPersonPattern[i%10]==answers[i]){
            total[2]++;
        }   
    }
    int max_total = max(max(total[0], total[1]), total[2]);
    for (int i = 0; i < 3; i++){
        if (total[i] == max_total)
            answer.push_back(i + 1);
    }
    
    return answer;
}