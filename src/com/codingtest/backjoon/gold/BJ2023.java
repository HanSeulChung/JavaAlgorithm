package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2023 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    dfs(N, 0, new StringBuilder());
  }

  private static void dfs(int N, int depth, StringBuilder sb) {
    if (depth == N) {
      System.out.println(sb.toString());
      return;
    }

    for (int i = 1; i <= 9; i++) {
      sb.append(i);
      if (checkPrimeNumber(Integer.parseInt(sb.toString()))) {
        dfs(N, depth + 1, sb);
      }
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  private static boolean checkPrimeNumber(int number) {
    if (number < 2) {
      return false;
    }

    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
