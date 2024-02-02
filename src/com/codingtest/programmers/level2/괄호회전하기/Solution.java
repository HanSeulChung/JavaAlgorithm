package com.codingtest.programmers.level2.괄호회전하기;

import java.util.*;

public class Solution {
  static Map<Character, Character> map;
  static Stack<Character> stack;

  public int solution(String s) {
    int answer = 0;
    map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    stack = new Stack<>();

    int idx = 0;
    if (checkRight(s)) {
      answer++;
    }

    while(idx < s.length() - 1) {
      s = s.substring(1) + s.substring(0, 1);
      if (checkRight(s)) {
        answer++;
      }
      idx++;
    }
    return answer;
  }

  private boolean checkRight(String s) {
    for (int idx = 0; idx < s.length(); idx++) {
      if (!map.containsKey(s.charAt(idx))) {
        stack.add(s.charAt(idx));
        continue;
      }

      if (stack.isEmpty() && map.containsKey(s.charAt(idx))) {
        return false;
      }

      while(!stack.isEmpty()) {
        if (stack.peek() == map.get(s.charAt(idx))) {
          stack.pop();
          break;
        } else {
          return false;
        }
      }
    }

    if (!stack.isEmpty()) {
      return false;
    }

    return true;
  }
}
