package com.codingtest.backjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BJ1021 {
    public static void main(String[] args) {
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int count = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        IntStream.range(1,N+1).forEach( x-> deque.offer(x));
//        for(int i =1; i<= N; i++ ){
//            deque.offer(i);
//        }
        System.out.println(deque);

        int[] wantednumList = new int[M];
        for(int i =0; i<M; i++){
            wantednumList[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(wantednumList));

        for (int i = 0; i < M; i++) {
            int targetIdx = deque.indexOf(wantednumList[i]);
            int halfIdx;

            if(deque.size() % 2==0){
                halfIdx = deque.size()/2 -1;
            }else{
                halfIdx = deque.size()/2;
            }
            
            if(targetIdx <= halfIdx){
                for (int j = 0; j < targetIdx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            } else{
                for (int j = 0; j < deque.size() - targetIdx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(count);
    }
}
