package com.codingtest.zerobaseshool.코딩테스트4주차;

import java.util.*;
import java.util.stream.Collectors;

public class P5 {
    public int[][] mysolution(int[][] buildings) {
        /*
테스트 1 〉 통과 (0.75ms, 74.7MB)
테스트 2 〉 통과 (0.65ms, 77.8MB)
테스트 3 〉 통과 (0.74ms, 72.3MB)
테스트 4 〉 통과 (0.80ms, 75.6MB)
테스트 5 〉 통과 (6.70ms, 71.6MB)
채점 결과
정확성: 20.0
효율성: 0.0
합계: 20.0 / 20.0
        * */
        int[][] answer = new int[2][2];
        Arrays.sort(buildings, (b1, b2) -> b1[0] - b2[0]);
        int finishN = 0;
        for (int[] building : buildings) {
            finishN = Math.max(finishN, building[1]);
        }
        finishN++;
        int[] checkSilhouette = new int[finishN];

        for (int[] building : buildings) {
            for (int i = building[0]; i <= building[1]; i++) {
                if (checkSilhouette[i] < building[2]) {
                    checkSilhouette[i] = building[2];
                }
            }
        }
        List<int[]> resultList = new ArrayList<>();
        int prevHeight = 0;
        if (buildings[0][0] == 0) {
            resultList.add(new int[]{0, buildings[0][2]});
        }
        for (int i = 1; i < finishN; i++) {
            prevHeight = checkSilhouette[i - 1];
            if (checkSilhouette[i] < prevHeight) {
                resultList.add(new int[]{i - 1, checkSilhouette[i]});
            } else if (checkSilhouette[i] > prevHeight) {
                resultList.add(new int[]{i, checkSilhouette[i]});
            } else {
                continue;
            }
        }
        resultList.add(new int[]{finishN - 1, 0});

        //System.out.println(Arrays.toString(checkSilhouette));
        answer = resultList.toArray(new int[resultList.size()][]);
        return answer;
    }

    public int[][] solution(int[][] buildings) {
        /*
테스트 1 〉 통과 (7.57ms, 76.3MB)
테스트 2 〉 통과 (6.92ms, 91.8MB)
테스트 3 〉 통과 (7.97ms, 79.7MB)
테스트 4 〉 통과 (6.60ms, 75.5MB)
테스트 5 〉 통과 (13.36ms, 80.1MB)
채점 결과
정확성: 20.0
효율성: 0.0
합계: 20.0 / 20.0
        * */
        List<Point> points
                = Arrays.stream(buildings)
                .map(x -> Arrays.asList( // List.of 는 java 9부터 가능 나는 8이라 Arrays.asList(array)로 대체
                        new Point(x[0], x[2], -1),
                        new Point(x[1], x[2], +1)))
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int currentHeight = 0;
        priorityQueue.offer(currentHeight);

        List<List<Integer>> resultList = new ArrayList<>();
        for (Point point : points) {
            if (point.direction == -1) {
                priorityQueue.offer(point.y);
            } else {
                priorityQueue.remove(point.y);
            }

            int mostHeight = priorityQueue.peek();

            if (currentHeight != mostHeight) {
                resultList.add(Arrays.asList(point.x, mostHeight)); // List.of 는 java 9부터 가능
                currentHeight = mostHeight;
            }
        }
        return resultList.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    int direction;

    public Point(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public int compareTo(Point o) {
        if (x == o.x) {
            return direction - o.direction;
        }
        return x - o.x;
    }
}