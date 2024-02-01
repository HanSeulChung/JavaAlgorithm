package com.codingtest.programmers.level2.혼자놀기의달인;

import java.util.*;

public class Solution {
  Map<Integer, Integer> cardBox;
  List<Integer> answerList = new ArrayList<>();

  public int solution(int[] cards) {
    int n = cards.length;
    boolean[] visited = new boolean[n];
    cardBox = new HashMap<>();
    for (int idx = 0; idx < n; idx++) {
      cardBox.put(idx, cards[idx] - 1);
    }

    List<Integer> boxList = new ArrayList<>();
    for (int idx = 0; idx < n; idx++) {
      int initCard = cardBox.get(idx);
      visited[idx] = true;
      boxList.add(idx);
      connectBox(initCard, visited, boxList);
    }

    if (answerList.size() == 1 || answerList.get(0) == n) {
      return 0;
    }

    Collections.sort(answerList, Collections.reverseOrder());
    return answerList.get(0) * answerList.get(1);
  }

  private void connectBox(int cardNumber, boolean[] visited, List<Integer> boxList) {

    if (visited[cardNumber]) {
      answerList.add(boxList.size());
      boxList.clear();
      return;
    }

    visited[cardNumber] = true;
    boxList.add(cardNumber);
    int nextNumber = cardBox.get(cardNumber);
    connectBox(nextNumber, visited, boxList);
  }
}
