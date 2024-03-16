package com.codingtest.programmers.level4.매출하락최소화;

import java.util.*;

public class Solution {
  List<List<Integer>> adjList;
  int[] g_sales;
  int[][] cost;

  void traversal(int node) {
    cost[node][0] = 0;
    cost[node][1] = g_sales[node];

    if (adjList.get(node).isEmpty()) {
      return;
    }

    int extraCost = Integer.MAX_VALUE;
    for (int children : adjList.get(node)) {
      traversal(children);
      if (cost[children][0] < cost[children][1]) {
        cost[node][0] += cost[children][0];
        cost[node][1] += cost[children][0];
        extraCost = Math.min(extraCost,
            cost[children][1] - cost[children][0]);
      } else {
        cost[node][0] += cost[children][1];
        cost[node][1] += cost[children][1];
        extraCost = 0;
      }
    }
    cost[node][0] += extraCost;
  }

  public int solution(int[] sales, int[][] links) {
    g_sales = sales;
    cost = new int[300000][2];
    adjList = new ArrayList<>();

    for (int i = 0; i < sales.length; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int[] link : links) {
      adjList.get(link[0] - 1).add(link[1] - 1);
    }

    traversal(0);

    return Math.min(cost[0][0], cost[0][1]);
  }
}
