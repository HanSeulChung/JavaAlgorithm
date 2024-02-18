package com.codingtest.zerobaseschool.코딩테스트2주차;

import java.util.*;
public class P4 {
    public static int solution(int delay, int capacity, int[] times) {
        int answer = 0;
        int addtime = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int time : times){
            addtime += time;
            queue.add(time);
            if (queue.size() == capacity){
                answer++;
            }
            if (addtime % 5 == 0){
                queue.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] times = {};
        System.out.println(solution(5, 5, times));
    }
}
