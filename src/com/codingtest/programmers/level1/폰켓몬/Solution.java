package com.codingtest.programmers.level1.폰켓몬;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
  public int mySolution(int[] nums) {
    int answer = 0;
    Map<Integer, Integer> ponketmon = new HashMap<>();
    for (int num : nums) {
      ponketmon.put(num, ponketmon.getOrDefault(num, 0) + 1);
    }

    int count = nums.length / 2;
    Set<Integer> keys = ponketmon.keySet();

    return count > keys.size() ? keys.size() : count;
  }

  public int streamSolution(int[] nums) {
    return Arrays.stream(nums)
        .boxed()
        .collect(Collectors.collectingAndThen(Collectors.toSet(),
            phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
  }
}
