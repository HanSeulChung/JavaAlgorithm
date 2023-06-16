package com.lecture.선형자료구조.linkedlist;
class Node{
    int data;
    Node next;

    Node(){}
    Node(int data, Node next) {
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
    public void addData(int data){
        if(this.head == null){
            this.head = new Node(data, null);
        } else{
            Node cur = this.head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data,null);
        }
    }

    public void removeData(){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node cur = this.head;
        Node prev = cur;

        while(cur.next !=null){
            prev = cur;
            cur = cur.next;
        }
        if(cur==this.head){
            this.head = null;
        } else{
            prev.next = null;
        }
    }
    //연결리스트에서 데이터 찾기
    public void findData(int data){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node cur = this.head;
        while(cur!=null){
            if(cur.data==data){
                System.out.println("Data exist!");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not found");
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

public class Main {

    public static void main(String[] args) {
        LinkedList myList = new LinkedList(new Node(1,null));
        myList.showData();

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();

        myList.findData(3);
        myList.findData(100);

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData();

    }
}
