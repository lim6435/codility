import java.util.ArrayList;
import java.util.HashMap;

public class Lesson2_1_yjjeon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {9,3,9,3,7};

		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < A.length; i++) {
			if (!map.containsKey(A[i])) {
				map.put(A[i], A[i]);
			} else {
				map.remove(A[i]);
			}
		}
		
		if (map.size() == 1) {
//			return map.values().toArray()[0];
		} else {
//		    return -1;
		}
	}
}
