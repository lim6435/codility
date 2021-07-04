import java.util.*;

public class Greedy {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 정답은 전체 길이에서 잃어버린 사람을 빼고 시작함.
        answer = n - lost.length;
        List<Integer> lLost = new ArrayList<>();
        Queue<Integer> lReserve = new LinkedList<>();
        // 인입되는 배열이 정렬이 되어 있지 않아 우선순위가 달라지는 경우를 대비해 정렬.
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int m : lost) lLost.add(m);
        for(int m : reserve) lReserve.add(m);

        // 여분있 사람이 도난을 당하는 경우, 제외.
        for(int i = 0; i < reserve.length; i++ ) {
            int nVal = lReserve.peek();
            int nIdx = lLost.indexOf(lReserve.poll());
//            System.out.println("nVal : " + nVal + " nIdx : " + nIdx);
            if (nIdx >= 0) {
                lLost.remove(nIdx);
                answer++;
            } else {
                lReserve.add(nVal);
            }
//            for(int j : lLost) System.out.print(" lLost : " + j);
//            System.out.println("");
        }

        // 여분 옷 분배.
        for(int m : lReserve) {
//            System.out.println("m : " + m);
            if (lLost.indexOf(m-1) >= 0) {
                lLost.remove(lLost.indexOf(m-1));
                answer++;
                continue;
            } else if (lLost.indexOf(m+1) >= 0) {
                lLost.remove(lLost.indexOf(m+1));
                answer++;
                continue;
            }
        }
        return answer;
    }

    public String solution(String number, int k) {
        String answer = "";

        // 전체 길이에서 k 를 제외하고 최대수 구하기. (4177252841, 4 일 경우 전체 길이 10 - 4 - 1 = 5. 앞에서 부터 5자리에서 최대 수 구하기. -1 은 비교해야 하는 대상 까지 포함)
        // 최대 수 구하고 이외의 수 제거. 제거 한 수가 k 가 될때까지 반복.
        // 제외 함수 만드어 반복함.

        int nRemove = 0; // 제거한 수
        StringBuffer sb = new StringBuffer();
        int nRetLen = number.length() - k;
        while(true) {
            String strTarget = number.substring(0, (k - nRemove)+1);
            System.out.println("strTarget : " + strTarget);
            char[] arrc = strTarget.toCharArray();
            Arrays.sort(arrc);
            sb.append(arrc[arrc.length-1]);
            System.out.println("sb : " + sb);
            int nIdx = number.indexOf(arrc[arrc.length-1]);
            nRemove += nIdx;
            System.out.println("nRemove : " + nRemove);
            number = number.substring(nIdx+1);
            System.out.println("number : " + number);
            // 제거한 수가 k 와 같으면, 반복문 탈출.
            if (nRemove == k || sb.length() == nRetLen) {
                sb.append(number);
                break;
            }

            //break;
        }

        return sb.toString();
    }

    public String solution1(String number, int k) {
        //String answer = "";
        StringBuilder sb = new StringBuilder(number);

        for (int i = 0 ; i < k ; i++) {
            int nIdx = sb.length()-1;
            for(int j = 0 ; j < sb.length() -1 ; j++) {

                if (sb.charAt(j) < sb.charAt(j+1)) {
                    nIdx = j;
                    break;
                }
            }
            sb.deleteCharAt(nIdx);
            System.out.println(sb.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Greedy greedy = new Greedy();

        //solution 1 10 [5,4,3,2,1] [3,1,2,5,4]
        int n = 10;
        int[] lost={5,4,3,2,1};
        int[] reserve={3,1,2,5,4};
        int answer = 0;
        answer = greedy.solution(n, lost, reserve);
        System.out.println("solution1 : " + answer);

        //solution 2
        String number = "4177252841"; // 775841
        int k = 4;

        //test
//        number = "1924";
//        k = 2;
        String strAnswer = greedy.solution(number, k);
        System.out.println("solution2 : " + strAnswer);
    }
}
