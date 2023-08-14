package com.codingtest.programmers.level2.이모티콘할인행사;

public class Solution {
    int subscriber = 0;
    int profit = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        int[] arr =  new int[emoticons.length];

        dfs(arr, 0, users, emoticons);

        return new int[]{subscriber, profit};
    }

    public void dfs(int[] arr, int start, int[][] users, int[] emoticons){
        if(start == arr.length){
            int count = 0;
            int margin = 0;

            for(int[] user:users){
                int sum = 0;

                for(int i=0; i<arr.length; i++){
                    if(arr[i] >= user[0]){
                        sum += (emoticons[i] / 100) * (100 - arr[i]);
                    }
                }

                if(sum >= user[1]) count++;
                else margin += sum;
            }

            if (count > subscriber || (count == subscriber && profit < margin)){
                subscriber = count;
                profit = margin;
            }

            return;
        }

        for(int i=10; i<=40; i+=10){
            arr[start] = i;
            dfs(arr, start+1, users, emoticons);
        }
    }
}
