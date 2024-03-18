package com.codingtest.programmers.level3.불량사용자;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {
  String[] g_user_id;
  String[] g_banned_id;
  Set<String> banned_ids = new HashSet<>();
  boolean[] visited;

  void dfs(int depth, StringBuffer sb) {
    if (depth == g_banned_id.length) {
      String[] ids = sb.toString().split(" ");
      Arrays.sort(ids);
      String banned_id = Arrays.stream(ids).collect(Collectors.joining());
      banned_ids.add(banned_id);
      return;
    }

    for (int idx = 0; idx < g_user_id.length; idx++) {
      if (visited[idx] || !Pattern.matches(g_banned_id[depth], g_user_id[idx])) continue;
      visited[idx] = true;
      int length = sb.length();
      dfs(depth + 1, sb.append(g_user_id[idx]).append(" "));
      sb.setLength(length);
      visited[idx] = false;
    }

  }

  public int solution(String[] user_id, String[] banned_id) {
    banned_id = Arrays.stream(banned_id)
        .map(s -> s.replaceAll("\\*", "\\."))
        .toArray(String[]::new);

    g_user_id = user_id;
    g_banned_id = banned_id;
    visited = new boolean[user_id.length];
    StringBuffer sb = new StringBuffer();
    dfs(0, sb);

    return banned_ids.size();
  }
}
