package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lesson_4_yrlee {
    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 3};
        int[][] commanmds = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Integer[] answer1 = lesson1(array, commanmds);
        System.out.println("lesson1 : =========");
        Arrays.stream(answer1).forEach(System.out::println);
        System.out.println("=====");
        int[] numbers = {3, 30, 34, 5, 9 };
        String answer2 = lesson2(numbers);
        System.out.println("lesson 2: " + answer2);
    }

    public static Integer[] lesson1(int[] array, int[][] commands) {

        ArrayList<Integer> answerList = new ArrayList<>();

        Arrays.stream(commands).forEach(item ->{
            ArrayList<Integer> arrayList = new ArrayList<>();
            IntStream.range(0, array.length)
                    .filter(i -> item[0]-1 <= i && item[1]-1 >= i)
                    .forEach(subItem -> {
                        arrayList.add(array[subItem]);
                    });
            arrayList.sort(Integer::compareTo);
            answerList.add(arrayList.get(item[2]-1));

        });

        Integer[] answer = answerList.toArray(new Integer[answerList.size()]);
        return answer;
    }

    public static String lesson2(int[] numbers) {
        String answer = "";
        answer = Arrays.stream(Arrays.toString(numbers).split("[\\[\\]]")[1].split(", ")).sorted((o1, o2) -> (o2+o1).compareTo(o1+o2)).collect(Collectors.joining());
//        Arrays.stream(Arrays.toString(numbers).split("[\\[\\]]")[1].split(", ")).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return answer.startsWith("0")?"0":answer;
    }

}
