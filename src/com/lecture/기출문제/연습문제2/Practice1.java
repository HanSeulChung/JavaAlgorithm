package com.lecture.기출문제.연습문제2;

// case by case는 simulation 형식으로 풀어야함
// dp와 dfs방식은 맞지않음

public class Practice1 {

    public static int solution(int[][] maps, int stairLen) {
        int cnt = roadCheck(maps, stairLen);

        int[][] roadT = new int[maps.length][maps.length];
        transpose(roadT, maps);
        cnt += roadCheck(roadT, stairLen);
        return cnt;
    }

    public static void transpose(int[][] dst, int[][] src) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[0].length; j++) {
                dst[i][j] = src[j][i];
            }
        }
    }
    
    public static int roadCheck(int[][] maps, int stairLen) {
        int cnt = 0;

        for (int i = 0; i < maps.length; i++) {
            boolean roadState = true;

            boolean[] installed = new boolean[maps.length];
            for (int j = 0; j < maps.length - 1; j++) {
                if (maps[i][j] == maps[i][j + 1]) {
                    continue;
                }

                if (Math.abs(maps[i][j] - maps[i][j + 1]) > 1) {
                    roadState = false;
                    break;
                }

                if (maps[i][j] > maps[i][j + 1]) { // 내리막길 일 때
                    for (int k = j + 1; k <= j + stairLen; k++) {
                        if (k >= maps.length || installed[k] || maps[i][j + 1] != maps[i][k]) {
                            roadState = false;
                            break;
                        }
                        installed[k] = true;
                    }
                } else {
                    for (int k = j; k > j - stairLen; k--) { // 오르막길 일 때
                        if (k < 0 || installed[k] || maps[i][j] != maps[i][k]) {
                            roadState = false;
                            break;
                        }
                        installed[k] = true;

                    }
                }
            }
            if (!roadState) {
                roadState = false;
            }
            if (roadState) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        int[][] maps = {{2, 2, 2, 2, 2, 2},
                {2, 2, 3, 3, 3, 3},
                {2, 2, 2, 3, 2, 3},
                {2, 1, 1, 1, 1, 2},
                {2, 1, 1, 3, 3, 1},
                {2, 1, 2, 3, 3, 2}};
        System.out.println(solution(maps, 2)); //5
        System.out.println(solution(maps, 3)); //3
    }
}
