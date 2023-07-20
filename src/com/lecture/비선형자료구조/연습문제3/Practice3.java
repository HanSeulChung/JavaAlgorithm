package com.lecture.비선형자료구조.연습문제3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Practice3 {

    public static class Customer {
        int id;
        int w;

        public Customer(int id, int w) {
            this.id = id;
            this.w = w;
        }
    }

    public static class Counter implements Comparable<Counter> {
        int no;
        int id;
        int time;

        public Counter(int no, int id, int time) {
            this.no = no;
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Counter o) {
            if (this.time < o.time) { // time이 작은거 먼저 나와야한다.
                return - 1;
            } else if (this.time == o.time) {
                if (this.no < o.no) { // no가 큰거 먼저 나와야한다
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return 1;
            }
        }
    }

    public static ArrayList<Integer> solution(int k, int[][] customers) {
        if (customers == null || customers.length == 0 || customers[0].length == 0) {
            return null;
        }

        int n = customers.length;

        Queue<Customer> waitQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            waitQueue.offer(new Customer(customers[i][0], customers[i][1]));
        }

        PriorityQueue<Counter> pqCounter = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            Customer customer = waitQueue.poll();

            if (customer != null) {
                pqCounter.offer(new Counter(i, customer.id, customer.w));
            }
        }

        PriorityQueue<Integer> pqCounterDone = new PriorityQueue<>();

        int curTime = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(!pqCounter.isEmpty()) {
            Counter counter = pqCounter.poll();

            result.add(counter.id);
            curTime = Math.max(curTime, counter.time);
            pqCounterDone.offer(counter.no);

            while(!pqCounter.isEmpty()) {
                if (pqCounter.peek().time == curTime) {
                    Counter c = pqCounter.poll();
                    result.add(c.id);
                    pqCounterDone.offer(c.no);
                } else {
                    break;
                }
            }

            while (!pqCounterDone.isEmpty()) {
                Customer customer = waitQueue.poll();
                if (customer != null) {
                    pqCounter.offer(new Counter(pqCounterDone.poll(), customer.id, curTime + customer.w));
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] customers = {{1, 4}, {2, 5}, {3, 14}, {4, 1}, {5, 7}, {6, 5}, {7, 7}, {8, 5}, {9, 10}, {10, 3}};
        System.out.println(solution(3, customers));
    }
}

