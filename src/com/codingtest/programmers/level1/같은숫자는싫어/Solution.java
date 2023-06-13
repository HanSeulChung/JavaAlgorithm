package com.codingtest.programmers.level1.같은숫자는싫어;
import java.util.*;
public class Solution {
    public static int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> numStack = new Stack<Integer>();
        for(int element : arr){
            if(numStack.isEmpty()){
                numStack.push(element);
            }
            else if(numStack.peek()!=element){
                numStack.push(element);
            }
        }
        answer = numStack.stream().mapToInt(i->i).toArray();

        for(int num: answer){
            System.out.print(num+" ");
        }
        return answer;
    }
    public static int[] perfectsolution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }
    public static void main(String[] args){
        int[] arr = {1,1,3,3,0,1,1};
        int[] answer = {};
        answer = solution(arr);
        System.out.println(answer);
        arr = new int[]{4,4,4,3,3};
        System.out.println(solution(arr));

    }
}