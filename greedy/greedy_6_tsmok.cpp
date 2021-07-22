#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(vector<int> a, vector<int> b){
    return a[0] < b[0];
}

int solution(vector<vector<int>> routes) {
    int answer = 1;     //카메라가 처음엔 무조건 1대는 설치되어야 한다.
        
    sort(routes.begin(), routes.end()); // 일단 입구의 위치가 작은 순으로부터 정열한다.
    
    //
    //판단방식 : 전의 자동차가 다음자동차가 들어오기 전에 나가버리면 카메라를 한 대 더 설치해야 한다.
    //1. 자동차들 출구지점(나가는 좌표)의 최소값(temp)을 계속 갱신 한다.
    //2. 다음 자동차의 입구지점(들어오는 좌표)이 최소값(temp)보다 크다면(더 오른쪽에 있다면)
    //다음 자동차가 들어오기전에 전에 자동차들 중에 하나가 나가버리는 것이기 때문에 카메라를 한대 
    //더 설치해야 한다.
    
    int temp=routes[0][1];  //일단 첫번째 자동차의 나가는 지점을 저장한다.
    for(int i=0 ; i < routes.size()-1; ++i){
        //만약 다음자동차가 들어오기 전에 이미 들어온 자동차들 중 한대가 나간다면 카메라 추가 설치
        if(routes[i+1][0] > temp){
            answer++;
            //카메라를 새로 설치했으므로 temp기준을 다시 갱신한다.
            temp=routes[i+1][1];
        }
        // 다음자동차가 들어올때 아직 전의 자동차들이 도로를 달리고 있다면 카메라를 더 설치할 필요         / /가 없다
        else{
            // 나가는 지점의 최소값(가장 먼저 나가는 자동차의 위치)를 계속 갱신한다.
            if(temp > routes[i+1][1])
                temp=routes[i+1][1];
        }
    }
    
    return answer;
}