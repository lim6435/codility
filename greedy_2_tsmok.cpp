#include <string>
#include <vector>

using namespace std;

int getDirect(string, char*, int, int);
void initCmpName(char*, int);
int chgCmpName(char*, string, int);

int solution(string name) {
    
    int answer = 0;
    int direct = 1;     // 방향
    int idx = 0;        // 한글자씩 비교할 현재 인덱스
    int nameLen = 0;    // name 길이
    char cmp_name[20];  // 비교하면서 바꿀 name값
    int cnt=0;          // 알파벳 바꾸기 위해 위/아래 누른 횟수
    // NULL 초기화
    for(int i = 0 ; i < sizeof(cmp_name); ++i)
        cmp_name[i] = 0x00;
    
    nameLen = name.length();
    
    // 'A'로 초기화
    initCmpName(cmp_name, nameLen); 
    
 
    while (cmp_name != name) {     
        
        // 알파벳이 바뀌었을때만 이동방향을 다시 체크한다
        
        direct = getDirect(name, cmp_name,idx,nameLen);
        // 알파벳 바꾸기(한글자씩)
        cnt = chgCmpName(cmp_name, name, idx);
          
        //위/아래로 키를 누른 cnt
        answer += cnt;
        //왼/오른쪽 키를 누른다.(한칸씩 이동) 
        idx += direct;
        answer++;
      //  printf("%d ", direct);
        // idx가 nameLen 의 범위를 벗어나서는 안된다.
        if (idx < 0)
            idx = nameLen - 1;
        if (idx == nameLen)
            idx = 0;
    }
    
    //마지막 커서이동은 뺀다. 이미 위에서 완성되었기 때문에.
    answer--;
    return answer;
}

int getDirect(string name, char* cmp_name, int idx, int nameLen) {
  
    int left_distance=1;
    int right_distance=1;
    int tmp_idx=idx;
    
    while(1){
        if(tmp_idx-left_distance < 0)        
            tmp_idx=name.length()+left_distance-1;
        if(name[tmp_idx-left_distance] == cmp_name[tmp_idx-left_distance]){
            left_distance++;
            continue;
        }    
        break;
    }
    
    while(1){
        if(name[(tmp_idx+right_distance)%name.length()] == 
           cmp_name[(tmp_idx+right_distance)%name.length()]) {
            right_distance++;
            continue;
        }
        break;
    }
    
    
    
   // printf("%d %d\n",right_distance, left_distance);
    if(right_distance<=left_distance)
        return 1;
    else
        return -1;
}

void initCmpName(char* cmp_name, int nameLen) {
    int i = 0;    
    for (i = 0; i < nameLen; ++i) {
       cmp_name[i] = 'A';
    }

}

//알파벳 바꾸기
int chgCmpName(char* cmp_name, string name, int idx) {
    int cnt = 0;
    int direct = 1;
    //move up
    if (name[idx] <= 'M') {
        direct = 1;
    }
    //move down
    else {
        direct = -1;
    }
    
    //알파벳 맞추기
    while (cmp_name[idx] != name[idx]) {
        cmp_name[idx] += direct;
        
        if (cmp_name[idx] < 'A')
            cmp_name[idx] = 'Z';
        if (cmp_name[idx] > 'Z')
            cmp_name[idx] = 'A';
   
        cnt++;
        
    }
    return cnt;

}