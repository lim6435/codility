#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;


/*
1. 처음 시도 방식 :
  1) 비용이 적게 드는 순서대로 costs 배열을 정렬한다.
  2) 각 섬이 연결되었는지 안 되었는지를 저장하는 배열을 하나 선언한다.(1이면 연결완료 0이면 아직 미연결됨)
  3) 섬 연결이 안되어있을때는 배열값을 0->1로 바꾸고 answer 에다가 비용을 더한다.
  4) 섬연결이 모두 1이 되었을때 빠져나온다.
  
  결과 : 25점 이상안나옴
  이유 : 모든 섬 연결여부가 전부 1로 되었다 하더라도 만약 큰 두개 이상의 연결로 이루어졌을때 그 연결들 사이의 연결여부를 알 수가 없다.
  ex) (0-1-2) (3-4) 이렇게 연결되었을 경우 0부터 4까지 모두 연결여부는 1이 되지만 (0-1-2) 와 (3-4) 사이의 연결은 안되어있다.
  
2. 두번째 시도방식
  1) 크루스칼 알고리즘을 이용(부모 노드(연결된 노드 중 가장 값이 적은 노드)를 구해 그 부모의 일치여부로 노드 사이의 연결을 판단한다)
  2) 첫번째 방식과 같은 방식 
*/


bool compare(vector<int> a, vector<int> b){
    return a[2] < b[2];    
}

//부모 노드를 구하는 함수
int getParent(vector<int> parent, int x){
    if(parent[x] == x)
        return x;
    return getParent(parent, parent[x]);
}

//부모 노드를 하나로 합치는 함수
void unionParent(vector<int> &parent, int x, int y){
    int a = getParent(parent, x);
    int b = getParent(parent, y);
   // cout << "a : " << a << "b : " << b << endl; 
    if(a>b)
        parent[a] = b;
    else
        parent[b] = a;
}
// 두 노드가 한 부모노드로 이어져있는지 체크
int checkSameParent(vector<int> parent, int x, int y){
    int a = getParent(parent, x);
    int b = getParent(parent, y);
    if(a==b)
        return 1;
    else 
        return 0;
}


int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    vector<int> parent; //각 노드의 부모노드를 저장하기 위한 배열
    for(int i = 0 ; i < n ; ++i){
        parent.push_back(i);    //처음에는 각자 자기
    }
    //비용이 적게 나가는것부터 정렬해야 비용의 합이 가장적다.
    sort(costs.begin(),costs.end(),compare);
    for(int i = 0 ; i < costs.size(); ++i){
        //두 노드 사이의 부모가 다를경우(연결이 안되어 있을 경우)에만 연결한다. 
        // 부모가 같은 경우(연결이 이미 되어 있을 경우)에는 그냥 pass
        if(checkSameParent(parent, costs[i][0], costs[i][1]) == 0){
            unionParent(parent, costs[i][0], costs[i][1]);  //두 노드를 연결(부모를 둘 중 하나로 변경)
            answer+=costs[i][2];                            //노드 연결 비용을 더함
        }     
    
    }
    
    return answer;
}