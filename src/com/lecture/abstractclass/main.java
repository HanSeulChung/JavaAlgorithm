package com.lecture.abstractclass;
// Java 프로그래밍 - 추상 클래스

abstract class Person{
    abstract void printInfo();
}

class Student extends Person{
    public void printInfo(){
        System.out.println("Student.printInfo");
    }
}

public class main {
    public static void main(String[] args){
        Student s1= new Student();
        s1.printInfo();

        Person p2 = new Person() {
            @Override
            void printInfo() {
                System.out.println("main.printInfo");
            }
        };
        p2.printInfo(); // 이렇게 위에 넣은걸 익명 클래스라고한다..!
    }
}
