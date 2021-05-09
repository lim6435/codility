package com.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lesson_1_yrlee {
    public static void main(String[] args) throws Exception {

//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};


//        String answer = level1(participant, completion);
        String answer = level1_1(participant, completion);

        System.out.println(answer);

//        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"123","456","789"};
        boolean result = level2(phone_book);
        System.out.println(result);


//        String[][] clothes = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
//        String[][] clothes = {{"a", "aa"},{"b", "bb"},{"c", "aa"},{"d", "bb"},{"e", "bb"},{"f", "aa"},{"g", "cc"},{"h", "cc"},{"i", "aa"}};
        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        int cnt = level3(clothes);
        System.out.println(cnt);

    }

    public static String level1(String[] participant, String[] completion) {
        List<String> parList = new ArrayList<>(Arrays.asList(participant));
        List<String> comList = new ArrayList<>(Arrays.asList(completion));
          Arrays.stream(participant)
                  .parallel()
                  .filter(e -> !comList.contains(e))
                  .forEach(item -> {
                      if(comList.indexOf(item)!= -1) {
                          comList.remove(comList.indexOf(item));
                          parList.remove(parList.indexOf(item));
                      }
            });

        return parList.get(0);
    }


    public static String level1_1(String[] participant, String[] completion) {
        if(participant.length > 100000 || participant.length == 0) {
            return null;
        }
        List<String> parList = new ArrayList<>(Arrays.asList(participant));
        List<String> comList = new ArrayList<>(Arrays.asList(completion));
        parList.sort(String::compareTo);
        comList.sort(String::compareTo);
        for(int i=0;i<comList.size();i++) {
            if( !parList.get(i).equals(comList.get(i)) ) {
                return parList.get(i);
            }
        }
        return parList.get(parList.size()-1);

    }

    public static boolean level2(String[] phone_book) {
        boolean answer = true;
        List<String> phone = new ArrayList<>(Arrays.asList(phone_book));
        phone.sort(String::compareTo);

        for(int i=1;i<phone.size();i++) {
            if( phone.get(i).startsWith(phone.get(i-1)) ) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    public static int level3(String[][] clothes) {
        int answer = 0;
        Map<String, String> map = new HashMap<>();

        for(int i=0;i<clothes.length;i++) {
            map.put(clothes[i][0], clothes[i][1]);
        }

        int c = 1;
        Map<String, Long> groupByClothes = map.values().stream().
                collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        Iterator<String> keys = groupByClothes.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            c = (Integer.valueOf(groupByClothes.get(key).toString())+1) * c;
        }

        answer = c - 1;
        return answer;
    }

}
