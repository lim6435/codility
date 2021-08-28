#include <string>
#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int getNN(int len, int N){
    
    int temp=0;
    for(int i = 0 ; i < len; ++i){
        temp=(temp*10)+N;    
    }
    return temp;
}

int solution(int N, int number) {
    int answer = 0;
    
    vector<unordered_set<int>> arr(8); 
    unordered_set<int>::iterator iter;
    if(N==number)
        return 1;
    
    arr[0].insert(N);
    
    for(int i = 1; i < 8 ; ++i){
        if(getNN(i+1,N) == number)
            return i+1;
        arr[i].insert(getNN(i+1,N));
        for(int j = 0 ; j < i ; ++j){
            for(auto &x:arr[j]){
                for(auto &y:arr[i-j-1]){
                    if(x+y==number || x-y==number || x*y==number || ((y!=0) && (x/y == number)))
                        return i+1;
                  
                    arr[i].insert(x+y);
                    arr[i].insert(x-y);
                    arr[i].insert(x*y);
                    if(y!=0)
                        arr[i].insert(x/y);
                    
                }
            }
        }
       
    }
    answer = -1;
    return answer;
}




