package com.lecture.chapter10.lambda;

interface LambdaTest {
    int addOne(int i);
}

public class LambdaExample {
    public static void main(String[] args){
        LambdaTest test = i -> ++i;
        System.out.println(test.addOne(1));
    }
}
