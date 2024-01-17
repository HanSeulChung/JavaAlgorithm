package com.codingtest.programmers.level3.가장긴펠린드롬;

public class Solution {
  public int solution(String s) {

    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = 0; j + i <= s.length() - 1; j++) {
        if (isPalindrome(s, j, i + j)) {
          return i + 1;
        }
      }
    }
    return 0;
  }

  private boolean isPalindrome(String value, int start, int end) {
    while (start <= end) {
      if (value.charAt(start++) != value.charAt(end--)) return false;
    }
    return true;
  }
}
