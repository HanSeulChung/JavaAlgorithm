package com.lecture.math.practice1;

import java.util.HashSet;

public class Practice4 {
    public static boolean solution(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(set.add(n)){
            int squreSum = 0;

            while (n > 0){
                int remain = n % 10;
                squreSum += remain * remain;
                n /= 10;
            }

            if (squreSum == 1){
                return true;
            } else {
                n = squreSum;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
}
