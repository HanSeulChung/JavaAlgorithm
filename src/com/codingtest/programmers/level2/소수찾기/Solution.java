package com.codingtest.programmers.level2.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  static Set<Integer> numberSet = new HashSet<>();
  static boolean[] visited;

  public int solution(String numbers) {
    int answer = 0;
    String[] numberArr = numbers.split("");
    visited = new boolean[numberArr.length];
    StringBuilder sb = new StringBuilder();
    makeNumber(numberArr, 0, 0, sb);

    for (int number : numberSet) {
      if (checkPrime(number)) {
        answer++;
      }
    }

    return answer;
  }

  private void makeNumber(String[] numberArr, int idx, int length, StringBuilder sb){
    if (length > numberArr.length) {
      return;
    }

    if (length != 0 && sb.charAt(0) != '0') {
      numberSet.add(Integer.parseInt(sb.toString()));
    }

    for (int i = 0; i < numberArr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        sb.append(numberArr[i]);
        makeNumber(numberArr, idx + 1, length + 1, sb);
        visited[i] = false;
        sb.delete(length, length + 1);
      }
    }

  }
  private boolean checkPrime(int checkNumber) {
    if(checkNumber < 2) return false;

    for(int i = 2; i <= Math.sqrt(checkNumber); i++){
      if(checkNumber % i == 0){
        return false;
      }
    }
    return true;
  }
}
