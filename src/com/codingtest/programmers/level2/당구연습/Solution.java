package com.codingtest.programmers.level2.당구연습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static class Point{
        int x, y;
        public Point(int x, int y){
            this.x= x;
            this.y= y;
        }
    }
    public static int[] solution(int m, int n, int startX, int startY, int[][] balls){
        int[] answer = new int[balls.length];
        Point border = new Point(m,n);
        Point start = new Point(startX, startY);

        for (int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];
            List<Point> targets =symmetricPoint(border, start, new Point(ball[0], ball[1]));
            int mindistance = Integer.MAX_VALUE;
            for(Point point : targets){
                int distance = calDistance(start, point);

                mindistance = Math.min(mindistance,distance);
            }
            answer[i] = mindistance;

        }

        return answer;
    }
    private static List<Point> symmetricPoint(Point border, Point start, Point target){
        List<Point> targetpoints = new ArrayList<>();
        // 시작점과 목표점이 x값이 같거나 y값이 같을때는 특수한 상황
        // 각 상황마다 쿠션보다 목표점을 먼저 맞히는 경우가 있으므로 그 상황 배제 (! 아닐 때만 대칭)
        // 그 외의 대칭 할 수 있는 목표 점들을 다 add 한후 solution에서 최소거리를 구함
        if(!(start.x == target.x && start.y <target.y)) targetpoints.add(new Point(target.x,border.y + (border.y-target.y)));
        if(!(start.x == target.x && start.y >target.y)) targetpoints.add(new Point(target.x,-target.y));
        if(!(start.y == target.y && start.x <target.x)) targetpoints.add(new Point(border.x +(border.x -target.x),target.y));
        if(!(start.y == target.y && start.x >target.x)) targetpoints.add(new Point(-target.x, target.y));

        return targetpoints;
    }
    private static int calDistance(Point start, Point target){
        int largeX = Math.max(start.x, target.x);
        int largeY = Math.max(start.y, target.y);
        int smallX = Math.min(start.x, target.x);
        int smallY = Math.min(start.y, target.y);

        return ((int)Math.pow(largeY-smallY,2) +(int)Math.pow(largeX-smallX,2));
    }
    public static void main(String[] args) {
        int[][] balls = {{7, 7},{2, 7},{7, 3}};
        int m = 10;
        int n = 10;
        int startX = 3;
        int startY = 7;

        System.out.println(Arrays.toString(solution(m,n,startX,startY,balls)));

    }
}
