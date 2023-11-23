package com.codingtest.zerobaseshool.코딩테스트20주차;

public class P1 {
  public boolean solution(String s, String t) {
    boolean answer = true;
    String[] sArray = s.split(" ");
    String[] tArray = t.split(" ");

    if (sArray.length != tArray.length) {
      return false;
    }
    if (sArray[0].charAt(0) != tArray[0].charAt(0)) {
      return false;
    }

    for (int i = 0; i < sArray.length; i++) {
      String answerStr = sArray[i];
      String checkStr = tArray[i];
      int finishIdx = answerStr.length() - 1;
      if (answerStr.charAt(0) != checkStr.charAt(0)) {
        return false;
      }

      if (answerStr.charAt(finishIdx) != checkStr.charAt(finishIdx)) {
        return false;
      }
    }

    return answer;
  }
}
