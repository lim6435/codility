import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
   public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();

        int ret = 1;
        int firstDeploy = 0;
        boolean addFlag = false;
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int dayToDeploy = remain / speeds[i];
            if (remain % speeds[i] != 0) dayToDeploy++;

            if (firstDeploy == 0) {
                firstDeploy = dayToDeploy;
                continue;
            }

            if (firstDeploy < dayToDeploy) {
                firstDeploy = dayToDeploy;
                result.add(ret);
                ret = 1;
            } else {
                ret++;
            }
        }
        result.add(ret);

        return result.stream().mapToInt(x->x).toArray();
    }
}