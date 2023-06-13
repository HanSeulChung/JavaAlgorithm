package com.lecture.practice.p1;
// Stirng의 replce 기능 구현 (단, String의 replace, indexOf, contains를 사용하지 않고 구현
//Hello Java, Nice to meet you! Java is fun!
import java.util.Scanner;
public class Practice3 {
    // 1. equals, substring 메소드 사용 - 내생각
//    public static void solution1(String inputstr, String findstr, String tostr){
//        String newstr ="";
//        String comparisonstr="";
//        boolean strstart = false;
//        boolean strfinish = false;
//        for(int i =0; i<inputstr.length(); i++) {
//
//            if (inputstr.charAt(i) == findstr.charAt(0)) {
//                comparisonstr = inputstr.substring(i, i+findstr.length());
//
//                if(comparisonstr.equals(findstr)){
//                    newstr+= tostr;
//                    i = i+findstr.length()-1;
//                    comparisonstr="";
//                }
//                else{
//                    newstr+=inputstr.charAt(i);
//                }
//            }
//            else{
//                newstr+=inputstr.charAt(i);
//            }
//        }
//        System.out.println(newstr);
//    }

    // 2. 완전 자체 구현 - 강의
    public static void solution2(char[] str, char[] find, char[] to){
        int idx =0;
        String replacestr ="";
        char[] replaceBucket = str.clone();

        do{
            idx = findIndex(replaceBucket, find);
            if(idx != -1){
                for(int i =0; i<idx; i++){
                    replacestr+=replaceBucket[i];
                }
                for(int i=0; i< to.length; i++){
                    replacestr+=to[i];
                }
                for(int i=idx+find.length; i< replaceBucket.length; i++){
                    replacestr+=replaceBucket[i];
                }
                replaceBucket = replacestr.toCharArray();
                replacestr="";
            }
        }while(idx!=-1);

        replacestr = new String(replaceBucket);
        System.out.println(replacestr);
    }

    public static int findIndex(char[] str, char[] find){
        int idx= -1;
        boolean isMatch = false;

        for(int i=0; i< str.length; i++){
            if(str[i]==find[0] && str.length - i>=find.length){
                isMatch=true;
                for(int j=1; j<find.length; j++){
                    if(str[i+j] != find[j]){
                        isMatch=false;
                        break;
                    }
                }
            }
            if(isMatch){
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args){
        String str ="0";
        String find = "0";
        String to = "0";
        System.out.print("문자열을 입력해 주세요.: ");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        System.out.print("찾을 문자을 입력해 주세요.: ");
        find = sc.nextLine();
        System.out.print("바꿀 문자을 입력해 주세요.: ");
        to = sc.nextLine();

        //solution1(str,find,to);

        char[] strEXArr = str.toCharArray();
        char[] findEXArr = find.toCharArray();
        char[] toEXArr = to.toCharArray();

        solution2(strEXArr,findEXArr,toEXArr);
    }


}
