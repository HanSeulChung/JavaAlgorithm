package com.codingtest.programmers.level2.광물캐기;

import java.util.*;
public class Solution {

  static class ContinuousFatigue {
    private int diamondFatigue;
    private int ironFatigue;
    private int stoneFatigue;

    public ContinuousFatigue(int diamondFatigue, int ironFatigue, int stoneFatigue) {
      this.diamondFatigue = diamondFatigue;
      this.ironFatigue = ironFatigue;
      this.stoneFatigue = stoneFatigue;
    }
  }

  static int[][] scoreBoard;

  public int solution(int[] picks, String[] minerals) {
    int answer = 0;
    scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    int totalPicks = Arrays.stream(picks).sum();
    List<ContinuousFatigue> fatigueList = new ArrayList<>();
    for (int i = 0; i < minerals.length; i += 5) {
      if (totalPicks == 0) {
        break;
      }
      int diaFatigue = 0, ironFatigue = 0, stoneFatigue = 0;
      for (int j = i; j < i + 5; j++) {
        if (j == minerals.length) {
          break;
        }

        int idx = minerals[j].equals("iron") ? 1 :
            minerals[j].equals("stone") ? 2 : 0;
        diaFatigue += scoreBoard[0][idx];
        ironFatigue += scoreBoard[1][idx];
        stoneFatigue += scoreBoard[2][idx];
      }
      fatigueList.add(new ContinuousFatigue(diaFatigue, ironFatigue, stoneFatigue));
      totalPicks--;
    }

    Collections.sort(fatigueList, ((o1, o2) -> (o2.stoneFatigue - o1.stoneFatigue)));

    for (ContinuousFatigue f : fatigueList) {
      if (picks[0] > 0) {
        answer += f.diamondFatigue;
        picks[0]--;
        continue;
      }

      if (picks[1] > 0) {
        answer += f.ironFatigue;
        picks[1]--;
        continue;
      }

      if (picks[2] > 0) {
        answer += f.stoneFatigue;
        picks[2]--;
      }
    }
    return answer;
  }

}
