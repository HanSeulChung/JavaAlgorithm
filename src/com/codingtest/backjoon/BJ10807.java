package com.codingtest.backjoon;
/**
* @package : com.codingtest.backjoon
* @name : BJ10807.java
* @date : 2023-06-19 오후 4:55
* @author : HSChung
* @version : 1.0.0
* @modifyed :
**/

import java.util.Arrays;
import java.util.Scanner;
public class BJ10807 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int N = sc.nextInt();
        int[] numberlist = new int[N];
        for(int i =0; i<N; i++){
            numberlist[i]=sc.nextInt();
        }
        int findN = sc.nextInt();

        for(int number:numberlist){
            if(number == findN){
                answer++;
            }
        }
        System.out.println(answer);


    }
}
