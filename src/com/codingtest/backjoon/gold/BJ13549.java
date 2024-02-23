package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13549 {
  static final int maxIdx = 100_000;
  static int min = Integer.MAX_VALUE;
  static boolean[] visited;
  static class Node {
    int idx;
    int time;

    public Node(int idx, int time) {
      this.idx = idx;
      this.time = time;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    visited = new boolean[maxIdx + 1];
    bfs(N, K);
    System.out.println(min);
  }

  private static void bfs(int start, int end) {
    PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.time - n2.time);
    pq.offer(new Node(start, 0));

    while(!pq.isEmpty()) {
      Node curNode = pq.poll();

      if (curNode.idx == end) {
        min = Math.min(min, curNode.time);
      }
      visited[curNode.idx] = true;

      int nextIdx = curNode.idx * 2;
      if (nextIdx <= maxIdx && !visited[nextIdx]){
        pq.offer(new Node(nextIdx, curNode.time));
      }
      nextIdx = curNode.idx - 1;
      if (nextIdx >= 0 && !visited[nextIdx]) {
        pq.offer(new Node(nextIdx, curNode.time + 1));
      }
      nextIdx = curNode.idx + 1;
      if (nextIdx <= maxIdx && !visited[nextIdx]) {
        pq.offer(new Node(nextIdx, curNode.time + 1));
      }
    }
  }
}
