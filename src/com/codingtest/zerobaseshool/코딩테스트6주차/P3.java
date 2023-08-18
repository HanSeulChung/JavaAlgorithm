package com.codingtest.zerobaseshool.코딩테스트6주차;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P3 {
    // 투포인터 + 해쉬 맵
    public int mysolution(String[] ingredients, String[] items) {
        int answer = Integer.MAX_VALUE;

        Map<String, Integer> neededIngredients = new HashMap<>();
        for (String ingredient : ingredients) {
            neededIngredients.put(ingredient, 1);
        }

        int left = 0;
        int remainingIngredients = neededIngredients.size();

        for (int right = 0; right < items.length; right++) {
            if (neededIngredients.containsKey(items[right])) {
                neededIngredients.put(items[right], neededIngredients.get(items[right]) - 1);
                if (neededIngredients.get(items[right]) == 0) {
                    remainingIngredients--;
                }
            }

            while (remainingIngredients == 0) {
                answer = Math.min(answer, right - left + 1);

                if (neededIngredients.containsKey(items[left])) {
                    neededIngredients.put(items[left], neededIngredients.get(items[left]) + 1);
                    if (neededIngredients.get(items[left]) > 0) {
                        remainingIngredients++;
                    }
                }
                left++;
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public int solution(String[] ingredients, String[] items) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> ingredientsSet = Arrays.stream(ingredients)
                .collect(Collectors.toSet());

        int left = 0, right = 0;
        map.put(items[left], 1);
        int result = items.length;
        if (map.keySet().containsAll(ingredientsSet)) {
            result = 1;
        }

        while (left <= right) {
            if (map.keySet().containsAll(ingredientsSet)) {
                if (result > right - left + 1) {
                    result = right - left + 1;
                }

                if (map.get(items[left]) == 1) {
                    map.remove(items[left]);
                } else {
                    map.put(items[left], map.get(items[left]) - 1);
                }
                left++;
            } else {
                right++;

                if (right == items.length) {
                    break;
                }

                if (!map.containsKey(items[right])) {
                    map.put(items[right], 1);
                } else {
                    map.put(items[right], map.get(items[right]) + 1);
                }
            }
        }
        return result;
    }
}
