import java.util.*;

public class hash_4 {
}
class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] genres = {"classic", "classic", "classic"};
        int[] plays = {500, 600, 150};
        System.out.println(solution.solution(genres, plays));
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> playSumMap = new HashMap<String, Integer>();
        ArrayList<Integer> retList = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            Integer play = playSumMap.get(genres[i]);
            if (play != null) play = play + plays[i];
            else play = plays[i];
            playSumMap.put(genres[i], play);
        }

        while (playSumMap.size() > 0) {
            Map.Entry<String, Integer> maxEntry = null;
            String topGenre = "";
            for (Map.Entry<String, Integer> entry : playSumMap.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                    topGenre = maxEntry.getKey();
                }
            }

            int max1 = 0;
            int max2 = 0;
            int max1Index = -1;
            int max2Index = -1;
            for (int i = 0; i < genres.length; i++) {
                if (genres[i]. equals(topGenre)) {
                    if (max1 < plays[i]) {
                        if (max2 < max1) {
                            max2 = max1;
                            max2Index = max1Index;
                        }
                        max1 = plays[i];
                        max1Index = i;
                    } else if (max2 < plays[i]) {
                        max2 = plays[i];
                        max2Index = i;
                    }

                }
            }

            retList.add(max1Index);
            if (max1Index != max2Index && max2 != 0) {
                retList.add(max2Index);
            }
            playSumMap.remove(maxEntry.getKey());
        }

        answer = new int[retList.size()];
        for (int i = 0; i < retList.size(); i++) {
            answer[i] = retList.get(i);
        }

        return answer;
    }
}