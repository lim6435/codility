package codility;

import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Lesson5 {
	// 5-4
	// 50%
	public static int solution(int a, int b, int c) {
		int ret = 0;
		for (int i = a ; i <= b ; i++) {
			if (i%c == 0) {
				ret++;
			}
		}
		
		return ret;
	}
	
	// 63%
	public static int solution1(int A, int B, int K) {
		int ret = 0;
		int i = 0;
		for (i = A; i <= B; i++) {
			if (i % K == 0) {
				break;
			}
		}
		
		for (int j = i; j <= B; j+=K) {
			System.out.println(j);
			ret++;
		}
		
		return ret;
	}
	
	//100%
	public static int solution2(int A, int B, int K) {
		int ret = 0;
		ret = B/K - A/K;
		
		if (A%K == 0) {
			ret++;
		}
		
		return ret;
	}
	
	// 5-1
	public static int solution3(int[] A) {
		int ret = 0;
		int weight = 0;
		
		for (int i = 0 ; i < A.length ; i++) {
			if(A[i] == 0 ) {
				weight++;
			}
			else {
				ret = ret + weight;
			}
			if (ret > 1000000000) {
				ret = -1;
				break;
			}
		}
		return ret;
	}
		
	//5-3
	public static int solution4(int[] A) {
		int ret = 0;
		double min = 100000;
		for (int i = 0 ; i < A.length-1; i++) {
			double avg = (A[i] + A[i+1])/2.0;
			System.out.println(avg);
			if (min >= avg) {
				if (min > avg) {
					ret = i;
				}
				min = avg;
				
				if (i== 0) continue;
				if ((A[i-1] + A[i] + A[i+1])/3.0 < min) {
					min = (A[i-1] + A[i] + A[i+1])/3.0;
					ret = i-1;
				}
			}
			
		}
		return ret;
	}
	
	//5-2
	//62%
	public static int[] solution5(String S, int[] P, int[] Q) {
		int idx = P.length;
		int[] ret = new int[idx];
		char minChar;
		
		//System.out.println("idx : " + idx);
		for (int i = 0; i < idx; i++) {
			minChar = 'T';
			for (int j = P[i]; j <= Q[i]; j++) {
				char c = S.charAt(j);
				//System.out.println("minChar : " + minChar + " char : " + c);
				minChar = minChar<=c?minChar:c;
				//System.out.println(minChar);
			}
			ret[i] = minChar=='A'?1:minChar=='C'?2:minChar=='G'?3:4;
			//System.out.println("ret[i] : " + ret[i]);
		}
		return ret;
	}
	
	public static int[] solution6(String S, int[] P, int[] Q) {
		int[] ret = new int[P.length];
		int[] nArr = prefix_sum(S);
		for (int i : nArr) System.out.print(i + " ");
		System.out.println("");
		
		for (int i = 0; i < P.length; i++) {
			ret[i] = (nArr[Q[i]+1] - nArr[P[i]])/ (Q[i] - P[i] +1); 
		}
		
		return ret;
	}
	
	public static int[] prefix_sum(String s) {
		int[] ret = new int[s.length()+1];
		ret[0] = 0;
	
		for (int i = 1; i <= s.length() ; i++) {
			char c = s.charAt(i-1);
			ret[i] = ret[i-1] + (c=='A'?1:c=='C'?2:c=='G'?3:4);
		}
		return ret;
	}
	
	public static int[] prefix_minus(String s) {
		int [] ret = new int[s.length()];
		
		return ret;
	}
		
	public static void main(String[] args) {
		// 5-1 example
//		int[] A = {0,1,0,1,1};
//		int result1 = solution3(A);
//		System.out.println("result1 : " + result1);
		
		// 5-2 example
		// 2,1,3,2,2,4,1
		// 2,3,6,8,10,14,15
		String s = "CAGCCTA";
		int[] P = {2, 5, 0};
		int[] Q = {4, 5, 6};
		int[] ret = solution6(s, P, Q);
		for (int i : ret) System.out.println(i);
		
		// 5-3 example
		int [] A = {4, 2, 2, 5, 1, 5, 8};
		int [] B = {-3, -5, -8, -4, -10};
		int [] C = {10, 10, -1, 2, 4, -1, 2, -1};
		int [] D = {1,1,1,1,1,1,1,1,1,1,1,1,1};
		int [] E = {3, 4, 5, 6, 7};
		//int result = solution4(E);
		//System.out.println("result  : " + result);
		// 5-4 example
//		int result1 = solution2(1, 1, 11);
//		int result2 = solution2(6, 11, 2);
//		int result3 = solution2(11,345,17);
//		int result4 = solution2(0,10000000,1);
//		System.out.println("result1 : " + result1);
//		System.out.println("result2 : " + result2);
//		System.out.println("result3 : " + result3);
//		System.out.println("result4 : " + result4);
	}
}
