package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ21608{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
        int[][] map = new int[N][N];
        ArrayList<Integer>[] studentsPreference = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            studentsPreference[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            studentsPreference[i].add(Integer.parseInt(st.nextToken()));
        }



    }

}

