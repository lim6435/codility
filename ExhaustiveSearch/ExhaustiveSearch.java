import com.sun.security.jgss.GSSUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExhaustiveSearch {

    private int nAnswer;

    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] arrFirst = {1,2,3,4,5};
        int[] arrSencond = {2,1,2,3,2,4,2,5};
        int[] arrThird = {3,3,1,1,2,2,4,4,5,5};
        int nFirst = 0;
        int nSecond = 0;
        int nThird = 0;

        for(int n = 0 ; n < answers.length ; n++) {
            if (answers[n] == arrFirst[n%5]) nFirst++;
            if (answers[n] == arrSencond[n%8]) nSecond++;
            if (answers[n] == arrThird[n%10]) nThird++;
        }

        Integer[] ret = {nFirst, nSecond, nThird};
        Arrays.sort(ret, Comparator.reverseOrder());

        List<Integer> list = new ArrayList<Integer>();
        if (ret[0] == nFirst) list.add(1);
        if (ret[0] == nSecond) list.add(2);
        if (ret[0] == nThird) list.add(3);

        list.sort(Comparator.naturalOrder());

        return list.stream().mapToInt(i->i).toArray();
    }

    public int solution(String numbers) {
        int answer = 0;
        char[] arrChar = numbers.toCharArray();
        int[] combArr = new int[arrChar.length];

        for(int i = 1; i <= arrChar.length; i++)
            doCombination(combArr, arrChar.length, i, 0, 0, arrChar);

        return answer;
    }

    public void doCombination(int[] combArr, int n, int r, int index, int target, char[] arr){
//        System.out.println( " n : " + n + " r : " + r + " index : " + index + " target : " + target);
        if(r == 0){
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<index; i++) {
//                System.out.print(arr[combArr[i]] + " ");
                sb.append(arr[combArr[i]]);
            }
            System.out.println("sb : " + sb);
            if(bPrimeNumber(Integer.parseInt(sb.toString()))) {
                nAnswer++;
            }
            System.out.println("nAnswer : " + nAnswer);
        }else if(target == n) return;
        else{

            combArr[index] = target;
            doCombination(combArr, n, r-1, index+1, target+1, arr); // (i)
            doCombination(combArr, n, r, index, target+1, arr); //(ii)
        }
    }

    public boolean bPrimeNumber(int num) {
        System.out.println("num : " + num);
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0 && i != num) return false;
        }
        return true;
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int nRet = brown + yellow;
        int n = 3;
        int m = 0;
        while(true) {
            m = nRet / n;
//            if (n < m || n*m != nRet) {
//                n++;
//                System.out.println("n : " + n + " m  " + m + " (n-2) * (n-m) : " + ((n-2) * (m-2)));
//                continue;
//            }
            // m 4 , n 3
            if ( (n >= m) && (n * m == nRet) && ((n-2) * (m-2)) == yellow) {
                System.out.println("n : " + n + " m  " + m + " (n-2) * (n-m) : " + ((n-2) * (m-2)));
                break;
            } else {
                System.out.println("n : " + n + " m  " + m + " (n-2) * (n-m) : " + ((n-2) * (m-2)));
                n++;
                continue;
            }
        }
        answer = new int[2];
        answer[0] = n;
        answer[1] = m;
        return answer;
    }

    public static void main(String[] args) {
        ExhaustiveSearch es = new ExhaustiveSearch();

        //solution 1
        int[] answers = {1,3,2,4,2};
        int[] result;
        result = es.solution(answers);
//        Arrays.stream(result).forEach(n-> System.out.print(n + " "));
//        System.out.println("");

        //solution 2
        String numbers = "17";
        es.nAnswer = 0;
        int nAnswer = es.solution(numbers);
        System.out.println("solution 2 : " + nAnswer);

        //solution 3
        int brown = 24;
        int yellow = 24;
//        result = es.solution(brown, yellow);
//        Arrays.stream(result).forEach(n-> System.out.print(n + " "));

//        System.out.println("");
//        System.out.println("is Prime Number ? : " + es.bPrimeNumber(6));
    }
}
