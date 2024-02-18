package com.codingtest.zerobaseschool.코딩테스트10주차;

import java.util.*;

public class P5 {

    List<List<int[]>> adjList;
    int N;

    public int solution(int N, int[][] edge) {
        // 사실 특별할 것 없는 Dijkstra 문제
        // Dijkstra 결과에서 가장 거리가 먼 노드의 인덱스 반환
        this.N = N;
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] ints : edge) {
            int a = ints[0];
            int b = ints[1];
            int d = ints[2];
            adjList.get(a).add(new int[]{b, d});
        }

        int[] dists = dijkstra(0);
        int maxInd = -1;
        int maxVal = -1;

        for (int i = 0; i < N; i++) {
            if (dists[i] > maxVal) {
                maxVal = dists[i];
                maxInd = i;
            }
        }
        return maxInd;
    }

    int[] dijkstra(int node) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );
        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);

        pq.offer(new int[]{0, node});
        distances[node] = 0;

        while (!pq.isEmpty()) {
            int[] ints = pq.poll();
            int dist = ints[0];
            int i = ints[1];

            if (distances[i] < dist) {
                continue;
            }

            for (int[] ints1: adjList.get(i)) {
                int currentNode = ints1[0];
                int currentDist = ints1[1];
                int newDist = dist + currentDist;
                if (distances[currentNode] > newDist) {
                    distances[currentNode] = newDist;
                    pq.offer(new int[]{newDist, currentNode});
                }
            }
        }
        return distances;
    }
}
