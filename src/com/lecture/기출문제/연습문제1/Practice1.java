package com.lecture.기출문제.연습문제1;

import java.util.Arrays;

public class Practice1 {
    public static int mysolution(int[] appleTrees, int a, int b) {
        int answer = 0;
        for (int appleTree : appleTrees) {
            int tmp = appleTree  - a;
            if (tmp != 0) {
                while (tmp < b) {
                    answer += 1;
                    tmp %= b;
                }
                answer += 1;
            } else {
                answer +=1;
            }
        }
        return answer;
    }
    public static int solution(int[] appleTrees, int a, int b) {
        int result = appleTrees.length;

        for (int i = 0; i < appleTrees.length; i++) {
            appleTrees[i] -= a;

            while (appleTrees[i] > 0) { // 비효율적임. 대량의 입력값에서는
                appleTrees[i] -= b;
                result++;
            }
        }
        return result;
    }

    public static int solution2(int[] appleTrees, int a, int b) {
        int result = appleTrees.length;

        for (int i = 0; i < appleTrees.length; i++) {
            appleTrees[i] -= a;

            if (appleTrees[i] > 0) {
                result += appleTrees[i] / b;

                if (appleTrees[i] % b != 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] appleTrees = new int[] {1, 2, 3};
        System.out.println(solution(appleTrees, 1, 1));
        appleTrees = new int[] {1, 2, 3};
        System.out.println(solution2(appleTrees, 1, 1));
        appleTrees = new int[] {1, 2, 3};
        System.out.println(mysolution(appleTrees, 1, 1));

        System.out.println();
        appleTrees = new int[]{10, 10, 20, 20, 30, 30};
        System.out.println(solution(appleTrees, 5, 3));
        appleTrees = new int[]{10, 10, 20, 20, 30, 30};
        System.out.println(solution2(appleTrees, 5, 3));
        appleTrees = new int[]{10, 10, 20, 20, 30, 30};
        System.out.println(mysolution(appleTrees, 5, 3));

        System.out.println();
        appleTrees = new int[100000];
        Arrays.fill(appleTrees, 100000);

        long start = System.currentTimeMillis();
        System.out.println(solution(appleTrees, 1, 1));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");

        Arrays.fill(appleTrees, 100000);
        start = System.currentTimeMillis();
        System.out.println(solution2(appleTrees, 1, 1));
        end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}
