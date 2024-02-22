package com.codingtest.backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15897 {

  public static void main(String[] args)  throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long N = Long.parseLong(st.nextToken());

    long result = N;
    for (long i = 1, j = 1; i < N; i = j + 1) {
      j = (N - 1) /((N - 1) / i);
      result +=  (j - i + 1) * ((N - 1) / i);
    }
    System.out.println(result);
  }
}
