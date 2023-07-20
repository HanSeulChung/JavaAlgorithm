package com.codingtest.programmers.level1.크레인인형뽑기게임;

import java.util.*;

public class Solution {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> resultStack = new Stack<>();

        for (int move : moves){
            for (int i = 0; i < board.length; i++){
                int tmp = board[i][move - 1];
                if (tmp != 0){
                    if (!resultStack.isEmpty() && resultStack.peek()==tmp){
                        resultStack.pop();
                        answer += 2;
                    } else{
                        resultStack.push(tmp);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }
}
