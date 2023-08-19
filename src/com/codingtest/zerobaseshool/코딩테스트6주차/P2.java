package com.codingtest.zerobaseshool.코딩테스트6주차;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P2 {
    public int bestsolution(int[] amount, int[] value, int[] stomach) {
        int answer = 0;
        PriorityQueue<Meat> pq = new PriorityQueue<>((x, y) -> y.value - x.value );

        for (int i = 0 ; i < value.length; i++) {
            pq.offer(new Meat(amount[i], value[i]));
        }

        int minStomach = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < stomach.length; i++) {
            sum += stomach[i];
            minStomach = Math.min(minStomach, stomach[i]);
        }

        Meat maxValueMeat = pq.poll();
        int n = maxValueMeat.amount / stomach.length;
        int v = maxValueMeat.value;

        if (n > minStomach) {
            int amt = minStomach * stomach.length;
            answer += v * amt;
            sum -= amt;
        } else {
            int amt = n * stomach.length;
            answer += v * amt;
            sum -= amt;
        }

        while (!pq.isEmpty()) {
            Meat curr = pq.poll();
            if (curr.amount > sum) {
                answer += curr.value * sum;
                break;
            } else {
                answer += curr.value * curr.amount;
                sum -= curr.amount;
            }
        }

        return answer;
    }
    public int solution(int[] amount, int[] value, int[] stomach) {
        List<Meat1> meats = IntStream.range(0, amount.length)
                .boxed()
                .map(i -> new Meat1(value[i], amount[i]))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int bestMeatConsumption =
                Math.min(meats.get(0).amount / stomach.length,
                        Arrays.stream(stomach).min().getAsInt()) * stomach.length;
        int totalStomach = Arrays.stream(stomach).sum() - bestMeatConsumption;
        int result = bestMeatConsumption * meats.get(0).value;

        for (int i = 1; i < meats.size(); i++) {
            int v = meats.get(i).value;
            int a = meats.get(i).amount;
            int consumption = Math.min(totalStomach, a);
            result += v * consumption;
            totalStomach -= consumption;
            if (totalStomach == 0) {
                break;
            }
        }
        return result;
    }

}

class Meat {
    int amount;
    int value;

    public Meat(int amount, int value) {
        this.amount = amount;
        this.value = value;
    }
}

class Meat1 implements Comparable<Meat1> {
    int value;
    int amount;

    public Meat1(int value, int amount) {
        this.value = value;
        this.amount = amount;
    }

    @Override
    public int compareTo(Meat1 o) {
        return this.value - o.value;
    }
}

