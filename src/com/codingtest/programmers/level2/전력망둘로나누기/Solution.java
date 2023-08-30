package com.codingtest.programmers.level2.전력망둘로나누기;


import java.util.*;

public class Solution {
    static ArrayList<Integer>[] graph;
    static int min;

    public int solution2(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;

        // 그래프 ArrayList 초기화. 노드 개수만큼 ArrayList 생성
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 간선 구조이므로 두 번 add를 해준다
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            boolean[] visited = new boolean[n + 1];

            // 해당 간선을 그래프에서 제거
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            int cnt = dfs(1, visited); // 임의의 시작점에서 dfs 탐색

            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);

            // 그래프에 다시 간선 추가
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return min;
    }

    static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;

        for (int next : graph[v]) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }

        return cnt;
    }



    public static int bfs(int start, int n, int[][] matrix){
        boolean[] visited = new boolean[n]; // 방문 여부 확인용 배열
        int cnt = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0; i<n; i++){
                if(matrix[now][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i] =true;
                    cnt++;
                }
            }
        }
        return (int)Math.abs(cnt -(n -cnt));
    }

    public static int solution(int n, int[][] wires) {
        int answer = n;
        int[][] matrix = new int[n][n];
        for(int i =0; i< wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            matrix[a - 1][b - 1] = 1;
            matrix[b - 1][a - 1] = 1;
        }

        for(int i=0; i< wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            matrix[a - 1][b - 1] = 0;
            matrix[b - 1][a - 1] = 0;

            answer = Math.min(answer,bfs(i, n, matrix));

            matrix[a - 1][b - 1] = 1;
            matrix[b - 1][a - 1] = 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n,wires));
    }
}