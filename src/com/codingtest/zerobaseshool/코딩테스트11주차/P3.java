package com.codingtest.zerobaseshool.코딩테스트11주차;

import java.util.*;

class Point {
    int startIdx;
    int finishIdx;

    public Point(int startIdx, int finishIdx) {
        this.startIdx = startIdx;
        this.finishIdx = finishIdx;
    }
}

public class P3 {

    // public void makeString(Map map, int idx, String sb) {

    // }

    public boolean solution(String s, String[] words) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        int L = s.length();

        for (String word : words) {
            int idx = s.indexOf(word);
            if (idx >= 0) {
                map.put(word, idx);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        PriorityQueue<Point> pq = new PriorityQueue<>(
                (i, j) -> {
                    if (i.startIdx == j.startIdx) {
                        return i.finishIdx - j.finishIdx;
                    }
                    return i.startIdx - j.startIdx;
                }
        );

        for (int i = 0; i < list.size(); i++) {
            int startIdx = map.get(list.get(i));
            int finishIdx = list.get(i).length();
            pq.offer(new Point(startIdx, finishIdx));
        }

        Point firstPoint = pq.poll();
        int beforeStartIdx = firstPoint.startIdx;
        int beforeFinishIdx = firstPoint.startIdx;

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.startIdx < beforeFinishIdx || cur.startIdx < beforeFinishIdx) {
                pq.offer(cur);
            }

            sb.append(s.substring(beforeFinishIdx, beforeFinishIdx + 1));

            if (sb.indexOf(s) >= 0) {
                break;
            }

        }

        return answer;
    }
}