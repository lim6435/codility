#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> queue_progresses;
    
    for(int i=0;i<progresses.size();++i){
        queue_progresses.push(progresses[i]);
    }
    while(!queue_progresses.empty()){
        int cnt=0;
        for(int i=0;i<queue_progresses.size();++i ){
            int tmp=queue_progresses.front();
            queue_progresses.pop();
            queue_progresses.push(tmp+speeds[i]);
        }
        while(1){
            if(queue_progresses.size()>0 && queue_progresses.front()>=100){
                cnt++;
                queue_progresses.pop();   
                speeds.erase(speeds.begin());
                continue;
            }
            break;    
        }
        if(cnt>0)
            answer.push_back(cnt);
         
            
    }
    
    
    return answer;
}