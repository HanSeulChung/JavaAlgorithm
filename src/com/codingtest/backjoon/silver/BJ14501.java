package com.codingtest.backjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501{
    static int _n;
    static int[] _days;g
    static int[] _prices;
    static int result;
    public static int solution2(int[] days, int[] prices, int n) {
        _n = n;
        _days = days.clone();
        _prices = prices.clone();

        dfs(0, 0);
        return result;
    }

    public static void dfs(int idx, int price) {
        if (idx >= _n) {
            result = Math.max(result, price);
            return;
        }

        if (idx + _days[idx] <= _n) {
            dfs(idx + _days[idx], price + _prices[idx]);
        } else {
            dfs(idx + _days[idx], price);
        }

        dfs(idx + 1, price);
    }

    static int answer;

    public static int solution(int[] days, int[] prices, int n) {
        int[] dp = new int[n + 2];

        for (int i = n; i > 0; i--) {
            int day = i + days[i- 1];

            if (day <= n + 1) { // 만일 마지막 날의 업무가 n + 1인 날짜의 인덱스까지만 체킹하기 위함
                dp[i] = Math.max(dp[day] + prices[i - 1], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        return dp[1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] days = new int[N];
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        answer = solution(days, prices, N);
        System.out.println(answer);
        result = solution2(days, prices, N);
        System.out.println(result);
    }
}
