package com.codingtest.zerobaseshool.코딩테스트4주차;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class myTask {
    int index;
    int start;
    int time;
    int end;

    public myTask(int index, int start, int time) {
        this.index = index;
        this.start = start;
        this.time = time;
        this.end = start + time;
    }
}

class Task implements Comparable<Task> {
    int startTime;
    int periodTime;
    int index;

    public Task(int startTime, int periodTime, int index) {
        this.startTime = startTime;
        this.periodTime = periodTime;
        this.index = index;
    }

    @Override
    public int compareTo(Task o) {
        if (this.periodTime == o.periodTime) {
            return this.index - o.index;
        }
        return this.periodTime - o.periodTime;
    }
}
public class P4 {
    public int[] mysolution(int[] start, int[] time) {
        int n = start.length;
        int[] answer = new int[n];

        PriorityQueue<myTask> pq = new PriorityQueue<>((a, b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            } else {
                return a.time - b.time;
            }
        });

        for (int i = 0; i < n; i++) {
            pq.offer(new myTask(i, start[i], time[i]));
        }

        int startTime = -1;
        int totalTime = 0;
        int idx = 0;
        while (!pq.isEmpty()) {
            myTask currentTask = pq.poll();
            startTime = currentTask.start;
            if (startTime >= totalTime) {
                answer[idx++] = currentTask.index;
                totalTime += currentTask.time;
            } else {
                pq.offer(new myTask(currentTask.index, totalTime, currentTask.time));
            }
        }
        return answer;
    }

    public int[] solution(int[] start, int[] time) {
        List<Task> tasks = IntStream.range(0, start.length).mapToObj(i -> new Task(start[i] ,time[i], i)).sorted((a, b) -> {
            if (a.startTime == b.startTime) {
                return a.index - b.index;
            }
            return a.startTime - b.startTime;
        }).collect(Collectors.toCollection(LinkedList::new));

        PriorityQueue<Task> priorityQueue = new PriorityQueue<>();
        int[] result = new int[tasks.size()];
        int currentIndex = 0;
        int currentTime = 0;
        while (currentIndex < result.length) {

            while (!tasks.isEmpty() && currentTime >= tasks.get(0).startTime) {
                priorityQueue.offer(tasks.remove(0));
            }

            if (!priorityQueue.isEmpty()) {
                Task currentTask = priorityQueue.remove();
                currentTime  += currentTask.periodTime;
                result[currentIndex++] = currentTask.index;
            } else {
                currentTime = tasks.get(0).startTime;
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
