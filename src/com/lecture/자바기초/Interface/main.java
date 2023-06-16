package com.lecture.자바기초.Interface;
// Java 프로그래밍 - 인터페이스

interface School{
    public static final int MAX_CLASS =20;
    public static final int MAX_PERSON_PER_CLASS =40;
    public abstract void printSchool();
}

class Student implements School{
    public void printSchool(){
        System.out.println("00 University");
    };
}

class Person{
    public String name;
    public void printName(){
        System.out.println("name = " + name);
    }
}

class Student2 extends Person implements School{
    Student2(String name){
        super.name = name;
    }
    public void printSchool() {
        System.out.println("11 University");
    }
}

public class main {
    public static void main(String[] args){
        // 1. 인터페이스 기본 사용
        System.out.println("== 기본 인터페이스==");
        Student s1 = new Student();
        s1.printSchool();
        System.out.println(s1.MAX_CLASS);
        System.out.println(s1.MAX_PERSON_PER_CLASS);

        // 2. 다중 상속처럼 사용하기
        System.out.println("== Like 다중 상속==");
        Student2 s2 = new Student2("A");
        s2.printSchool();
        s2.printName();
    }
}
