package com.lecture.선형자료구조.hashtable;
/**
 * Practice4 > 개방 주소법 (이중 해싱)
* @package : com.lecture.선형자료구조.hashtable
* @name : Practice4.java
* @date : 2023-06-19 오후 2:42
* @author : HSChung
* @version : 1.0.0
* @modifyed :
**/

class MyHashTable4 extends MyHashTable{
    int c;
    MyHashTable4(int size){
        super(size);
        this.c = getHashC(size);
    }

    public int getHashC(int size){
        int c = 0;

        if(size<=2){
            return size;
        }

        for (int i = size -1; i >2; i--) {
            boolean isPrime = true;
            for (int j = 2; j < i ; j++) {
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                c = i;
                break;
            }
        }
        return c;
    }
    public int getHash2(int key){
        int hash = 1 + key % this.c; // 여기서 c는 table 길이안에 있는 소수를 의미함
        return hash;
    }
    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if(this.elemCnt == this.table.length){
            System.out.println("Hash Table is full!");
            return ;
        } else if(this.table[idx]== null){
            this.table[idx] = data;
        } else{
            int newIdx = idx;
            int cnt = 1;
            while(true){
                newIdx = (newIdx + this.getHash2(newIdx)* cnt) % this.table.length;
                if(this.table[newIdx] == null){
                    break;
                }
                cnt++;
            }
            this.table[newIdx] =data;
        }
        this.elemCnt++;
    }
}
public class Practice4 {
    public static void main(String[] args) {
        MyHashTable4 ht = new MyHashTable4(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();


        ht.setValue(1, 100);
        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.printHashTable();
    }

}
