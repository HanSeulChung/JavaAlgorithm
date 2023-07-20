package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ3190{
    static int N;
    static int applesN;
    static int[][] apples;
    static int snakeroutesN;
    static Queue<ArrayList> snakeroutes;
    static Queue<ArrayList> snake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        applesN = Integer.parseInt(st.nextToken());

        if(applesN == 0) {
            apples = new int[0][0];
        } else {
            apples = new int[applesN][2];
            for (int i = 0; i < applesN; i++){
                st = new StringTokenizer(br.readLine());
                apples[i][0] = Integer.parseInt(st.nextToken());
                apples[i][1] = Integer.parseInt(st.nextToken());
            }
        }

        snakeroutesN = Integer.parseInt(br.readLine());
        snakeroutes = new LinkedList<>();
        int num = 0;
        Character direction ;
        for (int i = 0; i < snakeroutesN; i++){
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            direction = st.nextToken().charAt(0);
            snakeroutes.add(new ArrayList(Arrays.asList(num, direction)));
        }

        int[][] board = new int[N + 1][N + 1];
        for (int[] apple : apples) {
            board[apple[0]][apple[1]] = 1;
        }

        snake = new LinkedList<>();
        snake.add(new ArrayList(Arrays.asList(1, 1)));

        ArrayList<ArrayList> directions = new ArrayList<>();
        directions.add(new ArrayList(Arrays.asList(0, 1)));
        directions.add(new ArrayList(Arrays.asList(1, 0)));
        directions.add(new ArrayList(Arrays.asList(0, -1)));
        directions.add(new ArrayList(Arrays.asList(-1, 0)));

        int dIdx = 0;
        int score = 0;
        int x = 1;
        int y = 1;

        while(true) {
            score += 1;
            x += (int)directions.get(dIdx).get(0);
            y += (int)directions.get(dIdx).get(1);

            if (x >= 1 && x <= N && y >= 1 && y <= N) {
                ArrayList cur = new ArrayList(Arrays.asList(x, y));
                if (snake.contains(cur)) {
                    System.out.println(score);
                    return ;
                }
                snake.add(cur);

                if (board[x][y] == 0) {
                    snake.poll();
                } else {
                    board[x][y] = 0;
                }
            } else {
                System.out.println(score);
                return;
            }

            if (snakeroutes.size() > 0 && score == (int)snakeroutes.peek().get(0)) {
                if ((char)snakeroutes.peek().get(1) == 'D') {
                    dIdx = (dIdx + 1) % 4;
                    snakeroutes.poll();
                } else if ((char)snakeroutes.peek().get(1) == 'L') {
                    //dIdx = (dIdx - 1) % 4;
                    dIdx = (dIdx + 3) % 4;
                    snakeroutes.poll();
                    }
                }
            }

    }
}