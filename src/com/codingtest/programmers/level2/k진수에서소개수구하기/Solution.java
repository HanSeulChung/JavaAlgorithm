package com.codingtest.programmers.level2.k진수에서소개수구하기;

public class Solution {
  public int solution(int n, int k) {
    int answer = 0;

     StringBuilder sb = new StringBuilder();
     while (n > 0) {
         sb.insert(0, n % k);
         n /= k;
     }


    String[] conditionNumbers = sb.toString().split("0");
    for (String conditionNumber : conditionNumbers) {
      if (conditionNumber.equals("")) {
        continue;
      }
      long checkNumber = Long.parseLong(conditionNumber);
      if (checkPrimeNumber(checkNumber)) {
        answer++;
      };
    }
    return answer;
  }

  private boolean checkPrimeNumber(long checkNumber) {
    if(checkNumber < 2) return false;

    for(int i = 2; i <= Math.sqrt(checkNumber); i++){
      if(checkNumber % i == 0){
        return false;
      }
    }
    return true;
  }
}
