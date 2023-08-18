package com.codingtest.zerobaseshool.코딩테스트6주차;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P2 {
    public int solution(int[] amount, int[] value, int[] stomach) {
        List<Meat> meats = IntStream.range(0, amount.length)
                .boxed()
                .map(i -> new Meat(value[i], amount[i]))
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

class Meat implements Comparable<Meat> {
    int value;
    int amount;

    public Meat(int value, int amount) {
        this.value = value;
        this.amount = amount;
    }

    @Override
    public int compareTo(Meat o) {
        return this.value - o.value;
    }
}

