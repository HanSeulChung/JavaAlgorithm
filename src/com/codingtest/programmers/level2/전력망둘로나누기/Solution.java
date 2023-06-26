package com.codingtest.programmers.level2.전력망둘로나누기;


import java.util.*;

public class Solution {
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

            matrix[a-1][b-1] = 1;
            matrix[b-1][a-1] = 1;
        }

        for(int i=0; i< wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            matrix[a-1][b-1] = 0;
            matrix[b-1][a-1] = 0;

            answer = Math.min(answer,bfs(i, n, matrix));

            matrix[a-1][b-1] = 1;
            matrix[b-1][a-1] = 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n,wires));
    }
}