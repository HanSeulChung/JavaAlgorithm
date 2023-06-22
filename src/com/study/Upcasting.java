package com.study;
class Parent {
    String name;
    int age;
}

class Child extends Parent {
    /*
    String name;
    int age;
    */
    int number;
}
public class Upcasting {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();
        p.name = "hanseul";
        p.age = 100;
        c.number = 7;

//        p.number = 4; // 자식클래스에만 있는 변수는 부모클래스에서 사용 못함
//        c.age = 13; // 자식클래스는 부모클래스에 있는 변수(제한자에 따라 다름) 사용 가능
//
//        Parent pc = new Child();
//        pc.number =10;
    }
}
