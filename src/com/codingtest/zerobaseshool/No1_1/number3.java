package com.codingtest.zerobaseshool.No1_1;

//12점 -> 20점
//answer 가 2개 이상일 경우 큰 값 반환을 하지 않았었음. 문제를 잘 읽자!!


import java.util.Stack;

public class number3 {
    public static int solution2(int[] A) {
        int answer = 0;

        if (A[0] < A[1] || A[2] < A[3]) {
            answer = Math.max((A[1] - A[0]),(A[3] - A[2]));
        } else if (A[0] > A[1] && A[2] > A[3]) {
            answer = 0;
        }

        return answer;
    }
    public static int solution1(int[] A){
        int answer = 0;
        for(int i = 0 ; i<A.length-1; i++){
            for (int j = i+1; j < A.length; j++) {
                if(A[j] - A[i] > 0){
                    answer = Math.max(A[j] - A[i],answer);
                }
            }
        }
        return answer;
    }
    public static int solution(int[] A) {
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

    public static void main(String[] args) {
        int[] A = {100000, 99000, 99000, 98000, 97000};
        System.out.println(solution2(A));
        A = new int[]{100000, 98000, 95000, 98000, 92000};
        System.out.println(solution2(A));
        System.out.println();
        A = new int[]{100000, 99000, 99000, 98000, 97000};
        System.out.println(solution1(A));
        A = new int[]{100000, 98000, 95000, 98000, 92000};
        System.out.println(solution1(A));
    }
}
