import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int temp = 0;

        Arrays.sort(people);
        int maxIndex = people.length - 1;
        int minIndex = 0;

        while (true) {
            temp += people[minIndex] + people[maxIndex];

            if (temp > limit) {
                maxIndex--;
            } else {
                maxIndex--;
                minIndex++;
            }

            answer++;
            temp = 0;

            if (minIndex > maxIndex) break;
        }

        return answer;
    }
}