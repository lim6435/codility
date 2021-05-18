class Solution {
            public int[] solution(int[] prices) {
                int[] answer = new int[prices.length];
        
                for (int i = 0; i < prices.length; i++) {
                    int count = 0;
                    for (int j = i+1; j < prices.length; j++) {
                        if (count == 0 )count++;
                        if (prices[i] > prices[j]) {
                            break;
                        } else {
                            if (j != prices.length - 1) count++;
                        }
                    }
        
                    answer[i] = count;
                
                }
        
                return answer;
            }
        }