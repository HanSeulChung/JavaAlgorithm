package com.codingtest.programmers.level3.연속펄스부분수열의합;

public class Solution {
  public long solution(int[] sequence) {
    long answer = 0;
    boolean isPlus = true;

    long purse1 = 0;
    long purse2 = 0;

    for (int i = 0; i < sequence.length; i++) {
      purse1 += isPlus ? -sequence[i] : sequence[i];
      purse2 += isPlus ? sequence[i] : -sequence[i];


      purse1 = Math.max(0, purse1);
      purse2 = Math.max(0, purse2);

      answer = Math.max(answer, Math.max(purse1, purse2));
      isPlus = isPlus ? false : true;
    }
    return answer;
  }
}
