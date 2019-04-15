package codility;

import java.util.Arrays;

public class Lesson6 {
		
	// 6-1
	// 100%
	private static int solution(int[] A) {
		// TODO Auto-generated method stub
		Arrays.sort(A);
		int ret = 1;
		
		for(int i = 0; i < A.length-1; i++) {
			if (A[i] != A[i+1]) {
				ret++;
			}
		}
		return A.length>0?ret:0;
	}
	
	// 6-2
	private static int solution1(int[] A) {
		int ret = 0;
		Arrays.sort(A);
		if (A[0]*A[1] < A[A.length-2]*A[A.length-3] || A[A.length-1] < 0) {
			ret = (A[A.length-1]*A[A.length-2]*A[A.length-3]);
		}
		else {
			ret = A[0]*A[1] * A[A.length-1];
		}
		return ret;
	}
	
	// 6-3
//	A[P] + A[Q] > A[R],
//	A[Q] + A[R] > A[P],
//	A[R] + A[P] > A[Q].
	private static int solution2(int[] A) {
		// 정렬했을 경우, 앞의 두 수 합이 세번째 수보다 크면 트라이앵글 형성 가능. 
		int ret = 0;
		Arrays.sort(A);
		
		for(int i = 0 ; i < A.length-2 ; i++) {
			long val = Long.valueOf(A[i]) + Long.valueOf(A[i+1]);
			if (val > A[i+2]) {
				ret = 1;
				break;
			}
		}
		
		return ret;
	}

	public static void main(String[] args) {
		// 6-1 example
//		int[] A = {2,1,1,2,3,1};
//		int[] A = {1};
//		int result1 = solution(A);
//		System.out.println("result1 : " + result1);
		
		// 6-2 example
//		int[] A = {4,7,3,2,1,-3,-5};
//		int[] A = {-5,-6,-4,-7,-10};
//		int[] A = {-3,1,2,-2,5,6};
//		int[] A = {-10,1,2,-8,5,6};
//		int result1 = solution1(A);
//		System.out.println("result1 : " + result1);
		
		// 6-3 example
//		int[] A = {10,2,5,1,8,20};
		int[] A = {10, 50, 5, 1};
//		int[] A = {2147483447, 2147483547, 2147483647};
		int result2 = solution2(A);
		System.out.println("result2 : " + result2);
	}

}
