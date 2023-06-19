package com.miniProject;
import java.util.Scanner;
import java.time.LocalDate;

public class miniProject05 {
    public static void main(String[] args) {
        int year=0;
        int month=0;
        System.out.println("[달력 출력 프로그램]");
        Scanner sc = new Scanner(System.in);
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        year=sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        month=sc.nextInt();
        if(month<1 || month>13){
            System.out.println("해당 월은 올바르지 않습니다. 다시 입력해주세요.");
        }
        else{
            String targetMonth = String.format("%d-%02d-01",year,month);
            LocalDate targetLocalDate = LocalDate.parse(targetMonth);
            int finalDay = targetLocalDate.lengthOfMonth();
            System.out.println();
            System.out.println();
            System.out.println(String.format("[%d년 %02d월]", year, month));
            int startWeekday=  targetLocalDate.getDayOfWeek().getValue();
            System.out.println("일\t월\t화\t수\t목\t금\t토\t");

            for(int startplace=1; startplace<=startWeekday%7; startplace++ ){
                System.out.print("\t");
            }
            for(int i=1; i<=finalDay; i++){
                System.out.printf("%02d\t",i);
                startWeekday++;
                if((startWeekday)%7==0){
                    System.out.println();
                }
            }
        }

    }
}
