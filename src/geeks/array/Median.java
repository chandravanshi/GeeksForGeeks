package geeks.array;

import geeks.LinkedList.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Median {

  public static void main(String [] args) throws IOException {
    findMedian();

  }

  private static void findMedian() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int total = 0;
    int first = Integer.parseInt(reader.readLine());
    Node medianNode = new Node(first);
    System.out.println(medianNode.value);
    total++;
    while(true) {
      int input = Integer.parseInt(reader.readLine());
      medianNode = insert(medianNode, input, total);
      total++;
      if(total % 2 == 0) {
        System.out.println((medianNode.value + medianNode.next.value)/2);
      } else {
        System.out.println(medianNode.value);
      }
    }
  }

  private static Node insert(Node medianNode, int input, int total) {
    if(input < medianNode.value) {
      Node node = medianNode;
      Node previousNode = node.previous;
      while(node != null && node.value > input) {
        node = node.previous;
      }
      Node newNode = new Node(input);
      newNode.next = node.next;
      node.next = newNode;
      newNode.previous = node;
      if(total % 2 == 0) {
        return medianNode;
      } else {
        return medianNode.previous;
      }
    } else {
      Node node = medianNode;
      while(node.next.value < input && node.next != null) {
        node = node.next;
      }
      Node newNode = new Node(input);
      newNode.previous = node;
      newNode.next = node.next;
      node.next = newNode;

      if(total % 2 == 0) {
        return medianNode.next;
      } else {
        return medianNode;
      }
    }
  }

}
