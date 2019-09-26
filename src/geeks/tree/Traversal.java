package geeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

  public static void main(String [] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);
    Node node8 = new Node(8);
    Node node9 = new Node(9);

    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.left = node6;
    node3.right = node7;
    node4.left = node8;
    node5.right = node9;

    //levelOrderTraversal(node1);
    //inorder(node1);
    //preorder(node1);
    postorder(node1);
  }

  private static void levelOrderTraversal(Node head) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(head);
    while(!queue.isEmpty()) {
      Node node = queue.poll();
      if(node.left != null) {
        queue.add(node.left);
      }
      if(node.right != null) {
        queue.add(node.right);
      }
      System.out.print(node.value + " ");
    }

  }

  private static void inorder(Node node, int n) {
    if(node == null) {
      return;
    }
    inorder(node.left, n);
    System.out.print(node.value + " ");
    inorder(node.right, n+1);
  }

  private static void preorder(Node node) {
    if(node == null) {
      return;
    }
    System.out.print(node.value + " ");
    preorder(node.left);
    preorder(node.right);
  }

  private static void postorder(Node node) {
     if(node == null) {
       return;
     }
     postorder(node.left);
     postorder(node.right);
     System.out.print(node.value + " ");
  }

}
