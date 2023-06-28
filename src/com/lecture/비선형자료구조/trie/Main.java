package com.lecture.비선형자료구조.trie;

import java.util.HashMap;

class Node{
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node(){
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie{
    Node root;
    public Trie(){
        this.root = new Node();
    }

    public void insert(String str){
        Node cur = this.root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node()); // 조건문 없이 메서드 이용해서 값이 없으면 추가, 있으면 추가 안함
            cur = cur.child.get(c);

            if(i == str.length() -1){
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str){
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(cur.child.containsKey(c)){
                cur = cur.child.get(c);
            } else {
                return false;
            }

            if(i== str.length() -1){
                if(!cur.isTerminal){ // 입력 str을 다 받는다 해도 apple이 trie안에 있는 경우 app을 찾을 때 app이 들어있다고 생각하면 안된다. isTerminal이 true 인지 false인지?
                    return false;
                }
            }
        }
        return true;
    }
    public void delete(String str){
        boolean ret = this.delete(this.root, str, 0);
        if(ret){
            System.out.println(str + " 삭제 완료");
        } else {
            System.out.println(str + " 단어가 없습니다.");
        }
    }

    public boolean delete(Node node, String str, int idx){ // 재귀적으로 호출해서 삭제를 해야하는지 안해야하는지 확인하는 메서드
        char c = str.charAt(idx);

        if(!node.child.containsKey(c)){
            return false;
        }

        Node cur = node.child.get(c);
        idx ++;

        if(idx == str.length()){ // 이미증가시키고 이 if문을 들어오기 때문에 length() -1 이 아니라 그냥 length()임 만약 length()-1이면 마지막 문자열은 체킹이 안됨
            if(!cur.isTerminal){
                return false;
            }

            cur.isTerminal = false;

            if(cur.child.isEmpty()){ // 아래에 아무 문자열이 없으면 지움
                node.child.remove(c);
            }
        } else { // 지워야할 문자를 끝까지 찾기 전
            if(!this.delete(cur, str,idx)){ // 재귀적 호출
                return false;
            }
            if(!cur.isTerminal && cur.child.isEmpty()){
                node.child.remove(c);
            }
        }
        return true;
    }

}
public class Main {
    public static void main(String[] args) {
        Trie trei = new Trie();
        trei.insert("apple");
        trei.insert("april");
        //trei.insert("app");
        trei.insert("ace");
        trei.insert("bear");
        trei.insert("best");
        System.out.println(trei.search("apple"));
        System.out.println(trei.search("april"));
        System.out.println(trei.search("app"));
        System.out.println(trei.search("ace"));
        System.out.println(trei.search("bear"));
        System.out.println(trei.search("best"));

        System.out.println();

    }
}
