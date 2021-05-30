import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        for (int[] com : commands) {
            int[] arr = new int[com[1]-com[0]+1];
            System.arraycopy(array,com[0]-1,arr,0,arr.length);
            Arrays.sort(arr);
//            Arrays.stream(arr).forEach(n-> System.out.print(n + " "));
//            System.out.println(" com : " + (com[2]-1));
            list.add(arr[com[2]-1]);
        }
        answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }

    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Collections.sort(Arrays.asList(arr), (s1, s2)-> (s2+s1).compareTo(s1+s2));
//        Collections.sort(Arrays.asList(arr));
        answer = Arrays.stream(arr).collect(Collectors.joining());
        answer = answer.startsWith("0")?"0":answer;
        return answer;
    }


    public int solution3(int[] citations) {
        int answer = citations.length;
        Arrays.sort(citations);
        int cnt = 1;
        for(int n = citations.length-1 ; n >= 0 ; n--) {
//            System.out.println("a : " + citations[n] + " b : " + cnt);
            if (citations[n] == cnt) {
                answer = citations[n];
                break;
            } else if (citations[n] < cnt) {
                answer = --cnt;
                break;
            }
            cnt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();

        //solution 1
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer;
        answer = sort.solution(arr, command);
//        System.out.println("solution1 : ");
//        Arrays.stream(answer).forEach(n-> System.out.print(n + " "));
//        System.out.println("");

        //solution 2
//        int[] arr1 = {6,10,2};
        int[] arr1 = {3, 30, 34, 5, 9};

        String answer1 = "";
        answer1 = sort.solution(arr1);
        System.out.println("solution2 : " + answer1);
        System.out.println("");

        //solution 3
//        int[] citations = {3, 0, 6, 1, 5};
        int[] citations = {10, 9, 4, 1, 1};
        int iAnswer = 0;
        iAnswer = sort.solution3(citations);
        System.out.println("solution3 : " + iAnswer);
    }
}
