// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] ret = new int[A.length];
		
		for (int n = 0; n < A.length; n++) {
			ret[(n+K)%A.length] = A[n];
		}
		
		return ret;
    }
}