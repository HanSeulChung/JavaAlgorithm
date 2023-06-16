package com.lecture.자바기초.chapter9.whatisEnum;

public enum SoccerTeam {
    GK(1,"A"), LB(2,"B"), RB(3,"C"),
    LCB(4,"D"), RCB(5,"E"), CM(6,"F");

    private final int number;
    private final String name;

    SoccerTeam(int number, String name){
        this.number = number;
        this.name = name;
    }

    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }

}
