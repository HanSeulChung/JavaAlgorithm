package com.codingtest.zerobaseshool.코딩테스트9주차;

/**
 * Prim 구현 필요
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P5 {
    public int solution(int N, int[][] relations) {
        // 연관 있는 문제 그룹을 모두 공부하는데에 걸리는 시간 : MST
        // 새로운 문제 그룹을 하나 공부하기 위해 30분씩 추가 시간 필요
        // 커넥티드 컴포넌트인경우에 MST를 구할땐, 모든 노드를 추가하기 때문에 어떤 노드를 먼저 추가해도 상관없다.
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 그래프로 등록
        for (int[] ints: relations) {
            int a = ints[0];
            int b = ints[1];
            int w = ints[2];
            graph.get(a).add(new int[]{b, w});
            graph.get(b).add(new int[]{a, w});

        }

        // 모든 노드들 리스트를 만듦
        List<Integer> allNodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            allNodes.add(i);
        }

        // 연결된 노드(그룹, 컴포넌트)를 모아서 각 그룹으로 모음
        List<List<Integer>> connectedNodes = new ArrayList<>();
        while (!allNodes.isEmpty()) {
            List<Integer> connected = getConnected(graph, allNodes.get(0));
            allNodes.removeAll(connected);
            connectedNodes.add(connected);
        }

        int result = 0;
        for (List<Integer> connected: connectedNodes) {
            result += 30;
//            result += Prim.solve(graph, connected.get(0));
        }
        return result;
    }

    // 이전의 문제의 dfs와 같음
    List<Integer> getConnected(List<List<int[]>> graph, int node) {
        List<Integer> connectedList = new ArrayList<>();
        connectedList.add(node);

        Stack<Integer> stack = new Stack<>();
        for (int[] ints: graph.get(node)) {
            int adjNode = ints[0];
            stack.push(adjNode);
        }

        // stack을 이용한 DFS로 연결된 노드 모두 찾기
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            if (connectedList.contains(currNode)) {
                continue;
            }
            connectedList.add(currNode);
            for (int[] ints: graph.get(currNode)) {
                int adjNode = ints[0];
                stack.push(adjNode);
            }
        }
        return connectedList;
    }
}