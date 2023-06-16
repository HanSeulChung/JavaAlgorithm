package com.lecture.자바기초.chapter9.whatisEnum;


public class AddingEnumExample {
    public static void main(String[] args) {
        SoccerTeam[] soccerTeam = SoccerTeam.values();
        for (SoccerTeam position : soccerTeam) {
            System.out.println("Position : " + position.getNumber()
                    + " Name : " + position.getName());
        }
    }
}
