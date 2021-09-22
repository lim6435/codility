#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;



int solution(vector<vector<int>> triangle) {
    int answer = 0;
    
    vector<vector<int>> vec_sum(triangle.size());
    vec_sum[0].push_back(triangle[0][0]);
    
    
    
   
    //0 //    0
    //1 //    0,1
    //2 //    0,1,2
    //3 //    0,1,2,3
    //4 //    0,1,2,3,4  
    for(int i = 1 ; i < triangle.size(); ++i){
        for(int j = 0 ; j < triangle[i].size() ; ++j ){
            if(j==0 ){
                vec_sum[i].push_back(vec_sum[i-1][j]+triangle[i][j]);
               // cout << "[" << triangle[i][j] << "]";
            }else if(j==triangle[i].size()-1){
                vec_sum[i].push_back(vec_sum[i-1][j-1]+triangle[i][j]);
            }
            else{
                vec_sum[i].push_back(max(vec_sum[i-1][j-1]+triangle[i][j],vec_sum[i-1][j]+triangle[i][j]));
               //  cout << "[" << triangle[i][j] << "]";
            }
        }
       
        if(i == triangle.size()-1){
            sort(vec_sum[i].begin(),vec_sum[i].end() , greater<int>());
            answer = vec_sum[i][0];
        }
    }
   // cout << "[" << maxSum << "]" << endl;
    
    
    return answer;
}