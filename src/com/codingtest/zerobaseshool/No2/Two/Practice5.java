package com.codingtest.zerobaseshool.No2.Two;

import java.util.ArrayList;

public class Practice5 {
    public static int solution(int N, int K) {
        int answer = 0;

        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i =1; i<=N; i++){
            arraylist.add(i);
        }
        int idx = 0;
        while(arraylist.size() !=2){
            int tmp =  idx + K-1;
            if(tmp<=arraylist.size()){
                idx = tmp;
                arraylist.remove(idx);
            } else{
                idx = tmp - arraylist.size();
                arraylist.remove(idx);
            }
        }
        System.out.println(idx);
        if(idx%2==0){
            arraylist.remove(0);
        } else {
            arraylist.remove(1);
        }
        System.out.println(arraylist.get(0));
        return arraylist.get(0).intValue();
    }

    public static void main(String[] args) {
        solution(7, 3);
    }
}
