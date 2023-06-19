package com.lecture.선형자료구조.hashtable;
/**
* @package : com.lecture.선형자료구조.hashtable
* @name : Main.java
* @date : 2023-06-19 오후 2:17
* @author : HSChung
* @version : 1.0.0
* @modifyed :
**/
import java.util.Hashtable;
import java.util.Map;

public class Main {
    public static int getHas(int key) {
        return key % 5;
    }
    public static void main(String[] args) {
        Hashtable<String, Integer> ht = new Hashtable();

        ht.put("key1", 10);
        ht.put("key2", 20);
        ht.put("key3", 30);
        ht.put("key3", 50);

        for(Map.Entry<String, Integer> item: ht.entrySet()){
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        Hashtable<Integer, Integer> ht2 = new Hashtable();
        ht2.put(getHas(1),10);
        ht2.put(getHas(2),20);
        ht2.put(getHas(3),30);
        ht2.put(getHas(4),40);
        ht2.put(getHas(5),50);

        System.out.println("== 충돌 전 ==");
        for(Map.Entry<Integer, Integer> item: ht2.entrySet()){
            System.out.println(item.getKey() + " - " + item.getValue());
        }
        ht2.put(getHas(6),60);
        System.out.println("== 충돌 후 ==");
        for(Map.Entry<Integer, Integer> item: ht2.entrySet()){
            System.out.println(item.getKey() + " - " + item.getValue());
        }
    }


}
