package geeks.tree;

public class Sibling {

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
      Node node10 = new Node(10);
      node10.parent = node7;
      node7.right = node10;

      node1.left = node2;
      node1.right = node3;
      node2.left = node4;
      node2.right = node5;
      node2.parent = node1;
      node3.left = node6;
      node3.right = node7;
      node3.parent= node1;
      node4.left = node8;
      node5.right = node9;
      node4.parent = node2;
      node5.parent = node2;
      node6.parent = node3;
      node7.parent= node3;
      node8.parent = node4;
      node9.parent = node5;
Node node = findRightSibling(node9);
    System.out.println(node == null ? "no node found" : node.value);

      //levelOrderTraversal(node1);
      //inorder(node1);
      //preorder(node1);
  }
  public static AugmentedNode findRightNode(Node node, int height) {
    if(node == null) {
      return null;
    }
    Node previous = node;
    node = node.parent;
    height++;
    while(node != null) {
      if(node.right != null && node.right != previous) {
        height --;
        return new AugmentedNode(node.right, height);
      }
      previous = node;
      node = node.parent;
      height ++;
    }

    return null;
  }

  private static Node traverseTree(Node node, int height) {
    if(node == null) {
      return null;
    }
    if(height == 0) {
      return node;
    }
    Node returnNode = traverseTree(node.left, height-1);
    if(returnNode == null) {
      returnNode = traverseTree(node.right, height-1);
    }


    return returnNode;
  }

  public static Node findRightSibling(Node node) {
    AugmentedNode rightNode = findRightNode(node, 0);
    while(rightNode != null) {
      Node sibling = traverseTree(rightNode.node, rightNode.height);
      if(sibling == null) {
        rightNode  = findRightNode((rightNode.node.parent), rightNode.height + 2);
      } else {
        return sibling;
      }
    }
    return null;
  }



  private static class AugmentedNode {
    int height;
    Node node;

    public AugmentedNode(Node node, int height) {
      this.node = node;
      this.height = height;
    }
  }

}
