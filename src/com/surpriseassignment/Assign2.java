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
    static float mindistance = Integer.MAX_VALUE;
    static Point mindistancePoint = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
    static Point myPoint;
    public static void calDistance(Point randompoint){
        float tmpdistance = (float)Math.sqrt((myPoint.x - randompoint.x)*(myPoint.x - randompoint.x) + (myPoint.y - randompoint.y)*(myPoint.y - randompoint.y));
        System.out.printf("(%d, %d) => %.6f\n", randompoint.x, randompoint.y, tmpdistance);
        if(mindistance > tmpdistance){
            mindistance = tmpdistance;
            mindistancePoint = new Point(randompoint.x, randompoint.y);
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("내 좌표 x값을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int myX = Integer.parseInt(st.nextToken());
        System.out.println("내 좌표 y값을 입력해 주세요.");
        st = new StringTokenizer(br.readLine());
        int myY = Integer.parseInt(st.nextToken());
        myPoint = new Point(myX, myY);

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            System.out.printf("%d/10 번째 입력\n", i);
            System.out.println("임의의 좌표 x값을 입력해 주세요.");
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            System.out.println("임의의 좌표 y값을 입력해 주세요.");
            st = new StringTokenizer(br.readLine());
            int Y = Integer.parseInt(st.nextToken());
            if(list.contains(new Point(X, Y))) {
                System.out.println("동일한 좌표값이 이미 존재합니다. 다시 입력해 주세요.");
                i--;
            } else {
                list.add(new Point(X, Y));
            }
        }

        for (int i = 0; i < list.size(); i++){
            calDistance(list.get(i));
        }
        System.out.println("제일 가까운 좌표:");
        System.out.printf("(%d, %d) => %.6f\n", mindistancePoint.x, mindistancePoint.y, mindistance);
    }
}

