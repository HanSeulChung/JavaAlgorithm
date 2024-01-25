package com.codingtest.programmers.level2.숫자카드나누기;

import java.util.*;

public class Solution {
  public int solution(int[] arrayA, int[] arrayB) {
    int answer = 0;
    int gcdA = arrayA[0];
    int gcdB = arrayB[0];

    for (int i = 0; i < arrayA.length; i++) {
      gcdA = gcd(gcdA, arrayA[i]);
    }
    for (int i = 0; i < arrayB.length; i++) {
      gcdB = gcd(gcdB, arrayB[i]);
    }

    if (checkNotDivisible(arrayA , gcdB)) {
      if (answer < gcdB) {
        answer = gcdB;
      }
    }

    if (checkNotDivisible(arrayB , gcdA)) {
      if (answer < gcdA) {
        answer = gcdA;
      }
    }

    return answer;
  }

  private boolean checkNotDivisible(int[] arrayA, int num) {

    boolean isNotDivisible = Arrays.stream(arrayA)
        .allMatch(element -> element % num != 0);
    return isNotDivisible;
  }

  private int gcd(int a, int b){
    if(a % b == 0) return b;
    return gcd(b, a % b);
  }

}
