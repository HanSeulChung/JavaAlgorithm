package com.lecture.선형자료구조.linkedlist;

class CircularLinkedList{
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node){
        this.head = node;
        this.tail = node;
        node.next = this.head;
        node.prev = this.head;
    }


}
public class Practice3 {
    public static void main(String[] args) {

    }
}
