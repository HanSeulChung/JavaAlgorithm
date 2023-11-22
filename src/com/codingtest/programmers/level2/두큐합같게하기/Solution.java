package com.codingtest.programmers.level2.두큐합같게하기;

import java.util.*;
import java.util.stream.Collectors;
public class Solution {
  public int solution(int[] queue1, int[] queue2) {
    int answer = 0;
    long queue1Sum = Arrays.stream(queue1).sum();
    long queue2Sum = Arrays.stream(queue2).sum();
    int totalCount = queue1.length + queue2.length;
    if (queue1Sum == queue2Sum) {
      return 0;
    }

    if ((queue1Sum + queue2Sum) % 2 != 0) {
      return -1;
    }

    Queue<Integer> q1 = new LinkedList<>(Arrays.stream(queue1).boxed().
        collect(Collectors.toList()));
    Queue<Integer> q2 = new LinkedList<>(Arrays.stream(queue2).boxed().
        collect(Collectors.toList()));


    while(queue1Sum != queue2Sum) {
      if (queue1Sum < queue2Sum) {
        answer++;
        int tmpQ2 = q2.poll();
        queue2Sum -= tmpQ2;
        queue1Sum += tmpQ2;
        q1.add(tmpQ2);
      } else if (queue1Sum > queue2Sum) {
        answer++;
        int tmpQ1 = q1.poll();
        queue1Sum -= tmpQ1;
        queue2Sum += tmpQ1;
        q2.add(tmpQ1);
      }

      if (answer > totalCount * 2) {
        return -1;
      }
    }
    return answer;
  }
}
