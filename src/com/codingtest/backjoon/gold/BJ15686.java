package com.codingtest.backjoon.gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
* */

class Point {
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class BJ15686{

    static int[][] map;
    static ArrayList<Point> chicken;
    static ArrayList<Point> house;
    static boolean[] checkOpenchicken;
    static int answer;

    public static void dfs(int start, int openCnt, int K){
        if(openCnt == K){
            int sum = 0;

            for (int i = 0; i < house.size(); i++) {
                int mintmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if(checkOpenchicken[j]){
                        int distance = Math.abs(chicken.get(j).x - house.get(i).x) + Math.abs(chicken.get(j).y - house.get(i).y);

                        mintmp = Math.min(distance, mintmp);
                    }
                }
                sum += mintmp;
            }
            answer = Math.min(sum, answer);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            checkOpenchicken[i] = true;
            dfs(i+1, openCnt+1, K);
            checkOpenchicken[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if( map[i][j] == 1){
                    house.add(new Point(j, i));
                } else if (map[i][j] == 2 ){
                    chicken.add(new Point(j, i));
                }
            }
        }

        checkOpenchicken = new boolean[chicken.size()];
        answer = Integer.MAX_VALUE;

        dfs(0,0, K);

        System.out.println(answer);
    }

}

