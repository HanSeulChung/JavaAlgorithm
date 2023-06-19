package com.lecture.선형자료구조.hashtable;
/**
 * Practice3 > 해시 충돌 해결 - 개방 주소법(제곱 탐사법)
* @package : com.lecture.선형자료구조.hashtable
* @name : Practice3.java
* @date : 2023-06-19 오후 2:37
* @author : HSChung
* @version : 1.0.0
* @modifyed :
**/
class MyHashTable3 extends MyHashTable{
    MyHashTable3(int size){
        super(size);
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if(this.elemCnt== this.table.length){
            System.out.println("Hash Table is full!");
            return ;
        }else if(this.table[idx]==null){
            this.table[idx]=data;
        }else{
            int newIdx = idx;
            int cnt = 0; // 충돌 세기 위한 값
            while(true){
                newIdx = (newIdx + (int)Math.pow(2, cnt)) % this.table.length;
                if(this.table[newIdx]==null){
                    break;
                }
                cnt++;
            }
            this.table[newIdx]=data;
        }
        this.elemCnt++;
    }
}
public class Practice3 {
    public static void main(String[] args) {
        // Test code
        MyHashTable3 ht = new MyHashTable3(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(4, 40);
        ht.printHashTable();

        ht.setValue(1, 100);
        ht.printHashTable();

        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.setValue(1, 400);
        ht.printHashTable();
    }
}
