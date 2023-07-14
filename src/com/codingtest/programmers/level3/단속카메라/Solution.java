package com.codingtest.programmers.level3.단속카메라;
// 그리디

import java.util.*;
public class Solution {

    public static int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1] , b[1]));
        int min = Integer.MIN_VALUE;
        for (int[] route : routes){
            if(min < route[0]){
                min = route[1];
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-17,-3}};
        System.out.println(solution(routes));
    }
}
