import java.util.ArrayList;

public class Lesson_1_yjjeon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> binary = new ArrayList<Integer>();
		
        int number = 10000;
        
        int i = 0;
        while(number != 1)
        {
 
            binary.add(number % 2);
            
            number = number/2;
         }
    
        binary.add(number);

        boolean isStart = false;
    	int gapCount = 0;
    	int gapMax = 0;
        
        for (Integer integer : binary) {
        	System.out.println(integer);
        	
        	
        	
        	if (integer == 1) {
        		isStart = true;
        	}
        	
        	if (isStart) {
        		if (integer == 0) {
        			gapCount++;
        		} else {
        			if (gapCount > gapMax) {
        				gapMax = gapCount;
        			}
        			gapCount = 0;
        		}
        	}
        }
        System.out.println("gapMax : "  + gapMax);
	}

}


//you can also use imports, for example:
//import java.util.*;
//import java.util.ArrayList;
//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

//class Solution {
// public int solution(int N) {
//     // write your code in Java SE 8
//     ArrayList<Integer> binary = new ArrayList<Integer>();
//     int number = N;
//     
//     int i = 0;
//     while(number != 1)
//     {
//         binary.add(number % 2);
//         number = number / 2;
//      }
// 
//     binary.add(number);
//
//     boolean isStart = false;
// 	int gapCount = 0;
// 	int gapMax = 0;
//     
//     for (Integer integer : binary) {
//     	
//     	if (integer == 1) {
//     		isStart = true;
//     	}
//     	
//     	if (isStart) {
//     		if (integer == 0) {
//     			gapCount++;
//     		} else {
//     			if (gapCount > gapMax) {
//     				gapMax = gapCount;
//     			}
//     			gapCount = 0;
//     		}
//     	}
//     }
//     return gapMax;
// }
//}