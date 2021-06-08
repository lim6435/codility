#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int sum = brown+yellow;
    int high=3;
    int wide=0;
    while (1) {
        if (sum%high==0) {
            int wide = sum/high;
            if (((high-2) * (wide-2)) == yellow) {
                answer.push_back(wide);
                answer.push_back(high);
                break;
            }
            
        }
        high++;
    }
    return answer;
}