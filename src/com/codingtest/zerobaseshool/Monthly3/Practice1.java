package com.codingtest.zerobaseshool.Monthly3;

import java.util.*;

class Point {
    int start;
    int finish;

    public Point(int start, int finish){
        this.start = start;
        this.finish = finish;
    }
}

public class Practice1 {
    public static int solution(int[] arrive, int[] patience) {
        int answer = 0;

        PriorityQueue<Point> pq = new PriorityQueue<>( (x, y) -> {
            int a = x.start;
            int b = y.start;
            if(a == b) {
                return (x.finish - x.start) > (y.finish - y.start) ? 1 : -1;
            }
            return a - b;

        });

        for (int i = 0; i < arrive.length; i++){
            pq.offer(new Point(arrive[i], arrive[i] + patience[i]));
        }


        while(pq.size() >= 2){
            Point first = pq.poll();
            Point second = pq.poll();

            if (first.finish >= second.start){
                answer = answer + 2;
            } else {
                pq.offer(new Point(second.start, second.finish));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arrive = {12, 4, 5, 2, 7, 16};
        int[] patience = {4, 6, 1, 3, 3, 2};
        System.out.println(solution(arrive, patience));
    }
}