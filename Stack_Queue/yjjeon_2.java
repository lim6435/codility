import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        answer = 1;
        int printIndex = 0;
        while (true) {
            boolean printalbe = true;
            int print = queue.poll();
            for (int j = 0; j < priorities.length; j++) {
                if (priorities[j] > print) {
                    printalbe = false;
                    queue.add(print);
                    if (location == 0) location = queue.size() - 1;
                    else location--;
                    break;
                }

                if (priorities[j] == print) printIndex = j;
            }

            if (printalbe) {
                if (location == 0) break;
                location--;
                answer++;
                priorities[printIndex] = 0;
            }
        }

        return answer;
    }
}