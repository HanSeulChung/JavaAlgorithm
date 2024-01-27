package com.codingtest.programmers.level3.순위;

// 플로이드 와샬 알고리즘
public class Solution {

  public int solution(int n, int[][] results) {
    int answer = 0;
    int[][] graph = new int[n + 1][n + 1];

    // 그래프 초기화
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) {
          graph[i][j] = 0;
        } else {
          graph[i][j] = Integer.MAX_VALUE / 2; // 무한대로 초기화
        }
      }
    }

    // 그래프에 승패 관계 추가
    for (int[] result : results) {
      int winner = result[0];
      int loser = result[1];
      graph[winner][loser] = 1;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (graph[i][k] + graph[k][j] < graph[i][j]) {
            graph[i][j] = graph[i][k] + graph[k][j];
          }
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      boolean canCount = true;
      for (int j = 1; j <= n; j++) {
        if (graph[i][j] == Integer.MAX_VALUE / 2 && graph[j][i] == Integer.MAX_VALUE / 2){
          canCount = false;
          break;
        }
      }
      if (canCount) {
        answer++;
      }
    }
    return answer;
  }

  public int solution2(int n, int[][] results) {
    int answer = 0;
    int[][] floyd = new int[n+1][n+1];

    for(int i = 0; i < results.length; i++){
      int A = results[i][0];
      int B = results[i][1];
      // A > B
      floyd[A][B] = 1;
      floyd[B][A] = -1;
    }

    // 4 > 3 , 3 > 2 => 4 > 2
    for(int i = 1; i <= n; i++){
      for(int j = 1; j <= n; j++){
        for(int k = 1; k <= n; k++){
          if(floyd[i][k] == 1 && floyd[k][j] == 1){
            floyd[i][j] = 1;
            floyd[j][i] = -1;
          }
          if(floyd[i][k] == -1 && floyd[k][j] == -1){
            floyd[i][j] = -1;
            floyd[j][i] = 1;
          }
        }
      }
    }

    for(int i = 1; i <= n; i++){
      int cnt = 0;
      for(int j = 1; j <= n; j++){
        if(floyd[i][j] != 0) cnt++;
      }
      if(cnt == n-1) answer++;
    }

    return answer;
  }
}
