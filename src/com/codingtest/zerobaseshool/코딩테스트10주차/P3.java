package com.codingtest.zerobaseshool.코딩테스트10주차;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P3 {
    boolean[] isVisited;
    int[][] adjList;
    List<Integer> result;

    public int[] solution(int N, int[][] left, int[][] right) {
        adjList = new int[N][];
        // left 자식, right 자식 초기에는 없는 채로 셋팅
        for (int i = 0; i < N; i++) {
            adjList[i] = new int[]{-1, -1};
        }

        // left 자식 추가
        for (int[] ints: left) {
            int p = ints[0];
            int c = ints[1];
            adjList[p][1] = c;
        }

        // right 자식 추가
        for (int[] ints: right) {
            int p = ints[0];
            int c = ints[1];
            adjList[p][1] = c;
        }

        isVisited = new boolean[N];
        Arrays.fill(isVisited, false);
        result = new ArrayList<>();

//        boolean isDone = false;
//        while (!isDone) {
//            // 루트노드부터 DFS
//            dfs(0);
//
//            // 모든 노드를 탐색했다면 끝
//            isDone = true;
//            for (boolean b : isVisited) {
//                if (!b) {
//                    isDone = false;
//                    break;
//                }
//            }
//        }

        while (!isVisited[0]) {
            dfs(0);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    void dfs(int node) {
        int left = adjList[node][0];
        int right = adjList[node][1];

        // 자식이 없거나 자식을 이미 들렀으면 이 노드가 리프 토드
        if ((left == -1 || isVisited[left]) && right == -1 || isVisited[right]) {
            result.add(node);
            isVisited[node] = true;
            return;
        }

        // 자식이 있고, 들르지 않았을 경우 방문
        // 우측 자식을 먼저 들러야 우측으로 부터 좌측으로 읽는다.
        if (right >= 0 && !isVisited[right]) {
            dfs(right);
        }

        if (left >= 0 && !isVisited[left]) {
            dfs(left);
        }
    }
}
