package com.test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Lesson_3_yrlee {
    public static void main(String[] args) {
//        String[] operations = {"I 16","D 1"};
//        String[] operations = {"I 7","I 5","I -5","D -1"};
//        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        //기댓값 〉	[333, -45]
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
//        기댓값 〉	[0, 0]
        lesson3(operations);
    }

    public static int[] lesson3(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> itemList = new ArrayList<>();
        Arrays.stream(operations)
                .forEach(item -> {
                    String[] s = item.split(" ");
                    if(s[0].equals("D") && Integer.valueOf(s[1]) > 0 && itemList.size() != 0) {
                        //Max Remove
                        itemList.remove(itemList.indexOf(Collections.max(itemList)));
//                        System.out.println(Collections.max(itemList) + " : " + Collections.min(itemList));
                    } else if(s[0].equals("D") && Integer.valueOf(s[1]) < 0 && itemList.size() != 0 ) {
                        //Min Remove
                        itemList.remove(itemList.indexOf(Collections.min(itemList)));
//                        System.out.println(Collections.max(itemList) + " : " + Collections.min(itemList));
                    } else if(!s[0].equals("D")) {
                        itemList.add(Integer.valueOf(s[1]));
                    }

        });
        if(itemList.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = Collections.max(itemList);
            answer[1] = Collections.min(itemList);
        }
        System.out.println("MAX : " + answer[0] + ", MIN : " + answer[1]);
        return answer;
    }
}
