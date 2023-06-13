package com.lecture.chapter9.whatisGenerics;

import java.util.List;
import java.util.ArrayList;

public class practice {

    public static void main(String[] args){
        List<Integer> integers = new ArrayList<Integer>();
        // 이거 두개 차이가 뭐지???
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        double answer = sumMethod(integerList);
        System.out.println(answer);
        ArrayList<Float> floatList = new ArrayList<Float>();
        floatList.add(1.1f);
        floatList.add(2.1f);
        answer = sumMethod(floatList);
        System.out.println(answer);

    }

    public static double sumMethod(ArrayList<? extends Number> numbers){
        double answer = 0.0;
        for(Number number : numbers){
            answer += number.doubleValue();
        }
        return answer;
    }

}
