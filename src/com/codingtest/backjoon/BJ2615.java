package com.codingtest.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2615{
    public static int[][] map;
    public static int winNum = 0;
    public static int xIdx = -1;
    public static int yIdx = -1;
    public static void checkWin(int x, int y, int num){
        if(x<0 || y< 0|| x >map.length -1 || y>map[0].length ){
            return ;
        }

        int[] dx = {1, 0, 1, -1};
        int[] dy = {0, 1, 1, 1};

        for(int i =0; i<4; i++){
            int next_x = x;
            int next_y = y;
            int cnt = 1;
            while(true){
                next_x += dx[i];
                next_y += dy[i];
                if( 0<=next_x && next_x<19 &&0<=next_y && next_y<19){
                    if(map[next_x][next_y]== num ) {
                        cnt +=1;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
                next_x = x;
                next_y = y;
                if(cnt == 5){
                    xIdx = x+1;
                    yIdx = y+1;
                    winNum = num;
                    break;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        map = new int[19][19];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int i = 0; i < 19; i++){
            st  = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1 || map[i][j] == 2){
                    checkWin(i, j, map[i][j]);
                }
            }
        }
        System.out.println(winNum);
        System.out.printf("%d %d" ,xIdx , yIdx);
    }

}
