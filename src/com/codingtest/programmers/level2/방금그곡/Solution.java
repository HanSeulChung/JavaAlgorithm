package com.codingtest.programmers.level2.방금그곡;

import java.util.*;

public class Solution {
  public String solution(String m, String[] musicinfos) {
    String answer = "";

    PriorityQueue<String[]> pq = new PriorityQueue<>((o1, o2) -> {
      if (o1[0].equals(o2[0])) {
        return o2[1].compareTo(o1[1]);
      }
      if (o1[1].equals(o2[1])) {
        return o1[2].compareTo(o2[2]);
      }
      return o1[0].compareTo(o2[0]);
    });

    for (String musicinfo : musicinfos) {
      String[] parse1 = musicinfo.split(",");
      parse1[1] = duringTime(parse1[0], parse1[1]);
      pq.add(parse1);
    }

    String newM = subSound(m);
    String newParse = "";

    int maxLength = Integer.MIN_VALUE;
    while (!pq.isEmpty()) {
      String[] curM = pq.poll();
      newParse = curM[3].contains("#") ? subSound(curM[3]) : curM[3];
      String realSong = realSong(Integer.parseInt(curM[1]), newParse);
      if (realSong.contains(newM)) {
        if (maxLength < Integer.parseInt(curM[1])) {
          maxLength = Integer.parseInt(curM[1]);
          answer = curM[2];
        }
      }
    }

    return answer.equals("") ? "(None)" : answer;
  }

  private String duringTime(String firstTime, String secondTime) {
    String[] firstTimeArr = firstTime.split(":");
    String[] secondTimeArr = secondTime.split(":");
    int realTime = 0;
    int startTimeHour = Integer.parseInt(firstTimeArr[0]);
    int endTimeHour = Integer.parseInt(secondTimeArr[0]);
    if (startTimeHour != endTimeHour) {
      realTime += 60 * (endTimeHour - startTimeHour);
    }
    realTime += Integer.parseInt(secondTimeArr[1]) - Integer.parseInt(firstTimeArr[1]);
    return String.valueOf(realTime);
  }

  private String realSong(int realTime, String music) {
    int musicTime = music.length();
    if (musicTime < realTime) {
      int q = realTime / musicTime;
      if (q != 0) {
        music = music.repeat(q + 1);
      }
    }  else if (musicTime > realTime) {
      music = music.substring(0, realTime);
    }
    return music;
  }

  private String subSound(String m) {
    m = m.replaceAll("C#", "Z");
    m = m.replaceAll("D#", "Y");
    m = m.replaceAll("F#", "X");
    m = m.replaceAll("G#", "L");
    m = m.replaceAll("A#", "M");

    return m;
  }
}
