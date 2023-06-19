package com.lecture.선형자료구조.hashtable;
/**
 * Practice5 > 분리 연결법
* @package : com.lecture.선형자료구조.hashtable
* @name : Practice5.java
* @date : 2023-06-19 오후 3:06
* @author : HSChung
* @version : 1.0.0
* @modifyed :
**/

class Node{
    int key;
    int data;
    Node next;

    Node(){}
    Node(int key, int data, Node next) {
        this.key = key;
        this.data = data;
        this.next = next;
    }
}

class LinkedList{
    Node head;
    LinkedList(){}
    LinkedList(Node node){
        this.head = node;
    }
    // 연결리스트 비어있는지 확인
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }
    // 연결리스트 맨 뒤에 데이터 추가
    public void addData(int key, int data){
        if(this.head == null){
            this.head = new Node(key, data, null);
        } else{
            Node cur = this.head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(key, data,null);
        }
    }

    public void removeData(int data){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node cur = this.head;
        Node prev = cur;

        while(cur.next !=null){
            if(cur.key == data){
                if(cur == this.head){
                    this.head = cur.next;
                }else{
                    prev.next = cur.next;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }
    //연결리스트에서 데이터 찾기
    public Integer findData(int data){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return null;
        }
        Node cur = this.head;
        while(cur!=null){
            if(cur.key==data){
                //System.out.println("Data exist!");
                return cur.data;
            }
            cur = cur.next;
        }
        System.out.println("Data not found");
        return null;
    }
    public void showData(){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node cur = this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur= cur.next;
        }
        System.out.println();
    }
}

class MyHashTable5{
    LinkedList[] table;

    MyHashTable5(int size){
        this.table = new LinkedList[size];
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new LinkedList(null);
        }
    }
    public int getHash(int key){
        return key % this.table.length;
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        this.table[idx].addData(key,data);
    }

    public int getValue(int key){
        int idx = this.getHash(key);
        int data = this.table[idx].findData(key);
        return data;
    }

    public void removeValue(int key){
        int idx = this.getHash(key);

        this.table[idx].removeData(key);
    }
    
    public void printHashTable(){
        for (int i = 0; i < this.table.length; i++) {
            System.out.print(i +": ");
            this.table[i].showData();
        }
    }
}
public class Practice5 {
    public static void main(String[] args) {
        MyHashTable5 ht = new MyHashTable5(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();
        ht.setValue(12, 11);
        ht.setValue(23, 12);
        ht.setValue(34, 13);

        ht.setValue(13, 21);
        ht.setValue(24, 22);
        ht.setValue(35, 23);

        ht.setValue(5, 1);
        ht.setValue(16, 2);
        ht.setValue(27, 3);
        ht.printHashTable();

        System.out.println("== key 값으로 해당 데이터 가져오기 ==");
        System.out.println(ht.getValue(1));
        System.out.println(ht.getValue(12));

        System.out.println("== 데이터 삭제 ==");
        ht.removeValue(1);
        ht.removeValue(5);
        ht.removeValue(16);
        ht.printHashTable();
    }
}
