package com.lecture.자바기초.chapter10.lambda;

interface LambdaTest {
    int addOne(int i);
}

public class LambdaExample {
    public static void main(String[] args){
        LambdaTest test = i -> {return ++i;};
        System.out.println(test.addOne(1));
    }
}
