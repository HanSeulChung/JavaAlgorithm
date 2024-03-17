package com.codingtest.programmers.level5.시험장나누기;

public class Solution {
  static final int MAX = 10000;
  int[] g_num;
  int[] parents;
  int[][] child;
  int root, cnt, g_limit;

  int dfs(int node) {
    if (node == -1) {
      return 0;
    }

    if (g_num[node] > g_limit) {
      cnt = MAX + 1;
      return g_num[node];
    }

    int numL = dfs(child[node][0]);
    int numR = dfs(child[node][1]);

    if (numL + numR + g_num[node] <= g_limit) {
      return numL + numR + g_num[node];
    }

    if (numL == 0 || numR == 0) {
      cnt++;
      return g_num[node];
    }

    if (numL + g_num[node] <= g_limit && numR + g_num[node] <= g_limit) {
      cnt++;
      return numL > numR ? g_num[node] + numR : g_num[node] + numL;
    }

    if (numL + g_num[node] <= g_limit) {
      cnt++;
      return numL + g_num[node];
    }

    if (numR + g_num[node] <= g_limit) {
      cnt++;
      return numR + g_num[node];
    }

    cnt += 2;
    return g_num[node];
  }

  boolean check(int limit, int k) {
    cnt = 0;
    g_limit = limit;
    dfs(root);
    if (cnt < k) {
      return true;
    }
    return false;
  }

  public int solution(int k, int[] num, int[][] links) {
    g_num = new int[num.length];
    parents = new int[num.length];
    child = new int[num.length][2];

    int sum = 0;
    for (int i = 0; i < num.length; i++) {
      parents[i] = -1;
      g_num[i] = num[i];
      sum += g_num[i];
    }
    for (int i = 0; i < num.length; i++) {
      child[i][0] = links[i][0];
      child[i][1] = links[i][1];

      if (child[i][0] != -1) {
        parents[child[i][0]] = i;
      }
      if (child[i][1] != -1) {
        parents[child[i][1]] = i;
      }
    }

    for (int i = 0; i < num.length; i++) {
      if (parents[i] == -1) {
        root = i;
        break;
      }
    }

    int low = sum / k;
    int high = sum;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (check(mid, k)) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
