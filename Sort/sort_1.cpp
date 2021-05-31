#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(int a , int b){
    return a<b;
}

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    
    
    for(int j=0;j<commands.size(); j++){
        int startIdx = (commands[j][0])-1;
        int endIdx = (commands[j][1])-1;
        int targetIdx = (commands[j][2])-1;
        int length = (endIdx - startIdx)+1;
        vector<int> targetArray;
        for(int i = 0 ; i < length ; ++i){
            targetArray.push_back(array[startIdx+i]);
        }
        sort(targetArray.begin(),targetArray.end(), compare);
        /*
        for(int i = 0 ; i < length ; ++i){
            printf("%d ", targetArray[i]);
        }
        */
        answer.push_back(targetArray[targetIdx]);
         
    }
    
    return answer;
    
}
