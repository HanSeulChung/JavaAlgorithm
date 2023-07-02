package com.codingtest.programmers.level2.리코챗로봇;


import java.util.*;

class Point {
    int x;
    int y;
    int cnt;

    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Solution {
     public static char[][] map;
     public static boolean[][] visited;
     static int[] dx = {1, -1, 0, 0};
     static int[] dy = {0, 0, 1, -1};
     public static Point getPoint(int index, Point now) {
        int x = now.x , y = now.y;
        int ix = dx[index];
        int iy = dy[index];
        while(x + ix >= 0 && x + ix < map.length
                && y + iy >= 0 && y + iy < map[0].length
                && map[x + ix][y + iy] != 'D')
        {
            x += ix;
            y += iy;
        }

        return new Point(x, y, now.cnt + 1);
    }
     public static int bfs(Point start, Point finish) {
         Queue<Point> queue = new LinkedList<>();
         visited[start.x][start.y] = true;
         queue.add(start);
         while (!queue.isEmpty()) {
             Point now = queue.poll();
             int x = now.x;
             int y = now.y;
             int cnt = now.cnt;

             if (x == finish.x && y == finish.y) {
                 System.out.println("check@@@");
                 return cnt;
             }

             for (int i = 0; i < 4; i++) {
                 // 방법 1. 메서드로 빼서 미끄러지는 경로 카운팅하기
//                 Point next = getPoint(i, now);
//                 if(!visited[next.x][next.y]){
//                     visited[next.x][next.y] = true;
//                     queue.add(new Point(next.x, next.y, cnt+1));
//                 }
                 // 방법 2. 그냥 for문 안에서 while문 돌려서 미끄러지는 경로 카운팅하기
                 int ix = dx[i];
                 int iy = dy[i];
                 int next_x = x;
                 int next_y = y;
                 while (next_x + ix >= 0 && next_x + ix < map.length && next_y + iy >= 0 && next_y + iy < map[0].length && map[next_x + ix][next_y + iy] != 'D') {
                     next_x += ix;
                     next_y += iy;
                 }
                 if (!visited[next_x][next_y]) {
                     visited[next_x][next_y] = true;
                     queue.add(new Point(next_x, next_y, cnt + 1));
                     System.out.println("check");
                 } // 왜 이렇게 하면 -1만 return 되지?
             }
         }
         return -1;
     }

     public static int solution(String[] board) {
         int answer = 0;
         map = new char[board.length][board[0].length()];
         visited = new boolean[map.length][map[0].length];
         Point start = null;
         Point finish = null;

         for (int i = 0; i < board.length; i++) {
             for (int j = 0; j < board[i].length(); j++) {
                 map[i][j] = board[i].charAt(j);
                 if (map[i][j] == 'R') {
                     start = new Point(i, j, 0);
                 }
                 if (map[i][j] == 'G') {
                     finish = new Point(i, j, 0);
                 }
             }
         }

         answer = bfs(start, finish);

         return answer;
     }

     public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
         System.out.println(solution(board));
     }
 }