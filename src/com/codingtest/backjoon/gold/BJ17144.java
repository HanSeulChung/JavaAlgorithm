package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ17144{
    static int row, col, time;
    static int[][] map;
    static ArrayList<Integer>[] airCleaner;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        airCleaner = new ArrayList[2];
        int idx = 0;

        for (int i = 0; i < row; i++) {
            st  = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    airCleaner[idx++].add(i, j);
                }

            }
        }
    }

}

