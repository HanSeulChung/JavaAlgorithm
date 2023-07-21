package com.lecture.기출문제.연습문제1;

import java.util.ArrayList;

public class Practice3 {
    final static int CLEAN_ROAD = 0;
    final static int WALL = 1;
    final static int WATER = 2;

    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int m;
    static int n;
    static Integer[][] roadBak;
    static ArrayList<int[]> warterPoints;
    static int max;

    public static int solution(int[][] roads) {
        m = roads.length;
        n = roads[0].length;
        roadBak = new Integer[m][n];
        warterPoints = new ArrayList<>();
        max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (roads[i][j] == WATER) {
                    warterPoints.add(new int[] {j, i});
                }
            }
        }

        // dfs
        dfs(roads, 0);
        return max;
    }

    public static void dfs(int[][] roads, int depth) {
        if (depth == 3) { // 벽을 세개 다 설치한 경우
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    roadBak[i][j] = roads[i][j];
                }
            }

            for (int[] point : warterPoints) {
                waterSimulation(point[0], point[1]);
            }

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (roadBak[i][j] == CLEAN_ROAD) {
                        cnt++;
                    }
                }
            }

            max = Math.max(max, cnt);
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (roads[i][j] == CLEAN_ROAD) {
                    roads[i][j] = WALL;
                    dfs(roads, depth + 1);
                    roads[i][j] = CLEAN_ROAD;
                }
            }
        }
    }


    public static void waterSimulation(int x, int y) {
        for (int[] dir : dirs) {
            int xNext = x + dir[0];
            int yNext = y + dir[1];

            if (0 <= xNext && xNext < n && 0 <= yNext && yNext < n) {
                if (roadBak[yNext][xNext] == CLEAN_ROAD) {
                    roadBak[yNext][xNext] = WATER;
                    waterSimulation(xNext, yNext);
                }
            }
        }
    }
    public static void main(String[] args) {
        // Test code
        int[][] roads = {{0, 0, 0},
                {1, 2, 0},
                {0, 0, 0}};
        System.out.println(solution(roads));

        roads = new int[][]{{2, 0, 0, 0, 1, 1, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 2, 0}};
        System.out.println(solution(roads));
    }
}

