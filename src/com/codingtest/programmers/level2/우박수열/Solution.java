package com.codingtest.programmers.level2.우박수열;

import java.util.*;

public class Solution {
    public static int collatz(int k){
        int cnt =0;
        while(k!=1){
            if(k%2==0){
                k /=2;
            } else {
                k = k *3 +1;
            }
            cnt++;
        }
        return cnt;
    }

    public static double[] collatzareas(int k, int cnt){
        double[] areas = new double[cnt];
        int idx = 0;
        while(k!=1){
            int prek = k;
            if(k%2==0){
                k /=2;
            } else {
                k = k *3 +1;
            }
            areas[idx++] = (prek+k)/2.0;
        }
        return areas;
    }

    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        int cnt = collatz(k);
        double[] areas = {};
        areas = collatzareas(k, cnt);


        double[] prefixSum = new double[cnt+1];
        prefixSum[1] = areas[0];
        for(int i=2; i<cnt+1; i++){
            prefixSum[i] = (areas[i-1] + prefixSum[i-1]);
        }

        for(int i =0; i<ranges.length; i++){
            int a = ranges[i][0];
            int b = ranges[i][1];
            int newb = cnt + b;

            if(a>newb){
                answer[i] = -1.0;
            } else if (a==newb){
                answer[i] = 0.0;
            } else{
                answer[i] = prefixSum[newb] - prefixSum[a];
            }


        }
        return answer;
    }
    public static void main(String[] args) {
        int k =5;
        int[][] ranges= {{0,0}, {0, -1}, {2, -3}, {3, -3}};
        System.out.println(Arrays.toString(solution(5, ranges)));

    }
}

//public class Solution {
//    public static double[] solution(int k, int[][] ranges) {
//        double[] answer = new double[ranges.length];
//        int cnt = 0;
//
//        ArrayList<Double> areas = new ArrayList<>();
//        while(k!=1){
//            int prek = k;
//            if(k%2==0){
//                k /=2;
//            } else {
//                k = k *3 +1;
//            }
//            areas.add(Math.min(prek,k)+ Math.abs(prek-k)/2.0);
//            cnt++;
//        }
//        System.out.println(areas);
//        //System.out.println(cnt); cnt는 area 갯수
//        int answeridx = 0;
//        for(int[] range : ranges){
//            int a = range[0];
//            int b = range[1];
//            if(a==0 && b==0){
//                for(int i =0; i<areas.size(); i++){
//                    answer[answeridx] += areas.get(i);
//                }
//            } else {
//                int newb = cnt + b;
//                if(a>newb){
//                    answer[answeridx] = -1.0;
//                } else if (a==newb){
//                    answer[answeridx] = 0.0;
//                } else{
//                    for(int i =a; i<newb ; i++){
//                        answer[answeridx] += areas.get(i);
//                    }
//                }
//            }
//            answeridx++;
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        int k =5;
//        int[][] ranges= {{0,0}, {0, -1}, {2, -3}, {3, -3}};
//        System.out.println(Arrays.toString(solution(5, ranges)));
//
//    }
//}
