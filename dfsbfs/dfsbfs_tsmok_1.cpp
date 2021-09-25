#include <string>
#include <vector>

using namespace std;

void dfs(vector<int> &numbers, int &answer, int sum, int target, int cnt){
    if(cnt == numbers.size()-1){
        if(sum+numbers[numbers.size()-1] == target){
            answer++;
        }
        if(sum-numbers[numbers.size()-1] == target){
            answer++;
        }
        return;
    }
    dfs(numbers, answer, sum+numbers[cnt] ,target, cnt+1);
    dfs(numbers, answer, sum-numbers[cnt] ,target, cnt+1);
    
}


int solution(vector<int> numbers, int target) {
    int answer = 0;
    dfs(numbers, answer, 0, target, 0);
    return answer;
}