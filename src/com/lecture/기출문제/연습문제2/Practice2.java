package com.lecture.기출문제.연습문제2;

public class Practice2 {
    final static int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // 북, 동, 남, 서
    final static int UNEXPLORED = 0;
    final static int WALL = 1;
    final static int EXPLORED = 2;

    public static int solution(int[][] map, int[] startPos) {
        int r = startPos[0];
        int c = startPos[1];
        int d = startPos[2];
        int turnCnt = 0;
        int result = 0;

        while (true) {
            if (turnCnt == 4) {
                r -= dirs[d][1];
                c -= dirs[d][0];
                turnCnt = 0;

                if (map[r][c] == WALL) {
                    break;
                }
            }

            if (map[r][c] == UNEXPLORED) {
                map[r][c] = EXPLORED;
                result++;
            }

            d = (d + 3) % 4;
            int xNext = c + dirs[d][0];
            int yNext = r + dirs[d][1];
            if (map[yNext][xNext] == UNEXPLORED) {
                r = yNext;
                c = xNext;
                turnCnt = 0;
            } else {
                turnCnt++;
            }
        }

        return result;
    }

    static int sol2Result;
    public static int solution2(int[][] map, int[] startPos) {
        int r = startPos[0];
        int c = startPos[1];
        int d = startPos[2];

        sol2Result = 0;
        dfs(map, r, c, d);
        return sol2Result;
    }

    public static void dfs(int[][] map, int r, int c, int d) {
        if (map[r][c] == UNEXPLORED) {
            map[r][c] = EXPLORED;
            sol2Result++;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int xNext = c + dirs[d][0];
            int yNext = r + dirs[d][1];

            if (map[yNext][xNext] == UNEXPLORED){
                dfs(map, yNext, xNext, d);
                return;
            }
        }

        c -= dirs[d][0];
        r -= dirs[d][1];
        if (map[r][c] != WALL) {
            dfs(map, r, c, d);
        }
    }
    public static void main(String[] args) {
        // Test code
        int[][] map = {{1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}};
        int[] startPos = {1, 1, 0};
        System.out.println(solution(map, startPos));

        map = new int[][] { {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}};
        System.out.println(solution2(map, startPos));

        System.out.println();
        map = new int[][]{  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        startPos = new int[]{1, 1, 2};
        System.out.println(solution(map, startPos));

        map = new int[][]{  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        System.out.println(solution2(map, startPos));
    }
}
