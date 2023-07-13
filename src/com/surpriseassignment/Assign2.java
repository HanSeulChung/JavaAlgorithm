package com.surpriseassignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashSet;
class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        Point point = (Point) obj;
        return point.x == this.x && point.y == this.y;
    }
}

public class Assign2{
    static int mindistance = Integer.MAX_VALUE;
    static Point mindistancePoint = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
    static Point myPoint;
    public static void calDistance(Point randompoint){
        int tmpdistance = (int)Math.sqrt((myPoint.x - randompoint.x)*(myPoint.x - randompoint.x) + (myPoint.y - randompoint.y)*(myPoint.y - randompoint.y));
        if(mindistance > tmpdistance){
            mindistance = tmpdistance;
            mindistancePoint = new Point(randompoint.x, randompoint.y);
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.print("나의 좌표 값을 입력하세요. 입력 순서대로 x, y값이 저장됩니다. 예시)3 2 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int myX = Integer.parseInt(st.nextToken());
        int myY = Integer.parseInt(st.nextToken());
        myPoint = new Point(myX, myY);

        ArrayList<Point> list = new ArrayList<>();
        System.out.println();
        System.out.println("임의의 좌표 값을 총 10개 입력하세요. 입력 순서대로 x, y값이 저장됩니다.");

        for (int i = 1; i <= 10; i++){
            System.out.printf("좌표 %d: ", i);
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            if(list.contains(new Point(X, Y))) {
                i--;
            } else {
                list.add(new Point(X, Y));
            }
        }

        for (int i = 0; i < list.size(); i++){
            calDistance(list.get(i));
        }
        System.out.printf("나와 가장 가까운 좌표값은 (%d, %d)입니다.", mindistancePoint.x, mindistancePoint.y);
    }
}

