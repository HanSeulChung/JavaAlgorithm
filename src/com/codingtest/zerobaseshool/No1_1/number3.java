package com.codingtest.zerobaseshool.No1_1;

//12점 -> 20점
//answer 가 2개 이상일 경우 큰 값 반환을 하지 않았었음. 문제를 잘 읽자!!


import java.util.Stack;

public class number3 {
    public int solution(int[] A) {
        int answer = 0;
        int can = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(A[0]);
        for(int i =1; i< A.length; i++){
            if(!stack.isEmpty() && stack.peek()<A[i]){
                int tmp = A[i] - stack.peek();
                if(answer == 0 || answer < tmp){
                    answer = tmp;
                }

            } else{
                stack.push(A[i]);
            }

        }
        //System.out.println(stack);
        return answer;
    }
}
