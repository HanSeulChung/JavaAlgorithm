package com.codingtest.programmers.level3.이중우선순위큐;

import java.util.*;

public class Solution {
  public int[] solution(String[] operations) {
    int[] answer = new int[2];
    List<Integer> numberList = new ArrayList<>();
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> {
      return o2 - o1;
    });

    PriorityQueue<Integer> minPQ = new PriorityQueue<>((o1, o2) -> {
      return o1 - o2;
    });

    for (String operation : operations) {
      String[] input = operation.split(" ");

      if (input[0].equals("I")) {
        int number = Integer.parseInt(input[1]);
        minPQ.add(number);
        maxPQ.add(number);
        numberList.add(number);
        continue;
      }

      if (numberList.size() == 0) {
        continue;
      } else if (numberList.size() == 1) {
        numberList.clear();
      }

      int value = Integer.parseInt(input[1]);
      if (value == 1) {
        if (!maxPQ.isEmpty()) {
          numberList.remove(maxPQ.poll());
        }
      } else if (value == -1) {
        if (!minPQ.isEmpty()) {
          numberList.remove(minPQ.poll());
        }
      }
    }

    if (numberList.size() == 0) {
      return answer;
    } else if (numberList.size() == 1) {
      answer[0] = numberList.get(0) > 0 ? numberList.get(0) : 0;
      answer[1] = numberList.get(0) < 0 ? numberList.get(0) : 0;
      return answer;
    }

    Collections.sort(numberList);
    answer[0] = numberList.get(numberList.size() - 1);
    answer[1] = numberList.get(0);

    return answer;
  }
}
