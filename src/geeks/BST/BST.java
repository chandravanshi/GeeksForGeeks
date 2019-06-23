package geeks.BST;

import geeks.BST.Tree.Node;

public class BST {

  public static void main(String [] args) {
    Node node4 = new Node(4);
    Node node2 = new Node(node4, null, 2);
    Node node3 = new Node(3);
    Node node1 = new Node(node2, node3, 1);
    System.out.println(minDepth(node1));

  }

  private static int minDepth(Node root) {
    if(root == null) {
      return 0;
    }
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }

}
