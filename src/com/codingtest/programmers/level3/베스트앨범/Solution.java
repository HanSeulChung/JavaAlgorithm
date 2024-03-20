package com.codingtest.programmers.level3.베스트앨범;

import java.util.*;
import java.util.stream.Collectors;
public class Solution {
  public int[] solution(String[] genres, int[] plays) {
    Map<String, Integer> songsTotalTime = new HashMap<>();
    Map<String, List<Song>> songs = new HashMap<>();
    for (int idx = 0; idx < genres.length; idx++) {
      songsTotalTime.put(genres[idx],
          songsTotalTime.getOrDefault(genres[idx], 0) + plays[idx]);
      if (!songs.containsKey(genres[idx])) {
        songs.put(genres[idx], new ArrayList<>());
      }
      songs.get(genres[idx]).add(new Song(idx, plays[idx]));
    }

    List<Map.Entry<String, Integer>> sortedEntries = songsTotalTime.entrySet()
        .stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .collect(Collectors.toList());

    List<Integer> answer = new ArrayList<>();
    for (Map.Entry<String, Integer> sortedEntry : sortedEntries) {
      String key = sortedEntry.getKey();
      List<Song> songsList = songs.get(key);
      Collections.sort(songsList, Comparator.comparingInt((Song song) -> song.playLength).reversed());

      for (int i = 0; i < (2 <= songsList.size() ? 2 : songsList.size()); i++) {
        answer.add(songsList.get(i).index);
      }
    }
    return answer.stream().mapToInt(i -> i).toArray();
  }
}

class Song {
  int index;
  int playLength;

  public Song(int index, int playLength) {
    this.index = index;
    this.playLength = playLength;
  }
}
