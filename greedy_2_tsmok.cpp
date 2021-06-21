#include <string>
#include <vector>

using namespace std;

int getDirect(string, char*, int, int);
void initCmpName(char*, int);
int chgCmpName(char*, string, int);

int solution(string name) {
    
    int answer = 0;
    int direct = 1;     // ����
    int idx = 0;        // �ѱ��ھ� ���� ���� �ε���
    int nameLen = 0;    // name ����
    char cmp_name[20];  // ���ϸ鼭 �ٲ� name��
    int cnt=0;          // ���ĺ� �ٲٱ� ���� ��/�Ʒ� ���� Ƚ��
    // NULL �ʱ�ȭ
    for(int i = 0 ; i < sizeof(cmp_name); ++i)
        cmp_name[i] = 0x00;
    
    nameLen = name.length();
    
    // 'A'�� �ʱ�ȭ
    initCmpName(cmp_name, nameLen); 
    
 
    while (cmp_name != name) {     
        
        // ���ĺ��� �ٲ�������� �̵������� �ٽ� üũ�Ѵ�
        
        direct = getDirect(name, cmp_name,idx,nameLen);
        // ���ĺ� �ٲٱ�(�ѱ��ھ�)
        cnt = chgCmpName(cmp_name, name, idx);
          
        //��/�Ʒ��� Ű�� ���� cnt
        answer += cnt;
        //��/������ Ű�� ������.(��ĭ�� �̵�) 
        idx += direct;
        answer++;
      //  printf("%d ", direct);
        // idx�� nameLen �� ������ ������� �ȵȴ�.
        if (idx < 0)
            idx = nameLen - 1;
        if (idx == nameLen)
            idx = 0;
    }
    
    //������ Ŀ���̵��� ����. �̹� ������ �ϼ��Ǿ��� ������.
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

//���ĺ� �ٲٱ�
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
    
    //���ĺ� ���߱�
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