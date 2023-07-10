package com.lecture.알고리즘.연습문제2;

import java.util.ArrayList;

public class Practice2 {
    public static void solution(int n) {
        int p1 = 1;
        int p2 = 1;

        ArrayList result = new ArrayList();
        while (true) {
            int diff = p1 * p1 - p2 * p2;
            if ( p1 - p2 == 1 && diff > n) {
                break;
            }

            if (diff < n){
                p1++;
            } else {
                p2++;
            }

            if (diff == n) {
                result.add(p1);
            }
        }

        if (result.size() != 0){
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(15);
    }
}
