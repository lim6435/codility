import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class hash_2 {
    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        String[] phone_book = {"119", "87674223", "1185524421"};
        System.out.println(solution.solution(phone_book));
    }

}

class Solution2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, String> phoneMap = new HashMap<>();
        int[] sizeArray = new int[phone_book.length];
        int sizeIndex = 0;

        Arrays.sort(phone_book, Comparator.comparing(String::length));

        sizeArray[0] = String.valueOf(phone_book[0]).length();
        for(int i = 0; i < phone_book.length; i++) {
            String ret = phoneMap.get(phone_book[i]);
            if (ret != null) return false;
            phoneMap.put(phone_book[i], "");

            boolean compareLengthFlag = false;
            for (int j = 0; j <= sizeIndex; j++) {
                if (sizeArray[sizeIndex] == phone_book[i].length()) compareLengthFlag = true;
                if (phone_book[i].length() <= sizeArray[j]) continue;
                ret = phoneMap.get(phone_book[i].substring(0, sizeArray[j]));
                if (ret != null) return false;
            }

            if (!compareLengthFlag) {
                sizeArray[sizeIndex + 1] = phone_book[i].length();
                sizeIndex = sizeIndex + 1;
            }

        }
        return answer;
    }
    /* Hash 안쓰면 시간초
    public boolean solution(String[] phone_book과) {
        boolean answer = true;

        for (int i = 0; i < phone_book.length ; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                phone_book[i] = phone_book[i].replace(" ", "");
                phone_book[j] = phone_book[j].replace(" ", "");
                if (phone_book[i].length() > phone_book[j].length()) continue;
                else {
                    String sub = phone_book[j].substring(0, phone_book[i].length());
                    if (sub.equals(phone_book[i])) {
                        answer = false;
                        break;
                    }
                }
            }
            if (!answer) break;
        }

        return answer;
    }
     */
}


