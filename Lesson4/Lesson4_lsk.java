package codility;

import java.util.Arrays;

public class Lesson4 {
	// 77%
	// 4-3
	public static int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] ret = new int[N];
        int max = 0;
        
        for (int i = 0; i < A.length; i++) {
            if(A[i] > N) {
            	Arrays.fill(ret, max);
            } else {
            	ret[A[i]-1]++;
            	max = max>ret[A[i]-1]?max:ret[A[i]-1];
                
            }
        }
        return ret;
    }
	
	//88%
	// 4-3
	public static int[] solution1(int N, int[] A) {
        // write your code in Java SE 8
        int[] ret = new int[N];
        int[] mark = new int[N];
        int max = 0;
        int base = 0;
        Arrays.fill(mark, 1);
        
        for (int i = 0; i < A.length; i++) {
            if(A[i] > N) {
            	mark = new int[N];
            	base = max;
            } else {
            	ret[A[i]-1] = mark[A[i]-1]==0?1 + base : ret[A[i]-1]+1;
            	max = max>ret[A[i]-1]?max:ret[A[i]-1];
            	mark[A[i]-1] = 1;
            	
            	//System.out.print("max : " + max + " // base : " + base + " // " );
            	//for(int j : ret) System.out.print(j + " ");
            	//System.out.print(" ");
            	//for(int j : mark) System.out.print(j + " ");
            }
            //System.out.println("");
        }
        for(int j = 0; j < ret.length ; j++) {
        	//System.out.print(ret[j] + " ");
        	if (ret[j] < base) {
        		ret[j] = base;
        	}
        }
        //System.out.println("");
        return ret;
    }
	
	//100%
	// 4-3
	public static int[] solution2(int N, int[] A) {
        // write your code in Java SE 8
        int[] ret = new int[N];
        int[] mark = new int[N];
        int max = 0;
        int base = 0;
        int all = 0;
        
        for (int i = 0; i < A.length; i++) {
            if(A[i] > N) {
            	base = max;
            	all++;
            } else {
            	ret[A[i]-1] = mark[A[i]-1]<all?1 + base : ret[A[i]-1]+1;
            	max = max>ret[A[i]-1]?max:ret[A[i]-1];
            	mark[A[i]-1] = all;
            }
        }
        
        for(int j = 0; j < ret.length ; j++) {
        	if (ret[j] < base) {
        		ret[j] = base;
        	}
        }
        return ret;
    }
	
	//4-1
		public static int solution3(int[] A) {
			int ret = 1;
	        Arrays.sort(A);
	        
	        
	        
	        for(int i = 0 ; i < A.length ; i++) {
	        	System.out.println(i + " // " + A[i]);
	            if (i+1 != A[i]) {
	                ret = 0;
	                break;
	            }
	        }
			
			return ret;
		}
		
		//4-4
		public static int solution4(int[] A) {
			Arrays.sort(A);
	        
	        int ret = 1;
	        int i = 0;
	        int positive = 0;
	        
	        if(A[0] > 1) return 1;
	        
	        for (i = 0; i < A.length-1; i++) {
	        	System.out.println("i : " + i + " // A[i] : " + A[i]+ " // A[i+1] : " + A[i+1]);
	            if (A[i] < 0) continue;
	            positive++;
	            if (A[i+1] - A[i] >= 2) {
	            	System.out.println("i : " + i + " // A[i] : " + A[i]+ " // A[i+1] : " + A[i+1]);
	                ret = A[i] + 1;
	                break;
	            }
	        }
	System.out.println("i : " + i + " // A[i] : " + A[i] + positive);
	        if (i+1 == A.length) {
	        	if(positive == 0) {
	        		ret = A[i]<0?ret:A[i]>ret?ret:A[i]+1;
	        	}
	        	else {
	        		ret = (A[i] + 1)<1?1:(A[i] + 1);
	        	}
	            
	        }
	        
	        return ret;
		}
		
	public static void main(String[] args) {
		int[] A = {3, 4, 4, 6, 1, 4, 4}; // 4-3
		int[] B = {4,1,3,2}; // 4-1
		int[] C = {1, 3, 6, 4, 1, 2}; // 4-4
		int[] C1 = {1}; // 4-4
		
//		int[] result = solution2(5, A);
//		for (int i : result) {
//			System.out.println(i);
//		}
//		
//		int result1 = solution3(B);
//		System.out.println("result1 : " + result1);
		
		int result2 = solution4(C1);
		System.out.println("result2 : " + result2);
	}
}
