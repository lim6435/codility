import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
    
            HashMap clothesMap = new HashMap<>();
            for (int i = 0; i < clothes.length; i++) {
                String category = clothes[i][clothes[i].length - 1];
                for (int j = clothes[0].length - 2; j >= 0; j--) {
                    Integer clothesCount = (Integer)clothesMap.get(category);
                    if (clothesCount != null) {
                        clothesMap.put(category, clothesCount + 1);
                    } else {
                        clothesMap.put(category, 1);
                    }
                }
            }
    
            Iterator iterator = clothesMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String)iterator.next();
                answer = answer * ((Integer)clothesMap.get(key) + 1);
            }
    
            answer = answer - 1;
        
            return answer;
    }
}