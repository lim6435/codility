package com;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lesson_5_yrlee {
    public static void main(String[] args) {
//        int[] answers = {1,2,3,4,5}; //1
//        int[] answers = {5, 5, 5, 1, 4, 1}; //1,3
        int[] answers = {3, 3, 1, 1, 1, 1, 2, 3, 4, 5}; // = [1,3]
//        int[] answers = {1,3,2,4,2}; //1,2,3
//        int[] answers = {1,2,5,5,2};
//        int[] answers = {1, 1, 1, 5, 2};
//        int[] answers = {5,4,4,2,1};
        int[] lesson1 = lesson1(answers);
        System.out.println("lesson1====================");
        Arrays.stream(lesson1).forEach(System.out::println);
        System.out.println("===========================");

        String numbers = "46717";
        int lesson2 = lesson2(numbers);
        System.out.println("lesson2====================");
        System.out.println(lesson2);
        System.out.println("===========================");
    }

    public static int[] lesson1(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] answerValue = new int[3];

        IntStream.range(0, answers.length)
                .forEach(idx -> {
                    if(answers[idx] == first[idx%5]) answerValue[0]++;
                    if(answers[idx] == second[idx%8]) answerValue[1]++;
                    if(answers[idx] == third[idx%10]) answerValue[2]++;
                });

        int max = Arrays.stream(answerValue).max().getAsInt();

        ArrayList<Integer> answerList = new ArrayList<>();
        IntStream.range(0, answerValue.length).filter(idx -> max == answerValue[idx]).forEach(idx ->{
            answerList.add(idx+1);

        });
        int[] answer = new int[answerList.size()];
        IntStream.range(0, answerList.size()).forEach(idx ->{
            answer[idx] = answerList.get(idx);
        });
        return answer;
    }

    public static int lesson2(String numbers) {
        int answer = 0;
        String[] numbersValue = numbers.split("");

        ArrayList<String > numbersList = (ArrayList<String>) Arrays.stream(numbersValue).sorted().collect(Collectors.toList());

        return answer;
    }
}
