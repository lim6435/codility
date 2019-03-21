// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String binary = Integer.toBinaryString(N);
        
		int min = -1;
		int gap = 0;
		for(int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				if (min == -1) {
					min = i;
				}
				else {
				    
					gap = gap > i - min-1?gap:i-min-1;
					min = i;
				}
			}
		}
		return gap;
    }
}