import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Hash {

    public static String solution(String[] participant, String[] completion) {
//        String answer = "";
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        int i = 0;
//        for (i = 0; i < participant.length-1; i++) {
//            System.out.println(participant[i]);
//            System.out.println(completion[i]);
//            if (!participant[i].equals(completion[i])) {
//                break;
//            }
//        }
//
//        answer = participant[i];

        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
            System.out.println(hm.get(player));
        }
        for (String player : completion){
            hm.put(player, hm.get(player) - 1);
            System.out.println(hm.get(player));
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].indexOf(phone_book[i]) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> hmCnt = new HashMap<>();
        //{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}, {"blue_turban", "headgear"}};

        for(String[] s : clothes) {
            hm.put(s[1], hm.getOrDefault(s[1], 0) + 1);
        }

        for(int i = 1 ; i < clothes.length ; i++) {
            String[] s = clothes[i];
            hmCnt.put(i, combiCnt(i));
        }


        int n = 1;
        for(String[] s : clothes) {
            hm.put(s[1], hm.getOrDefault(s[1], 0) + 1);
            System.out.println("answer1 : " + answer);
            answer += combiCnt(clothes.length) / (combiCnt(n)*combiCnt(clothes.length-n++));
        }

        for(String key : hm.keySet()) {
            if (hm.get(key) > 1) {
                for(int j = 1; j <= hm.get(key); j++){
                    answer -= combiCnt(hm.get(key)) / (combiCnt(j)*combiCnt(hm.get(key)-j));
                }
            }
        }
        // 4 - 1 = 4! 24 / 1 * 3! 6 4
        // 4 - 2 = 4! 24 / 2! * 2! 6 - (3 - 2 = 3! 6 / 2! 3) 3
        // 4 - 3 = 4! 24 / 3! * 1 4
        System.out.println("answer2 : " + answer);

//        for (String key : hm.keySet()) answer /= hm.get(key);

//        System.out.println("answer3 : " + answer);

//        for (String key : hm.keySet()){
//            System.out.println(combiCnt(hm.size()) / (combiCnt(i)*combiCnt(hm.size()-i)) + " key : " + key);
//            answer += combiCnt(hm.size()) / (combiCnt(i)*combiCnt(hm.size()-i)) * hm.get(key);
//            System.out.println("answer : " + answer);
//            i++;
//            // 5 - 1 = 5!(5 4 3 2 1 ) / 1 * 4! 5
//            // 5 - 2 = 5!(5 4 3 2 1 ) / 2!(2 1) * 3!(3 2 1) 10
//            // 5 - 3 = 5!(5 4 3 2 1 ) / 3!(3 2 1 ) * 2!(2 1 ) 10
//            // 5 - 4 = 5!(5 4 3 2 1 ) / 4!(4 3 2 1 ) * 1 5
//        }
        return answer;
    }

    public static int combiCnt(int arr) {
        int ret = 1;
        for (int i = 1; i <= arr; i++) {
            ret *= i;
        }
        return ret;
    }

    // 조합 알고리즘.
    public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        System.out.println( " n : " + n + " r : " + r + " index : " + index + " target : " + target);
        if(r == 0){
            for(int i=0; i<index; i++) System.out.print(arr[combArr[i]] + " ");
            System.out.println();
        }else if(target == n) return;
        else{

            combArr[index] = target;
            doCombination(combArr, n, r-1, index+1, target+1, arr); // (i)
            doCombination(combArr, n, r, index, target+1, arr); //(ii)
        }
    }

    public static void main(String args[]) {

        // solution
        String[] par = {"marina", "josipa", "nikola", "marina", "filipa"};
        String[] com = {"josipa", "filipa", "marina", "nikola"};

//        System.out.println("test1 + " + solution(par, com));

        // solution 1
        String[] phone = {"119", "97674223", "1195524421", "120"};
        String[] phone1 = {"1111", "222", "9", "1919"};

//        System.out.println("solution : " + solution(phone1));

        // solution 2
        // 4 - 1 = 4! 24 / 1 * 3! 6 4
        // 4 - 2 = 4! 24 / 2! * 2! 6 - (3 - 2 = 3! 6 / 2! 3) 3
        // 4 - 3 = 4! 24 / 3! * 1 4
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}, {"blue_turban", "headgear"}};
        String[][] clothes2 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "pants"}};
        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "pants"}, {"green_turban", "pants"}};


        System.out.println("count : " + solution(clothes));

        Hash hash = new Hash();
        int[] arr = { 1, 3, 5, 7, 9 };
        int n = arr.length;
        int r = 4;
        int[] combArr = new int[n];

//        hash.doCombination(combArr, n, r, 0, 0, arr);
    }
}
