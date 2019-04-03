
public class Lesson3_3_yjjeon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, 1, 2, 4, 3};
		
		int P = 1;
		int min = -1;
		for (int i = 1; i < A.length; i++) {
			int num1 = 0;
			int num2 = 0;
			
			for (int j = 0; j < i; j++) {
				num1 += A[j];
			}
			
			for (int k = i; k < A.length; k++) {
				num2 += A[k];
			}
			
			int result = num1 - num2;
			
			if (result < 0) {
				result *= -1;
			}
			if (min == -1) {
				min = result;
			} else if (min > result) {
				min = result;
			} else if (result == 0) {
				return 0;
			}
		}
		
		return min;
	}

}
