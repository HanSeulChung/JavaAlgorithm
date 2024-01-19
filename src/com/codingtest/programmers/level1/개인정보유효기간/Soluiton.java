package com.codingtest.programmers.level1.개인정보유효기간;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Soluiton {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayLocalDate = LocalDate.parse(today, formatter);

        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> validMonthMap = new HashMap<>();
        for (String term : terms) {
            String[] validMonth = term.split(" ");
            validMonthMap.put(validMonth[0], Integer.parseInt(validMonth[1]));
        }

        int idx = 1;
        for (String privacy : privacies) {
            String[] dateAndTerm = privacy.split(" ");
            LocalDate checkLocalDate = LocalDate.parse(dateAndTerm[0], formatter);
            if (checkLocalDate.plusMonths(validMonthMap.get(dateAndTerm[1])).isBefore(todayLocalDate) || checkLocalDate.plusMonths(validMonthMap.get(dateAndTerm[1])).isEqual(todayLocalDate)) {
                answer.add(idx);
            }
            idx++;
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args){
        String today= "2022.05.19";
        String test = "2022.05.27";

    }
}
