package com.lecture.inheritance;

class Car{
    Car(){}
    public void horn(){
        System.out.println("빵빵!");
    }
}

class FireTruck extends Car{
    FireTruck(){
        super.horn();
    }
    public void horn(){
        System.out.println("위이잉!");
    }
}

class Ambulance extends Car{
    Ambulance(){
        super.horn();
    }
    public void horn(){
        System.out.println("삐뽀삐뽀!");
    }
}

public class practice {
    public static void main(String[] args){
        FireTruck truck = new FireTruck();
        truck.horn();

        Ambulance amb = new Ambulance();
        amb.horn();
    }
}
