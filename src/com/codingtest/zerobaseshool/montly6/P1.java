package com.codingtest.zerobaseshool.montly6;

import java.util.*;
class Point {
    int x;
    int y;
    int cnt;

    public Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "(x = " + x + ", y = " + y + ")";
    }
}

public class P1 {
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N;

    public int bfs(int startX, int startY, int endX, int endY) {
        int result = 0;
        visited = new boolean[N][N];
        visited[startX][startY] = true;
        int cnt = 0;
        Queue<Point> tmpq = new LinkedList<>();
        tmpq.offer(new Point(startX, startY, cnt));

        while(!tmpq.isEmpty()) {

            Point curr = tmpq.poll();

            if (curr.x == endX && curr.y == endY) {
                result = curr.cnt;
                return result;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];
                if (nextX >=0 && nextY >= 0 && nextX < N && nextY < N) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        tmpq.offer(new Point(nextX, nextY, curr.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }

    public int solution(int N, int[][] house) {
        int answer = 0;
        this.N = N;

        Queue<Point> q = new LinkedList<>();
        Point point1 = new Point(0, 0, 0);
        Point point2 = new Point(0, 0, 0);
        Point point3 = new Point(0, 0, 0);
        Point point4 = new Point(0, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if(house[i][j] == 1) {
                    point1 = new Point(j, i, 0);
                } else if(house[i][j] == 2) {
                    point2 = new Point(j, i, 0);
                } else if(house[i][j] == 3) {
                    point3 = new Point(j, i, 0);
                } else if(house[i][j] == 4) {
                    point4 = new Point(j, i, 0);
                }
            }
        }

        q.offer(point4);
        q.offer(point1);
        q.offer(point2);
        q.offer(point3);
        q.offer(point4);

        Point startPoint = q.poll();

        while(!q.isEmpty()) {
            Point endPoint = q.poll();
            answer += bfs(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
            startPoint = endPoint;
        }


        return answer;
    }
}
