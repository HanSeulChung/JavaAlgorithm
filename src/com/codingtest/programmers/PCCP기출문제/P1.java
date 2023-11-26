package com.codingtest.programmers.PCCP기출문제;

/**
 * 붕대감기
 * 뭔가 해당 문제를 어디선가 본것같은데 기억이 안남..
 */

import java.util.*;

public class P1 {
  public int solution(int[] bandage, int health, int[][] attacks) {
    int time = 0;
    int maxHealth = health;

    Arrays.sort(attacks, (o1, o2) -> o1[0] - o2[0]);
    Queue<int[]> queue = new LinkedList<>();

    for (int[] attack : attacks) {
      queue.offer(attack);
    }

    int cnt = 0;
    while (!queue.isEmpty()) {
      while(++time < queue.peek()[0]) {
        cnt++;
        if (health < maxHealth && cnt < bandage[0]) {
          health = Math.min(maxHealth, health + bandage[1]);
        } else if (cnt == bandage[0]) {
          health = Math.min(maxHealth, health + bandage[1] + bandage[2]);
          cnt = 0;
        }
      }
      int[] curAttack = queue.poll();
      health -= curAttack[1];
      cnt = 0;
      if (health <= 0) {
        return - 1;
      }
    }

    return health;
  }
}
