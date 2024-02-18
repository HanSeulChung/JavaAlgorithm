package com.codingtest.zerobaseschool;

import java.util.*;
public class firstThursDay {
    public static int solution1(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        if (n == 1){
            return 0;
        }

        for (int i = 2; i < n; i++) { // <=
            if(arr[i] == 0){
                answer++;
                for (int j = i; j < n; j = j+i) { // <= 일때는 틀렸음
                    arr[j] = 1;
                }
            }
        }
        return answer;
    }

    static int N;
    static int R = 4;
    static int[] nums;
    static int[] checkRnums = new int[R];
    static int answer;

    public void combination1(int cnt, int start){
        if (cnt == R){
            answer++;
            return;
        }
        for(int i = start; i < N; i++) {
            checkRnums[cnt] = nums[i];
            combination1(cnt+1, i+1);
        }
    }
    public int combination2(int n, int r){
        if (n == r || r == 0){
            return 1;
        } else {
            return combination2(n - 1, r - 1) + combination2(n - 1, r);
        }
    }
    public int solution2_1(String[] names) {
        answer = 0;
        HashSet<String> set = new HashSet<>();
        for (String name : names){
            if(!set.contains(name)){
                set.add(name);
            }
        }

        N = set.size();
        nums = new int[N];
        int idx = 0;
        for (int i = 1; i <= N; i++){
            nums[idx++] = i;
        }

        combination1(0, 0);

        return answer;
    }

    static int permutCnt;
    static ArrayList<Integer> checklist = new ArrayList<>();
    public int combination(int n, int r){
        if (n < r){
            return 1;
        }
        if (n == r || r == 0){
            return 1;
        } else {
            return combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }

    public void permutation(int[] numlist, int cnt, int K) {
        if (cnt == 0) {
            permutCnt++;
            return;
        }

        for(int i = 0; i < K; i++) {
            if(checklist.contains(numlist[i])) {
                continue;
            }
            checklist.add(numlist[i]);
            permutation(numlist, cnt - 1, K);
            checklist.remove(numlist.length - 1);
        }
    }


    public long solution5(int N, int M, int K, int[] capacity) {
        long answer = 1;
        int[] splitN = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++){
            splitN[i] = N;
            N -= capacity[i];
        }
        //System.out.println(Arrays.toString(splitN));
        for (int i = 0; i < capacity.length; i++){
            answer *= combination(splitN[i], capacity[i]);
        }

        permutCnt = 0;
        int[] list = new int[K];
        int idx = 0;
        for (int i = 1; i <= K; i++){
            list[idx++] = i;
        }
        //System.out.println(Arrays.toString(list));
        if (M == K){
            return answer;
        }
        permutation(list, M, K);
        answer *= permutCnt;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution1(6));


    }
}
