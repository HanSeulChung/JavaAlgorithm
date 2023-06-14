package com.study;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayStudy {
    public static void main(String[] args) {
        // Array
        int[] intArr1 = {};                 //[]
        int[] intArr2 = new int[4];         //[0, 0, 0, 0]
        int[] intArr3 = {1, 1, 4, 5, 6};    //[1, 1, 4, 5, 6] new int[]{1, 1, 4, 5, 6} 로도 사용 가능
        int[] intArr4;          //선언만 하고
        intArr4 = new int[2];   //생성 나중에 해도됨

        int[] intArr5 = new int [1];
        int[] intArr6 = new int[0];

        //int arr 출력은 for-each 방법도 있으나 간편하게 해당 출력으로만 대체함
        System.out.println("=== Array: int[] ===");
        System.out.println("intArr1: "+ Arrays.toString(intArr1));
        System.out.println("intArr1 길이: "+intArr1.length);
        System.out.println("intArr2: "+ Arrays.toString(intArr2));
        System.out.println("intArr3: "+ Arrays.toString(intArr3));
        System.out.println("intArr4: "+ Arrays.toString(intArr4));
        System.out.println("intArr5: "+ Arrays.toString(intArr5));
        System.out.println("intArr6: "+ Arrays.toString(intArr6));
        System.out.println("intArr6 길이: "+intArr6.length);

//        intArr6[0] = 10; //크기가 없는 배열에는 값을 넣을 수 없다. 인덱스 오류가 날 것이다.
//        System.out.println(Arrays.toString(intArr6));

        intArr5[0] = 10;
        System.out.println("intArr5[0] =10 한 후 intArr5: " + Arrays.toString(intArr5));
//        intArr5[1] = 20; // 크기가 1인 배열에는 인덱스가 1부터는 존재하지 않음. 마찬가지로 넣을 수 없음. 인덱스 오류가 날 것이다.
//        System.out.println(Arrays.toString(intArr5));

        System.out.println();
        System.out.println("=== Array: String[] ===");
        String[] stringArr1 = new String[5];
        System.out.println("stringArr1: "+ Arrays.toString(stringArr1));
        stringArr1[0] = "Hi";
        String[] stringArr2=new String[]{"Kim","Park","Yi"}; // new String[] 생략가능

        System.out.println("stringArr1[0] = \"Hi\" 한 후 stringArr1: "+ Arrays.toString(stringArr1));
        System.out.println("stringArr2: "+ Arrays.toString(stringArr2));

        System.out.println();
        System.out.println("=== Array: char[]===");
        char[] charArr1 ={};
        char[] charArr2 = {'a', 'b', 'c', 'd', 'e'};

        System.out.print("charArr1: ");
        System.out.println(charArr1);
        System.out.print("charArr2: ");
        System.out.println(charArr2);               //char array만 println할 경우 println의 고유적인 기능
        System.out.println("charArr2: "+ charArr2); // 다른것들이 추가되면 x
        System.out.println();


        System.out.println("=== Array: boolean[]===");
        boolean[] booleanArr1 ={};
        boolean[] booleanArr2 = new boolean[2];
        System.out.println("booleanArr1: "+ Arrays.toString(booleanArr1));
        System.out.println("booleanArr2: "+ Arrays.toString(booleanArr2));
        System.out.println();
        //Collection 프레임 워크의 일부인 ArrayList
        ArrayList<Integer> IntegerArrayList = new ArrayList<>();
        System.out.println("=== ArrayList : ArrayList<Integer> ===");
        System.out.println("ArrayList is not equal Array, is List");
        System.out.println("IntegerArrayList: "+ IntegerArrayList);
        IntegerArrayList.add(3);
        System.out.println("IntegerArrayList: "+ IntegerArrayList);
        IntegerArrayList.add(5);
        IntegerArrayList.add(3);
        System.out.println("IntegerArrayList: "+ IntegerArrayList);
    }
}
