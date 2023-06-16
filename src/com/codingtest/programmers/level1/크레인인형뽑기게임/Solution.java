package com.codingtest.programmers.level1.크레인인형뽑기게임;

import java.util.*;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> resultStack = new Stack<>();

        for(int move : moves){
            for(int i =0; i<board.length; i++){
                int tmp = board[i][move-1];
                if(tmp!=0){
                    if(!resultStack.isEmpty()&&resultStack.peek()==tmp){
                        resultStack.pop();
                        answer+=2;
                    } else{
                        resultStack.push(tmp);
                    }
                    board[i][move-1]=0;
                    break;
                }
            }
        }
        return answer;
    }
}
