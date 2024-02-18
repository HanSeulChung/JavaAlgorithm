package com.codingtest.zerobaseschool.hintsfor3.그리디;
// 11047번
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-1; i >=0 ; i--) {
            if(money<coins[i]){
                continue;
            }

            int q = money / coins[i];

            money %= coins[i];

            cnt +=q;
        }
        System.out.println(cnt);
    }

}