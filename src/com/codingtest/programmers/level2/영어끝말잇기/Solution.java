package com.codingtest.programmers.level2.영어끝말잇기;

import java.util.*;

public class Solution {
  public int[] solution(int n, String[] words) {
    int[] answer = new int[2];

    Set<String> befores = new HashSet<>();
    String beforeWord = words[0];
    befores.add(beforeWord);

    int cnt = 1;
    for (int idx = 1; idx < words.length; idx++) {
      cnt++;
      String presentWord = words[idx];
      if (beforeWord.charAt(beforeWord.length() - 1) != presentWord.charAt(0)) {
        break;
      }
      if (befores.contains(presentWord)) {
        break;
      }
      befores.add(presentWord);
      beforeWord = presentWord;
    }

    if (cnt == words.length && befores.size() == words.length) {
      return answer;
    }

    if (cnt % n == 0) {
      answer[0] = n;
      answer[1] = cnt / n;
      return answer;
    }

    answer[0] = cnt % n;
    answer[1] = cnt / n + 1;
    return answer;
  }
}
