package com.codingtest.programmers.level2.프로세스;

import java.util.*;

public class Solution {
  public int solution(int[] priorities, int location) {
    int answer = 0;
    Queue<Process> q = new LinkedList<>();
    int idx = 0;
    for (int priority : priorities) {
      q.offer(new Process(idx++, priority));
    }

    priorities = Arrays.stream(priorities).boxed()
        .sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();

    idx = 0;
    while(!q.isEmpty()) {
      Process curProcess = q.poll();
      if (curProcess.priorityScore == priorities[idx]) {
        idx++;
        answer++;
        if (curProcess.idx == location) {
          break;
        }
      } else {
        q.offer(curProcess);
      }
    }
    return answer;
  }


  class Process {
    int idx;
    int priorityScore;

    public Process(int idx, int priorityScore) {
      this.idx = idx;
      this.priorityScore = priorityScore;
    }

    @Override
    public String toString() {
      return "Process{idx= " + idx + ", priorityScore= " + priorityScore + "}";
    }
  }
}
