package com.codingtest.backjoon;

import java.util.*;

public class BJ1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        LinkedList<Integer> circlelist = new LinkedList<>();
        for(int i =1; i<=N; i++){
            circlelist.add(i);
        }
//        System.out.print(circlelist);
//        System.out.println();

        StringBuilder answer = new StringBuilder();
        answer.append("<");
        int idx = 0;
        while(circlelist.size()>1){
            idx = (idx + (K-1)) % circlelist.size();
            answer.append(circlelist.remove(idx));
            answer.append(", ");
        }
        answer.append(circlelist.remove());
        answer.append(">");
        System.out.println(answer);
    }
}
