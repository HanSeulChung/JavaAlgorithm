package com.lecture.알고리즘.연습문제1;

public class Practice4 {

    final static int numOfTree = 2;

    public static int solution(int[] order, int k) {
        if (order == null || order.length == 0) {
            return -1;
        }

        int n = order.length;
        int [][][] dp = new int[k + 2][numOfTree + 1][n];  // [k + 1개 초기값 0부터 시작이니까> k+2]

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k + 2; j++) {
                if (order[i] == i){
                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][2][i + 1]) + 1;
                    dp[j][2][i] = Math.max(dp[j][2][i - 1], dp[j - 1][1][i + 1]); // 테이블 그려보면 구현할수 있음 직접 이렇게 한번에 구현 못함
                } else {
                    if (i == 1 && j == 1){
                        continue;
                    } 
                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][2][i - 1]);
                    dp[j][2][i] = Math.max(dp[j][2][i - 1], dp[j - 1][1][i - 1]) + 1;
                }
            }
        }
        
        int result = 0;
        for (int i = 1; i < k + 2; i++) {
            result = Math.max(result, Math.max(dp[i][1][n - 1], dp[i][2][n - 1]));
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] order = {2, 1, 1, 2, 2, 1, 1};
        int k = 2;
        System.out.println(solution(order, k));
    }
}

