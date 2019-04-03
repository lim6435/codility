
public class Lesson2_2_yjjeon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 3, 4};
		
		int K = 5;
		
		int shift = K % A.length;
		
		int[] result = new int[A.length];
		
		for (int i = 0; i < A.length; i++) {
			int index = i + shift;
			if (index > A.length - 1) {
				index = index - A.length - 1;
			}
			result[index] = A[i];
		}
	}

}
