package geeks.BST.Tree;

public class Node {
  public int value;
  public Node left;
  public Node right;

  public Node(int value) {
    this.value = value;
  }

  public Node (Node left, Node right) {
    this.left = left;
    this.right = right;
  }

  public Node(Node left, Node right, int value) {
    this(left, right);
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}
