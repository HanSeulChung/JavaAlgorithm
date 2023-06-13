package com.codingtest.programmers.level1;
import java.util.HashMap;

public class YearningScore {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int photosize = photo.length;

        int[] answer = new int[photosize];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }
        int answersize =0;
        for(String[] strrow: photo){
            int value = 0;
            for(String strcol: strrow){
                if(map.containsKey(strcol)){
                    value += (int)map.get(strcol);
                }
            }
            answer[answersize++]= value;
        }

        return answer;
    }

    public static void main(String[] args){
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] answer = solution(name, yearning, photo);
        System.out.println(answer);
    }
}
