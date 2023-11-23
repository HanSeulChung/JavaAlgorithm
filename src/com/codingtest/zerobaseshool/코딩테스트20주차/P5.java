package com.codingtest.zerobaseshool.코딩테스트20주차;

import java.util.*;

public class P5 {
  static String[] parents;
  static Map<String, Integer> map;

  public static void union(int aIdx, String aStr, int bIdx, String bStr){
    String aP = find(aStr);
    String bP = find(bStr);

    if(!aP.equals(bP)){
      parents[map.get(aP)] = bP;
    }
  }

  public static String find(String aStr){

    int aIdx = map.get(aStr);
    if (aStr == parents[aIdx]){
      return aStr;
    }
    return parents[aIdx] = find(parents[aIdx]);
  }

  public boolean isUnion(String a, String b) {
    if (!map.containsKey(a) || !map.containsKey(b)) {
      return false;
    }
    String aP = find(a);
    String bP = find(b);

    return aP.equals(bP);
  }

  public int solution(String s, String t, String[][] similarWords) {
    int answer = 0;
    String[] sArray = s.split(" ");
    String[] tArray = t.split(" ");
    int N = sArray.length;

    parents = new String[similarWords.length * 2];

    map = new HashMap<>();
    int idx = 0;
    for (String[] similarSet : similarWords) {
      if (!map.containsKey(similarSet[0])) {
        map.put(similarSet[0], map.getOrDefault(similarSet[0], 0) + idx++);
      }
      if (!map.containsKey(similarSet[1])) {
        map.put(similarSet[1], map.getOrDefault(similarSet[1], 0) + idx++);
      }

      parents[map.get(similarSet[0])] = similarSet[0];
      parents[map.get(similarSet[1])] = similarSet[1];
      union(map.get(similarSet[0]), similarSet[0],
          map.get(similarSet[1]), similarSet[1]);
    }

    for (int i = 0; i < N; i++) {
      if (sArray[i].equals(tArray[i])) {
        answer++;
        continue;
      }
      if (isUnion(sArray[i], tArray[i])) {
        answer++;
      }
    }

    return answer;
  }
}
