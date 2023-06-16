package com.lecture.자바기초.자바기초practice.p2;
// 편집기 구현

import java.util.ArrayList;
import java.util.Arrays;

public class Practice3 {
    public static void solution(String input, String cmd){
        StringBuffer sb = new StringBuffer(input);
        ArrayList<String> cmdArr = new ArrayList<>();

        for(String s: cmd.split(" ")){
            cmdArr.add(s);
        }

        int curSor = sb.length();
        int cmdIdx = 0;
        while(cmdIdx!=cmdArr.size()){
            String cur = cmdArr.get(cmdIdx);

            if(cur.equals("L")){
                curSor = Math.max(0, curSor-1);
            } else if(cur.equals("D")){
                curSor = Math.min(sb.length(),curSor+1);
            } else if(cur.equals("B")){
                if(curSor==0){
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor-1, curSor);
                curSor = Math.max(0,curSor -1);
            } else if(cur.equals("P")){
                String s = cmdArr.get(++cmdIdx);
                sb.insert(curSor,s);
                curSor +=1;
            }
            cmdIdx++;
        }
        String answer = sb.toString();
        System.out.println(answer);
    }
    public static void solution1(String firstString, String command){
        String[] strList = firstString.split("");
        ArrayList<String> commandList = new ArrayList<>(Arrays.asList(command.split(" ")));
        int hasP =0;
        for(int i =0; i< commandList.size(); i++){
            String strP = commandList.get(i);
            if(strP.equals("P")){
                commandList.remove(i);
                hasP++;
            }
        }

        ArrayList<String> newstrList = new ArrayList<>(Arrays.asList(strList));
        int idx = newstrList.size();
        for(String str: commandList){
            switch(str){
                case "L":{
                    if(idx!=0){
                        idx--;
                    }
                    break;
                }
                case "D":{
                    if(idx!=newstrList.size()){
                        idx++;
                    }
                    break;
                }
                case "B":{
                    if(idx!=0&& newstrList.size()!=0){
                        newstrList.remove(idx-1);
                        idx--;
                    }
                    break;
                }
                default:{
                    newstrList.add(idx,str);
                    idx++;
                }

            }
        }
        String answer = String.join("",newstrList);

        System.out.println(answer);
    }

    public static void main(String[] args){
            solution("aba","L B");
            solution("abcd","P x L P y");
            solution("abc","L L L P x L B P y");
            solution("a","B B L L D D P a P b P c");
            System.out.println();
            solution1("aba","L B");
            solution1("abcd","P x L P y");
            solution1("abc","L L L P x L B P y");
            solution1("a","B B L L D D P a P b P c");
    }
}
