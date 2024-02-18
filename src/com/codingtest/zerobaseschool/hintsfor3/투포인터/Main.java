package com.codingtest.zerobaseschool.hintsfor3.투포인터;

// BJ 2003번

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        int sum =0;
        int p1 = 0;
        int p2 = 0;
        int cnt =0;
        while(true){
            if(sum<M && p2<arr.length){
                sum += arr[p2++];
            } else if (sum>=M && p1<arr.length){
                sum -= arr[p1++];
            } else {
                break;
            }

            if(sum==M){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
