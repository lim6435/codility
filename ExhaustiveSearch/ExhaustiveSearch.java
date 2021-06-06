import com.sun.security.jgss.GSSUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExhaustiveSearch {

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
        return answer;
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
            if ( (n >= m) && ((n-2) * (m-2)) == yellow) {
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
        Arrays.stream(result).forEach(n-> System.out.print(n + " "));

        //solution 2
        String numbers = "17";
        int nAnswer = es.solution(numbers);
        System.out.println("solution 2 : " + nAnswer);

        //solution 3
        int brown = 24;
        int yellow = 24;
        result = es.solution(brown, yellow);
        Arrays.stream(result).forEach(n-> System.out.print(n + " "));
    }
}
