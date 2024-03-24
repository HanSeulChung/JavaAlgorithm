package com.codingtest.programmers.level3.단어변환;

import java.util.*;

public class Solution {
  static boolean[] visited;
  static String[] g_words;
  static int answer = Integer.MAX_VALUE;

  public int solution(String begin, String target, String[] words) {
    Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
    if (!wordsSet.contains(target)) {
      return 0;
    }

    visited = new boolean[words.length];
    g_words = words;
    dfs(begin, target, 0);
    return answer;
  }

  private void dfs(String begin, String target, int cnt) {
    if (checkOneChar(begin, target)) {
      answer = Math.min(answer, cnt) + 1;
      return;
    }

    for(int idx = 0; idx < g_words.length; idx++) {
      if (visited[idx]) continue;

      if (!checkOneChar(begin, g_words[idx])) continue;

      visited[idx] = true;
      dfs(g_words[idx], target, cnt + 1);
      visited[idx] = false;
    }
  }

  private boolean checkOneChar(String s1, String s2) {
    int wrongCnt = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        wrongCnt++;
      }
      if (wrongCnt > 1) {
        return false;
      }
    }

    return true;
  }
}
