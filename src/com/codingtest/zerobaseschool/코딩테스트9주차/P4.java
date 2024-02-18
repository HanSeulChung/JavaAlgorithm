package com.codingtest.zerobaseschool.코딩테스트9주차;

import java.util.*;

public class P4 {
    public int wrongSolution(int[] x, int[] y) {
        int answer = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < x.length; i++) {
            pq.add(new Point(x[i], y[i]));
        }

        Point prev = pq.poll();

        while(!pq.isEmpty()) {
            Point cur = pq.poll();

            int distance = Math.abs(cur.x - prev.x) + Math.abs(cur.y - prev.y);
            answer += distance;

            prev = cur;
        }

        return answer;
    }
}



class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Point other) {
        if (this.x == 0 && other.x == 0) {
            return Integer.compare(other.y, this.y);
        } else {
            int xComparison = Integer.compare(this.x, other.x);
            if (xComparison != 0) {
                return xComparison;
            }
            return Integer.compare(this.y, other.y);
        }

    }
}