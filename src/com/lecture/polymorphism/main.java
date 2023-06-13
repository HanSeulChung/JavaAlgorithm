package com.lecture.polymorphism;
// Java 프로그래밍 - 다형성
class Person{
    public void print(){
        System.out.println("Person.print");
    }
}

class Student extends Person{
    public void print() {
        System.out.println("Student.print");
    }
    public void print2() {
        System.out.println("Student.print2");
    }
}

class CollegeStudent extends Person{
    public void print() {
        System.out.println("CollegeStudent.print");
    }
}


public class main {
    public static void main(String[] args){

        // 1. 다형성
        System.out.println("== 다형성 ==");
        Person p1 = new Person();
        Student s1 = new Student();

        Person p2 = new Student();

        p1.print();
        s1.print();
        s1.print2();
        p2.print();
        //p2.print2(); -> 부모가 갖고있는 메소드까지만 접근 가능함, 자식이 따로 갖고있는 메소드는 접근 불가

        Person p3 = new CollegeStudent();
        p3.print();

        // 2. 타입변환
        System.out.println("== 타입 변환==");
        Person pp1 = null;
        Student ss1 = null;

        Person pp2 = new Person();
        Student ss2 = new Student();
        Person pp3 = new Student(); // Student가 업캐스팅되었다 라고도 말함

        pp1 = pp2;
        pp1 = ss2;
        ss1 = ss2;
        //ss1 = pp2; // 거꾸로는 안된다고했었음
        // ss1 = pp3;
        ss1 = (Student)pp3; // 업캐스팅 된것을 원래 자신의 타입으로 타입변환으로 내려주면 가능함 -> 다운캐스팅


        // 3. instanceof // 상속받을 경우 부모의 instance인것도 true가 나옴
        System.out.println("== instance of==");
        System.out.println(p1 instanceof Person);
        System.out.println(p1 instanceof Student);

        System.out.println(s1 instanceof Person);
        System.out.println(s1 instanceof Student);

        System.out.println(p2 instanceof Person);
        System.out.println(p2 instanceof Student);
    }
}
