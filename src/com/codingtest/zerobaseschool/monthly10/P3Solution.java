package com.codingtest.zerobaseschool.monthly10;


import java.util.*;

// 그래프의 간선 정보를 담는 클래스
class Edge {

  int to;
  int weight;

  public Edge(int to, int weight) {
    this.to = to;
    this.weight = weight;
  }
}

// 다익스트라 알고리즘에서 사용되는 노드 클래스
class Node {

  int vertex;
  int distance;

  public Node(int vertex, int distance) {
    this.vertex = vertex;
    this.distance = distance;
  }
}

public class P3Solution {

  private static boolean[] visited;

  public int solution(int N, int M, int[][] edges, int[] points) {
    int answer = Integer.MAX_VALUE;

    List<List<Edge>> graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];
      int weight = edge[2];
      graph.get(from).add(new Edge(to, weight));
      graph.get(to).add(new Edge(from, weight));
    }

    List<int[]> combinations = new ArrayList<>();
    visited = new boolean[graph.size()];
    combi(points, new int[3], combinations, 0, 3);

    for (int[] combination : combinations) {
      int distance = 0;
      int current = 1; // 시작 노드는 1번 노드

      // 거점 조합을 따라가며 최단 경로를 찾음
      for (int point : combination) {
        int temp = dijkstra(graph, current, point);
        if (temp == -1) {
          distance = -1; // 불가능한 경로이므로 -1을 할당하고 종료
          break;
        }
        distance += temp;
        current = point; // 다음 거점으로 이동
      }

      if (distance != -1) {
        int temp = dijkstra(graph, current, N); // 마지막 거점부터 목표 지점까지의 최단 경로
        if (temp != -1) {
          distance += temp;
          answer = Math.min(answer, distance);
        }
      }
    }

    if (answer == Integer.MAX_VALUE) {
      return -1; // 최단 경로를 찾지 못한 경우
    }

    return answer;
  }

  private int dijkstra(List<List<Edge>> graph, int start, int end) {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
    boolean[] visited = new boolean[graph.size()];
    int[] distances = new int[graph.size()];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[start] = 0;
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int currentVertex = current.vertex;
      int currentDistance = current.distance;
      if (visited[currentVertex])
        continue;
      visited[currentVertex] = true;

      for (Edge neighbor : graph.get(currentVertex)) {
        if (!visited[neighbor.to] && currentDistance + neighbor.weight < distances[neighbor.to]) {
          distances[neighbor.to] = currentDistance + neighbor.weight;
          pq.offer(new Node(neighbor.to, distances[neighbor.to]));
        }
      }
    }

    return distances[end] == Integer.MAX_VALUE ? -1 : distances[end];
  }

  private void combi(int[] points, int[] current, List<int[]> result, int idx, int k) {
    if (k == 0) {
      result.add(current.clone());
      return;
    }

    for (int i = 0; i < points.length; i++) {
      if (!visited[i]) {
        current[idx] = points[i];
        visited[i] = true;
        combi(points, current, result, idx + 1, k - 1);
        visited[i] = false;
      }
    }
  }
}
