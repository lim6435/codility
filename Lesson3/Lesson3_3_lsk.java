package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Lesson3 {
	public static int solution(int[] A) {
        // write your code in Java SE 8
		int ret = 0;

		for(int i = 0 ; i < A.length-1 ; i++) {
			int temp = 0 ; 
			for (int j = 0 ; j < A.length ; j++) {
				
				temp += i>=j?A[j]*-1:A[j];
				
				System.out.println("temp : " + i + " " + j + " " + temp);
			}
			
			ret = i==0?Math.abs(temp):ret<Math.abs(temp)?ret:Math.abs(temp);
		}
		return ret;
    }
	
	public static int solution1(int[] A) {
        // write your code in Java SE 8
		int ret = -1;
        for (int i = 0; i < A.length-1; i++) {
            int sum1 = Arrays.stream(A, 0, i+1).sum();
            int sum2 = Arrays.stream(A, i+1, A.length).sum();
            int tot = Math.abs(sum1-sum2);
            System.out.println(tot);
            ret = ret==-1?tot:ret < tot?ret:tot;
            
        }
        
        return ret;
    }
	
	public static int solution2(int[] A) {
		// write your code in Java SE 8
        int min = 0;
        //int max = Arrays.stream(A,0,A.length).sum();
        int max = IntStream.of(A).sum();
        System.out.println(min + " // " + max);
        int ret = -1;
        for(int i = 0 ; i < A.length-1 ; i++){
            min = min + A[i];
            max = max - A[i];
            System.out.println(min + " // " + max);
            
            int abs = Math.abs(min - max);
            System.out.println(abs);
            ret = ret==-1?abs:ret>abs?abs:ret;
        }
        
        return ret;
	}
	

	public static void main(String[] args) {
		int[] A = {-1000, 1000};
		
		int result = solution2(A);
		System.out.println("ret : " + result);
	}
}
