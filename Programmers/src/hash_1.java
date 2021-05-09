import java.util.HashMap;
import java.util.Iterator;

public class hash_1 {
    public static void main(String[] args) {

        Solution1 solution = new Solution1();
        String[] participant = {"a", "b", "c", "b"};
        String[] completion = {"a", "c", "b"};
        System.out.println(solution.solution(participant, completion));
    }

}

class Solution1 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> raceResult = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            Integer result = raceResult.get(participant[i]);
            if (result != null) {
                raceResult.put(participant[i], result + 1);
            }
            else raceResult.put(participant[i], 1);
        }

        for (int i = 0; i < completion.length; i++) {
            int index = raceResult.get(completion[i]);
            if (index > 0) raceResult.put(completion[i], index - 1);
        }

        Iterator<String> mapIter = raceResult.keySet().iterator();
        while(mapIter.hasNext()){
            String key = mapIter.next();
            int value = raceResult.get( key );

            if (value >= 1) return key;
        }

        return null;
    }
}
