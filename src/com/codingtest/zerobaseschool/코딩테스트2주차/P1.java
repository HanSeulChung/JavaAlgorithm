package com.codingtest.zerobaseschool.코딩테스트2주차;

import java.util.*;

public class P1 {
    public static int solution(int[] numbers) {
        int answer = 0;
        //HashSet<Integer> set = (HashSet<Integer>)Arrays.stream(numbers).boxed().collect(Collectors.toSet());
//        Arrays.sort(numbers);
//        int minN = numbers[0];
//        HashSet<Integer> set = new HashSet<>();
//        for (int number : numbers) {
//            set.add(number);
//        }
//
//        for (int i = minN + 1; i < numbers[numbers.length -1]; i++) {
//            if (!set.contains(i)){
//                return i;
//            }
//        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int number : numbers) {
            queue.add(number);
        }
        Arrays.sort(numbers);
        int minN = numbers[0];
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            if ( minN != tmp) {
                return tmp -1;
            }
            minN++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {9, 4, 2, 3, 7, 5};
        System.out.println(solution(numbers));
    }
}
