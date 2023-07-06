package com.codingtest.backjoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2961{
    public static int N;
    public static int minV;
    public static int[] sours;
    public static int[] bitters;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        sours = new int[N];
        bitters = new int[N];
        minV = Integer.MAX_VALUE;
        for (int cnt = 0; cnt < N; cnt++) {
            st = new StringTokenizer(br.readLine());
            sours[cnt] = Integer.parseInt(st.nextToken());
            bitters[cnt] = Integer.parseInt(st.nextToken());

        }

        makeMinDiff(0, 0, 1, 0);
        System.out.println(minV);
    }

    public static void makeMinDiff(int inputCnt, int totalCnt, int sour, int bitter){
        if(totalCnt == N){
            if(inputCnt !=0 ){
                minV = Math.min(minV, Math.abs(sour - bitter));
            }
            return;
        }
        makeMinDiff(inputCnt, totalCnt+1, sour, bitter);
        makeMinDiff(inputCnt + 1, totalCnt + 1, sour*sours[totalCnt], bitter+ bitters[totalCnt]);
    }
}

