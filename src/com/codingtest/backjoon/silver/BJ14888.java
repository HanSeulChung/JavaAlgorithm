package com.codingtest.backjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888{

    static int N;
    static int[] numbers;
    static int[] operators;
    static int MinResult = Integer.MAX_VALUE;
    static int MaxResult = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[4];  // operators[0]: + 개수,  operators[1]: - 개수, operators[2]: X 개수, operators[3]: / 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i ++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        dfs(numbers[0], 1);
        System.out.println(MaxResult);
        System.out.println(MinResult);
    }
    public static void dfs(int num, int idx) {
        if (idx == N){
            MaxResult = Math.max(num, MaxResult);
            MinResult = Math.min(num, MinResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0 :
                       dfs(num + numbers[idx], idx + 1);
                       break;

                    case 1:
                        dfs(num - numbers[idx], idx + 1);
                        break;

                    case 2 :
                        dfs(num * numbers[idx], idx + 1);
                        break;

                    case 3:
                        dfs(num / numbers[idx], idx + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}
