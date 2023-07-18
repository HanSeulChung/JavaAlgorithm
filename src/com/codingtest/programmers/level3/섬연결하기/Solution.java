package com.codingtest.programmers.level3.섬연결하기;

import java.util.Arrays;

public class Solution {
    static int[] parents;
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        for (int i = 0; i < n; i++){
            parents[i] = i; // 자기 자신을 부모노드로 초기화
        }

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));  // 연결 비용이 적은순으료(오름차순으로) 정렬
        for (int[] graph : costs){
            int cost = graph[2];
            int to = graph[0];
            int from = graph[1];

            if(find(to) == find(from)) { // 부모가 같으면 , 이어져있으면 넘어감
                continue;
            } else {
                answer += cost; // 같지 않으면 이어줌, cost 비용 추가
                parents[find(to)] = find(from); // union함수를 따로 만들지 않고 해당 for문에서 해결함, 항상 kruskal은 union find가 필요함을 기억
            }
        }
        return answer;
    }
    public static int find(int a){
        if( a == parents[a]){
            return a;
        }
        return parents[a] = find(parents[a]);
    }


    public static void main(String[] args) {
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(4, costs));
    }
}
