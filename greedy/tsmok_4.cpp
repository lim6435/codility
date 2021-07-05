#include <string>
#include <vector>
#include <algorithm>
using namespace std;


int solution(vector<int> people, int limit) {
    int answer = 0;
    
    //people�� ���� ������ ������Ų��.
    sort(people.begin(),people.end());
    
    
    //���ſ� ������ ������ �谡 1�� ���� ���ɼ��� ����     //������ ���� ���ſ� �Ŷ� ���� ������Ÿ� ���ؾ� ����     //ȿ�����ϵ�

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



