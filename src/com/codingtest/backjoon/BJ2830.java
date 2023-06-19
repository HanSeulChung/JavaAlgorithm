package com.codingtest.backjoon;

// 생각 다시 정리해서 다시 풀어보기 ..
import java.util.Arrays;
import java.util.Scanner;
public class BJ2830 {

    public static int value(int[] list){
        int answer = 0;


        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numlist = new int[N];
        for(int i =0; i < N; i++){
            String tmp = Integer.toBinaryString(sc.nextInt());
            numlist[i] = Integer.parseInt(tmp, 2);
        }
        System.out.println(Arrays.toString(numlist));

        //System.out.println(value(numlist));
    }
}
