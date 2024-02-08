package com.codingtest.programmers.level2.수식최대화;

import java.util.*;

public class Solution {
  static long max = Long.MIN_VALUE;
  static String[] priorityOperator = {"*" , "+", "-"};


  public long solution(String expression) {
    List<String> expressionList = new ArrayList<>();

    String num = "";
    for (int idx = 0; idx < expression.length(); idx++) {
      if (expression.charAt(idx) == '*' ||
          expression.charAt(idx) == '+' || expression.charAt(idx) == '-') {
        expressionList.add(num);
        num = "";
        expressionList.add(expression.charAt(idx) +"");
      } else {
        num += expression.charAt(idx);
      }
    }
    expressionList.add(num);

    changePriority(0, expressionList);

    return max;
  }

  private void swap(int a, int b) {
    String tmp = priorityOperator[a];
    priorityOperator[a] = priorityOperator[b];
    priorityOperator[b] = tmp;
  }

  private void changePriority(int depth, List<String> expressionList) {
    if (depth == 3) {
      List<String> subList = new ArrayList<>(expressionList);
      for (int i = 0; i < 3; i++) {
        for (int idx = 0; idx < subList.size(); idx++) {
          if (priorityOperator[i].equals(subList.get(idx))) {
            subList.set(idx - 1,
                cal(subList.get(idx - 1), subList.get(idx + 1), subList.get(idx)));
            subList.remove(idx);
            subList.remove(idx);
            idx--;
          }
        }
      }
      max = Math.max(max, Math.abs(Long.parseLong(subList.get(0))));
      return;
    }

    for (int i = depth; i < 3; i++) {
      swap(i, depth);
      changePriority(depth + 1, expressionList);
      swap(i, depth);
    }
  }

  private String cal(String num1, String num2, String operator) {
    long n1 = Long.parseLong(num1);
    long n2 = Long.parseLong(num2);
    if (operator.equals("*")) {
      return n1 * n2 + "";
    } else if (operator.equals("+")) {
      return n1 + n2 + "";
    }
    return n1 - n2 + "";
  }
}
