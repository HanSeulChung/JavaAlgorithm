package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Ball {
    int x;
    int y;
    int cnt;

    public Ball(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class BJ13460{
    static String[][] map;
    static boolean[][][][] visited;
    static Ball r_ball, b_ball;
    static int[] dx = {-1, 1 , 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rowN = Integer.parseInt(st.nextToken());
        int colN = Integer.parseInt(st.nextToken());

        map = new String[rowN][colN];
        visited = new boolean[rowN][colN][rowN][colN];
        for (int i = 0; i < rowN; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < colN; j++) {
                if (map[i][j].equals("R")) {
                    r_ball = new Ball(j, i, 0);
                } else if (map[i][j].equals("B")) {
                    b_ball = new Ball(j, i, 0);
                }
            }
        }
        bfs(r_ball, b_ball);
        System.out.println(result);
    }

    public static void bfs(Ball redBall, Ball blueBall) {
        Queue<Ball> redQ = new LinkedList<>();
        Queue<Ball> blueQ = new LinkedList<>();

        redQ.offer(redBall);
        blueQ.offer(blueBall);

        visited[redBall.y][redBall.x][blueBall.y][blueBall.x] = true; // 방문 체크

        while (!redQ.isEmpty() && !blueQ.isEmpty()) {
            Ball curRedball = redQ.poll();
            Ball curBlueball = blueQ.poll();

            if(curRedball.cnt > 10) { // 빨간 구슬을 10번 이상 움직이면 -1 반환 끝
                result = -1;
                return;
            }

            if (map[curBlueball.y][curBlueball.x].equals("O")) { // 파란구슬이 구슬에 도착했을 경우? 일단 스킵
                continue;
            }

            if (map[curRedball.y][curRedball.x].equals("O")) { // 빨간 구슬만 빠져나간 경우 왜냐? 파란색이 들어간 경우는 위에서 걸러졌기 때문에 해당 if문은 빨간구슬만 구멍에 들어간 경우이다.
                result = curRedball.cnt;
                return; // 끝
            }

            for (int i = 0; i < 4; i++) {

                int bx = curBlueball.x;
                int by = curBlueball.y;
                while (true) {
                    bx += dx[i];
                    by += dy[i];
                    if (map[by][bx].equals("O")) {
                        break;
                    } else if (map[by][bx].equals("#")) {
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }
                }

                int rx = curRedball.x;
                int ry = curRedball.y;
                while (true) {
                    rx += dx[i];
                    ry += dy[i];
                    if (map[ry][rx].equals("O")) {
                        break;
                    } else if (map[ry][rx].equals("#")) {
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }
                }
                if (bx == rx && by == ry && !map[ry][rx].equals("O")) { // 각 구슬은 같은 공간이 아닌 개별적인 공간 1칸씩 차지하므로 구멍에 도착하지 않았을 때 겹쳐져있을 경우를 체킹해준다.
                    // 거리가 더 긴것이 앞으로 나오게 된것이므로 뒤로 한칸 빼준다 ex> . . . R B 일경우 왼쪽으로 기울였을 경우 (RB) . . . 로 될텐데 B는 4, R은 3이므로 B가 R뒤로 가야 한다.
                    int r_distance = Math.abs(curRedball.x - rx) + Math.abs(curRedball.y - ry);
                    int b_distance = Math.abs(curBlueball.x - bx) + Math.abs(curBlueball.y - by);

                    if (r_distance > b_distance) {
                        rx -= dx[i];
                        ry -= dy[i];
                    } else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }
                if (!visited[ry][rx][by][bx]) {

                    visited[ry][rx][by][bx] = true;

                    redQ.offer(new Ball(rx, ry, curRedball.cnt + 1));
                    blueQ.offer(new Ball(bx, by, curBlueball.cnt + 1));
                }
            }
        }
    }
}
