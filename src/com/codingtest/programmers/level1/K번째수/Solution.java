package com.codingtest.programmers.level1.K번째수;

import java.util.*;

public class Solution {
  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    int idx = 0;
    for (int[] command : commands) {
      int[] subArr = new int[command[1] - command[0] + 1];
      int j = 0;
      for (int i = command[0] - 1; i < command[1]; i++) {
        subArr[j++] = array[i];
      }
      Arrays.sort(subArr);
      answer[idx++] = subArr[command[2] - 1];
    }
    return answer;
  }

  public int[] sortSolution(int[] array, int[][] commands) {
    int n = 0;
    int[] ret = new int[commands.length];

    while(n < commands.length){
      int m = commands[n][1] - commands[n][0] + 1;

      if(m == 1){
        ret[n] = array[commands[n++][0]-1];
        continue;
      }

      int[] a = new int[m];
      int j = 0;
      for(int i = commands[n][0]-1; i < commands[n][1]; i++)
        a[j++] = array[i];

      sort(a, 0, m-1);

      ret[n] = a[commands[n++][2]-1];
    }

    return ret;
  }

  void sort(int[] a, int left, int right){
    int pl = left;
    int pr = right;
    int x = a[(pl+pr)/2];

    System.out.printf("pl: %d, pr: %d, x: %d\n", pl, pr, x);
    do{
      while(a[pl] < x) {
        pl++;
        System.out.print("while a[pl] < x --> " + a[pl]+ "  ");
        System.out.println(pl);
      }
      while(a[pr] > x) {
        pr--;
        System.out.print("while a[pr] < x --> " + a[pr] + "  ");
        System.out.println(pr);
      }
      if(pl <= pr){
        int temp = a[pl];
        a[pl] = a[pr];
        a[pr] = temp;
        pl++;
        pr--;
      }
    }while(pl <= pr);

    if(left < pr) sort(a, left, pr);
    if(right > pl) sort(a, pl, right);
  }
}