import java.lang.reflect.Array;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Stack_Queue {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int fin = 0;
        int prevJob = 0;
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int jobDay = (int) Math.ceil((100 - progresses[i]) / (double)speeds[i]);
//            System.out.println(jobDay);

            if (prevJob == 0) {
                fin++;
                prevJob = jobDay;
            } else {
                if (prevJob >= jobDay) {
                    fin++;
                } else {
                    ret.add(fin);
                    fin = 1;
                    prevJob = jobDay;
                }
            }
        }

        ret.add(fin);

        answer = new int[ret.size()];
        fin = 0;
        for (int n : ret) answer[fin++] = n;

        return answer;
    }

    //{1,1,9,1,1,1}
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < priorities.length ; i++) {
            q.add(i);
        }

        int head = 0;
        int next = 0;
        while (true) {
//            System.out.println("q is " + q);
            head = q.poll();

            for(int n : q) {
                if (priorities[head] < priorities[n]) {
                    q.add(head);
                    break;
                }
                next++;
            }

//            System.out.println("head : " + head + " next : " + next + " q.size : " + q.size());
            if (next == q.size()) {
                answer++;

                if (head == location) break;
            }
            next= 0;

        }
        return answer;
    }

//    2	10	[7,4,5,6]
//    100 100 [10]
//    3   5   [4]
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {

            weight -= truck_weights[i];
            q.add(truck_weights[i]);
            if(weight > 0) {
            } else {
                answer += bridge_length;
                weight += q.poll();
                answer++;
            }
            System.out.println("q : " + q + " answer : " + answer);
        }

        if (q.size() > 0) {
            if (answer == 0) answer+= bridge_length;
            //answer += bridge_length;
            for (int n : q) {
                answer++;
            }
        }
        return answer;
    }

//    2	10	[7,4,5,6]
    public int solution1(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int n : truck_weights) q.add(n);
        q.add(0);

        int nowTruck = q.poll();
        while (true) {
            answer++;

            int truck = 0;
            int[] bridge = new int[bridge_length];
            for (int i = 0; i<bridge.length; i++) {
//                System.out.println("nowTruck : " + nowTruck);
                if (i > 0) {
                    answer++;
//                    System.out.println("i : " + i);
//                    for (int n : bridge) System.out.print(n + " ");
//                    System.out.println("");
                    for (int j = i ; j > 0 ; j--) {
                        bridge[j] = bridge[j - 1];
                        bridge[j - 1] = 0;
                    }
                }

                truck += nowTruck;
                if (weight > truck) {

                    bridge[0] = nowTruck;
                    if (q.size() > 0)
                        nowTruck = q.poll();

                } else {

                }
                System.out.println("answer " + answer);
                for (int n : bridge) System.out.print(n + " ");
                System.out.println("");
            }

            if (q.size() == 0 ) {
                for(int n : bridge) {
                    if (n > 0) answer++;
                }
                break;
            }
        }


        return answer;
    }

//    {1,2,3,2,3}
//{1, 2, 3, 2, 3, 1} return {5, 4, 1, 2, 1, 0}
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];

        for (int i = 0 ; i < prices.length-1 ; i++) {
            answer[i] = 0;
            for (int j = i+1 ; j < prices.length ; j++) {
                answer[i]++;
//                System.out.println("i : " + i + " j : " + j + " answer : " + answer[i]);
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        Stack_Queue sq = new Stack_Queue();

        // solution 1
        int[] progresses = {93, 30, 55};
//        int[] progresses = {99, 99, 99};
//        int[] progresses = {95, 90, 99, 99, 80, 99};

        int[] speeds = {1, 30, 5};
//        int[] speeds = {1, 1, 1};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] answer = {};

        answer = sq.solution(progresses, speeds);
        System.out.print("solutino1 answer is : ");
        for (int nJob : answer) System.out.print(nJob + " ");
        System.out.println("");


        //solution 2
//        int[] priorities = {2,1,3,2};
//        int location = 2;
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        int nAnswer = 0;
        nAnswer = sq.solution(priorities, location);
        System.out.println("solution2 answer is : " + nAnswer);

        //solution 3
        int bridge_length = 2;
        int weight = 10;
//        int[] truck_weights = {10,10,10,10,10,10,10,10};
        int[] truck_weights = {7,4,5,6};
        nAnswer = sq.solution1(bridge_length, weight, truck_weights);
        System.out.println("solution3 answer is : " + nAnswer);

        //solution 4
//        int[] prices = {1,2,3,2,3};
        int[] prices = {1, 2, 3, 2, 3, 1}; // 5 3 1 1 0 0
        answer = sq.solution(prices);
        System.out.print("solutino1 answer is : ");
        for (int nJob : answer) System.out.print(nJob + " ");
        System.out.println("");
    }
}
