package com.codingtest.programmers.skillcheck;

import java.util.stream.Stream;
import java.util.*;
public class MakeBigNumber {
    public static String solution(String number, int k){
        String answer = "";
        StringBuilder str = new StringBuilder();
        //int[] sliceStringnumber = Stream.of(number.split("")).mapToInt(Integer::parseInt).toArray();
        Stack<Character> stack = new Stack<>();
        int count = k;
        for(int i =0; i<number.length(); i++){
            char c = number.charAt(i);
            while(!stack.isEmpty() && stack.peek()< c && count>0){
                stack.pop();
                --count;
            }
            stack.push(c);
        }
        if(stack.size()== number.length()-k){
            for(char c: stack){
                str.append(c);
            }
        }
        System.out.println(stack);
        answer= str.toString();
        return answer;
    }

    public static void main(String[] args) {
        String number ="1231234";
        int k = 3;
        System.out.println(solution(number, k));

        number ="4177252841";
        k = 4;
        System.out.println(solution(number, k));
    }
}
