package com.codingtest.programmers.level2.파일명정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public void print(List<String[]> fileList) {
    for (String[] file : fileList) {
      System.out.print(Arrays.toString(file));
    }
    System.out.println();
  }

  public String[] solution(String[] files) {
    String[] answer = new String[files.length];
    List<String[]> fileList = new ArrayList<>();
    for (String file : files) {
      String[] f = splitFile(file);
      fileList.add(f);
    }

    Collections.sort(fileList, new Comparator<String[]>() {
      @Override
      public int compare(String[] arr1, String[] arr2) {
        int compareResult = arr1[0].compareToIgnoreCase(arr2[0]);
        if (compareResult != 0) {
          return compareResult;
        }

        return Integer.compare(Integer.parseInt(arr1[1]), Integer.parseInt(arr2[1]));
      }
    });

    int idx = 0;
    for (String[] splitFile : fileList) {
      answer[idx++] = mergeFile(splitFile);
    }

    return answer;
  }

  private String[] splitFile(String file) {
    boolean[] visited = new boolean[file.length()];
    String[] arr = new String[3];
    StringBuilder sb = new StringBuilder();

    int idx = 0;
    int cnt = 0;
    for (int i = 0; i < file.length(); i++) {
      if (visited[i]) {
        continue;
      }

      char c = file.charAt(i);
      if (Character.isDigit(c) && cnt == 0) {
        arr[idx++] = sb.toString();
        sb.setLength(0);
        cnt = 0;
        while(i < file.length() && cnt <= 5 && Character.isDigit(file.charAt(i))) {
          sb.append(file.charAt(i));
          visited[i] = true;
          i++;
          cnt++;
        }
        arr[idx++] = sb.toString();
        sb.setLength(0);
        i--;
      } else {
        visited[i] = true;
        sb.append(c);
      }
    }
    arr[idx] = sb.toString();
    return arr;
  }

  private boolean isNumber(char c) {
    int tmp = c - '0';
    if (tmp >= 0 && tmp <= 9) {
      return true;
    }
    return false;
  }

  private String mergeFile(String[] splitfile) {
    StringBuilder sb = new StringBuilder();
    for (String f : splitfile) {
      sb.append(f);
    }
    return sb.toString();
  }
}
