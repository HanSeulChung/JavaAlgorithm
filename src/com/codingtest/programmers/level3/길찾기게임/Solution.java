package com.codingtest.programmers.level3.길찾기게임;

import java.util.*;

public class Solution {
  static int[][] answer;
  static int idx;

  public int[][] solution(int[][] nodeinfo) {
    answer = new int[2][nodeinfo.length];
    Node[] nodes = new Node[nodeinfo.length];
    idx = 0;
    for (int[] node : nodeinfo) {
      nodes[idx] = new Node(node[0], node[1], idx + 1);
      idx++;
    }

    Arrays.sort(nodes, (o1, o2) -> {
      if (o1.y == o2.y) {
        return o1.x - o2.x;
      }
      return o2.y - o1.y;
    });

    Node parent = nodes[0];
    for (int i = 1; i < nodes.length; i++) {
      insertNode(parent, nodes[i]);
    }

    idx = 0;
    prefix(parent);
    idx = 0;
    postfix(parent);
    return answer;
  }

  private void insertNode(Node parent, Node children) {
    if (parent.x > children.x) {
      if (parent.left == null) {
        parent.left = children;
      } else {
        insertNode(parent.left, children);
      }
    } else {
      if (parent.right == null) {
        parent.right = children;
      } else {
        insertNode(parent.right, children);
      }
    }
  }

  private void prefix(Node parent) {
    if (parent != null) {
      answer[0][idx++] = parent.value;
      prefix(parent.left);
      prefix(parent.right);
    }

  }

  private void postfix(Node parent) {
    if (parent != null) {
      postfix(parent.left);
      postfix(parent.right);
      answer[1][idx++] = parent.value;
    }
  }
}

class Node {
  int x;
  int y;
  int value;
  Node left;
  Node right;

  public Node (int x, int y, int value) {
    this.x = x;
    this.y = y;
    this.value = value;
    left = null;
    right = null;
  }

  @Override
  public String toString(){
    return String.format("[%d, %d]", this.x, this.y);
  }
}
