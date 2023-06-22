package com.codingtest.zerobaseshool.No1_4;

import java.util.Arrays;
public class number2 {
    public static int solution(String[] arr) {
        int answer = 0;
        int stringMinsize = Integer.MAX_VALUE;
        int idx = 0;
        StringBuilder str = new StringBuilder();
        for(int i =0; i< arr.length; i++){
            String S = arr[i];
            if(stringMinsize > S.length()){
                stringMinsize = S.length();
                idx = i;
            }
        }
        char[] minS = arr[idx].toCharArray();

        for(int i =0; i< arr.length; i++){
            if(i==idx){
                continue;
            }
            String S = arr[i];
            int k = S.length()-stringMinsize;
            for(int j =0; j<stringMinsize; j++){
                char c = S.charAt(k);
                if(c!=minS[j]) {
                    minS[j] = '0';
                }
                k++;
            }
        }
        for(int i =0; i<minS.length; i++){
            if(i==minS.length-1){
                answer += minS[i] - '0';
            }else{
                answer += (minS[i]-'0')*(int)Math.pow(2,minS.length - i -1);
            }
            //System.out.println(minS.length - i -1);
            //System.out.println(answer);
        }
        //System.out.println(Arrays.toString(minS));
        //answer = Integer.parseInt(new String(minS),2);
        //System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {"10110", "1010", "11110"};
        System.out.println(solution(arr));
    }

    public static int badsolution(String[] arr) {
        int answer = 0;
        int stringMinsize = Integer.MAX_VALUE;
        int idx = 0;
        StringBuilder str = new StringBuilder();
        for(int i =0; i< arr.length; i++){
            String S = arr[i];
            if(stringMinsize > S.length()){
                stringMinsize = S.length();
                idx = i;
            }
        }
        char[] minS = arr[idx].toCharArray();

        for(int i =0; i< arr.length; i++){
            if(i==idx){
                continue;
            }
            String S = arr[i];
            int k = S.length()-stringMinsize;
            for(int j =0; j<stringMinsize; j++){
                char c = S.charAt(k);
                if(c!=minS[j]){
                    minS[j] = '0';
                }
                k++;
            }
        }
        //System.out.println(Arrays.toString(minS));
        answer = Integer.parseInt(new String(minS),2);
        //System.out.println(answer);
        return answer;
    }
}
