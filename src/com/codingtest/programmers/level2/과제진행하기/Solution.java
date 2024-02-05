package com.codingtest.programmers.level2.과제진행하기;

import java.util.*;

public class Solution {
  static class Job {
    private String subject;
    private int start;
    private int during;
    private int remainingTime;

    public Job(String subject, int start, int during) {
      this.subject = subject;
      this.start = start;
      this.during = during;
    }

    public Job(String subject, int remainingTime) {
      this.subject = subject;
      this.remainingTime = remainingTime;
    }
  }

  public String[] solution(String[][] plans) {
    List<String> answer = new ArrayList<>();

    PriorityQueue<Job> pq = new PriorityQueue<>((o1, o2) -> {
      return o1.start - o2.start;
    });

    for (String[] plan : plans) {
      int start = makeMinute(plan[1]);
      int during = Integer.parseInt(plan[2]);
      pq.add(new Job(plan[0], start, during));
    }

    Stack<Job> remainingJobs = new Stack<>();
    while(!pq.isEmpty()) {
      Job currJob = pq.poll();

      if (pq.isEmpty()) {
        answer.add(currJob.subject);

        while(!remainingJobs.isEmpty()) {
          Job remainingJob = remainingJobs.pop();
          answer.add(remainingJob.subject);
        }
        break;
      }

      if (currJob.start + currJob.during == pq.peek().start) {
        answer.add(currJob.subject);
      } else if (currJob.start + currJob.during > pq.peek().start) {
        remainingJobs.add(
            new Job(currJob.subject, currJob.during - (pq.peek().start - currJob.start)));
      } else if (currJob.start + currJob.during < pq.peek().start) {
        answer.add(currJob.subject);
        int during = pq.peek().start - (currJob.start + currJob.during);
        while(!remainingJobs.isEmpty()) {
          Job remainingJob = remainingJobs.pop();
          if (remainingJob.remainingTime <= during) {
            answer.add(remainingJob.subject);
            during -= remainingJob.remainingTime;
          } else {
            remainingJobs.add(new Job(remainingJob.subject, remainingJob.remainingTime - during));
            break;
          }
        }
      }
    }

    return answer.toArray(new String[0]);
  }

  private int makeMinute(String time) {
    String[] arr = time.split(":");
    return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
  }
}
