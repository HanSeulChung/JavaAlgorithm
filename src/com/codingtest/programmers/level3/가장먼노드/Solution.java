package com.codingtest.programmers.level3.가장먼노드;

import java.util.*;

public class Solution {
  static List<List<Node>> nodeList;
  static int N;
  private static final int MAX = 1000_000_000;

  public int solution_dijkstra(int n, int[][] edge) {
    int answer = 0;
    nodeList = new ArrayList<>();
    N = n;

    for (int i = 0; i <= n; i++) {
      nodeList.add(new ArrayList<>());
    }

    for(int[] edgeNode : edge) {
      nodeList.get(edgeNode[0]).add(new Node(edgeNode[1], 1));
      nodeList.get(edgeNode[1]).add(new Node(edgeNode[0], 1));
    }

    int[] dist = dijkstra(1);
    Arrays.sort(dist);

    int farDist = dist[dist.length - 1];
    answer = 1;
    for (int idx = dist.length - 2; idx > 1; idx--) {
      if (farDist > dist[idx]) {
        break;
      }

      if (farDist == dist[idx]) {
        answer++;
      }
    }
    return answer;
  }

  private int[] dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
      return o1.cost - o2.cost;
    });
    boolean[] visited = new boolean[N + 1];
    pq.add(new Node(start, 0));

    int[] dist = new int[N + 1];
    Arrays.fill(dist, MAX);
    dist[0] = 0;
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      int curLocation = cur.value;

      if (visited[curLocation]) {
        continue;
      }
      visited[curLocation] = true;
      List<Node> adjList = nodeList.get(curLocation);

      for (Node node : adjList) {
        if (dist[node.value] > node.cost + dist[curLocation]) {
          dist[node.value] = node.cost + dist[curLocation];
          pq.add(new Node(node.value, dist[node.value]));
        }
      }
    }
    return dist;
  }

  static List<List<Integer>> nodes;
  static boolean[] visited;
  static int answer;

  public int solution_bfs(int n, int[][] edge) {

    visited = new boolean[n + 1];
    nodes = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      nodes.add(new ArrayList<>());
    }

    for (int[] edgeNode : edge) {
      nodes.get(edgeNode[0]).add(edgeNode[1]);
      nodes.get(edgeNode[1]).add(edgeNode[0]);
    }

    answer = 0;
    bfs(nodes);

    return answer;
  }

  private void bfs(List<List<Integer>> nodes) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{1, 0});
    visited[1] = true;
    int maxDepth = 0;

    while(!q.isEmpty()) {
      int[] cur = q.poll();
      int curLocation = cur[0];
      int curDepth = cur[1];
      List<Integer> adjList = nodes.get(curLocation);

      for (int i = 0; i < adjList.size(); i++) {
        if (visited[adjList.get(i)]) {
          continue;
        }

        visited[adjList.get(i)] = true;
        q.add(new int[]{adjList.get(i), curDepth + 1 });
      }

      if (maxDepth < curDepth) {
        maxDepth = curDepth;
        answer = 1;
      } else if (maxDepth == curDepth) {
        answer++;
      } else {
        break;
      }
    }
  }
}

class Node {
  int value;
  int cost;

  public Node(int value, int cost) {
    this.value = value;
    this.cost = cost;
  }

  @Override
  public String toString() {
    return String.format("[%d, %d]", value, cost);
  }
}