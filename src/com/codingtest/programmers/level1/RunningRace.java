package com.codingtest.programmers.level1;
// 보통 ArrayList가 메모리를 많이 잡아먹는 것 같다. 편리하긴 하나 array로 풀이하거나 무언가 찾을 땐 HashMap을 이용하도록 하자.
import java.util.*;

public class RunningRace {
    public static String[] solution(String[] players, String[] callings){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i< players.length; i++){
            map.put(players[i], i);
        }

        for (int i =0; i<callings.length; i++){
            int currentIdx = map.get(callings[i]);
            if(currentIdx > 0){
                String tmp = players[currentIdx];
                players[currentIdx] = players[currentIdx -1];
                players[currentIdx-1] = tmp;

                map.put(players[currentIdx-1], currentIdx -1);
                map.put(players[currentIdx], currentIdx);
            }
        }

        return players;
    }
//    public static ArrayList<String> solution(String[] players, String[] callings) {
//        ArrayList<String> answer = new ArrayList<>();
//
//        int idx = 0;
//
//        HashMap<String, Integer> map = new HashMap<>();
//        for(int i= 0; i< callings.length; i++){
//            int num= 1;
//            if(map.containsKey(callings[i])){
//                num++;
//                map.put(callings[i],num);
//            }
//            else{
//                map.put(callings[i],num);
//            }
//        }
//
//        Iterator<Map.Entry<String, Integer>> entry = map.entrySet().iterator();
//        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//
//        for(int i =0; i< players.length; i++){
//            for(Map.Entry<String, Integer> element : entrySet){
//                if(element.getKey().equals(players[i])){
//                    answer.add(i-map.get(players[i]), players[i]);
//                }
//            }
//            answer.add(players[i]);
//        }
//        int slicenumber = answer.size() - map.size();
//        answer = new ArrayList<>(answer.subList(0, slicenumber));
//
//        return answer;
//    }
//    public static String[] solution(String[] players, String[] callings) {
//        //시간초과 방법 ..
//        String[] answer = {};
//        int idx = 0;
//
//        answer= players.clone();
//        System.out.println(answer);
//        for(int i=0; i< callings.length; i++){
//
//            System.out.println(Arrays.asList(answer).indexOf(callings[i]));
//            idx = Arrays.asList(answer).indexOf(callings[i]);
//            String changestr = answer[idx-1];
//
//            answer[idx-1] = answer[idx];
//            answer[idx] = changestr;
//        }
//
//        return answer;
//    }

    public static void main(String[] args){
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        //String[] answer = solution(players,callings);
        //System.out.println(Arrays.asList(answer));

        String[] answer = solution(players, callings);
        System.out.println(answer);
    }
}
