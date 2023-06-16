package com.lecture.자바기초.chapter9.whatisEnum;

enum Vehicle {BUS, CAR, AIRPLANE, BIKE}
public class Enum {
    public static void main(String[] args){
        System.out.println(Vehicle.BUS.name());
        System.out.println(Vehicle.AIRPLANE.ordinal());
        System.out.println(Vehicle.CAR);
        System.out.println(Vehicle.BIKE.ordinal());
    }

}
