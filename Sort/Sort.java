import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
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

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer;
        answer = sort.solution(arr, command);
        Arrays.stream(answer).forEach(n-> System.out.print(n + " "));
    }
}
