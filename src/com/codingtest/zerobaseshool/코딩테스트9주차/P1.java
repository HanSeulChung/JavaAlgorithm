package com.codingtest.zerobaseshool.코딩테스트9주차;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 문제
 * 원이는 친구들을 속이는 재미를 뒤늦게 깨닫고, 효율적인 거짓말 놀이를 하기로 하였다.
 *
 * 원이는 0번 친구에게 단 한번의 거짓말을 하여 N명의 모든 친구들을 속이고자 한다.
 *
 * 한 사람이 거짓말을 믿게 되면, 그 사람의 친한 친구들은 일정 시간 후에 거짓말을 믿게 된다.
 *
 * friend[i]에는 i번째 친구와 친한 친구들의 인덱스가 배열로 주어진다.
 *
 * time[i]에는 i번째 친구가 거짓말을 믿기 시작한 후에, 그 사람의 친한 친구들이 거짓말을 믿는 데에 걸리는 시간이 배열로 주어진다.
 *
 * 이 때, 단 한번의 거짓말로 원이의 모든 친구들이 거짓말을 믿게 되는 데에 걸리는 시간을 계산하시오.
 *
 * 단, 한 번의 거짓말로 모든 친구가 거짓말을 믿게 할 수 없으면 -1을 반환하시오.
 *
 * 입력설명
 * 0 < N <= 1000
 * 0 < friend[i].length = time[i].length <= 100
 * 0 < time[i][j] <= 100
 * 출력설명
 * 모든 친구가 거짓말을 믿는 데에 걸리는 시간을 정수로 반환
 *
 * 매개변수 형식
 * N = 5
 *
 * friend = {{1, 4}, {2, 3}, {4}, {1}, {0, 2}}
 *
 * time = {{5, 2}, {6, 4}, {9}, {1}, {2, 6}}
 *
 * 반환값 형식
 * 9
 */
public class P1 {
    public int solution(int N, int[][] friend, int[][] time) {
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false); // 안해도 false가 default

        // 모든 노드가 연결되어있는지 확인 (연결되어있지 않으면 모두 거짓말을 믿지 못하므로 -1 반환)
        dfs(0, visited, friend);
        if (!isAllVisited(visited)) {
            return -1;
        }

        // Dijkstra 알고리즘

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );

        int[] dists = new int[N];
        Arrays.fill(dists, Integer.MAX_VALUE);

        pq.offer(new int[]{0, 0});
        dists[0] = 0;

        while (!pq.isEmpty()) {
            int [] value = pq.poll();
            int dist = value[0];
            int currentNode = value[1];

            if (dists[currentNode] < dist) {
                continue;
            }

            for (int i = 0; i < friend[currentNode].length; i++) {
                int friendNode = friend[currentNode][i];
                int t =  time[currentNode][i];
                int newDist = dist + t;
                if (dists[friendNode] > newDist) {
                    dists[friendNode] = newDist;
                    pq.offer(new int[]{newDist, friendNode});
                }
            }
        }
        return Arrays.stream(dists).max().getAsInt();
    }
    void dfs(int node, boolean[] visited, int[][] friend) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        if (isAllVisited(visited)) {
            return;
        }

        for (int n : friend[node]) {
            dfs(n, visited, friend);
        }
    }

    boolean isAllVisited(boolean[] visited) {
        for (boolean check : visited) {
            if (!check) {
                return false;
            }
        }

        return true;
    }
}