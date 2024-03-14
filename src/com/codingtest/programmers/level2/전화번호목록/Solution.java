package com.codingtest.programmers.level2.전화번호목록;

import java.util.*;

public class Solution {
  public boolean solution(String[] phone_book) {
    Map<String, Integer> map = new HashMap<>();
    for (String phone : phone_book) {
      map.put(phone, phone.length());
    }

    for (int idx = 0; idx < phone_book.length; idx++) {
      for (int length = 0; length < phone_book[idx].length(); length++) {
        if (map.containsKey(phone_book[idx].substring(0, length))) {
          return false;
        }
      }
    }

    return true;
  }
}
