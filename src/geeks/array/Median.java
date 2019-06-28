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
    BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));
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
      while(node.value > input && node.previous != null) {
        node = node.previous;
      }
      Node newNode = new Node(input);
      if(node.previous == null && node.value > input) {
        newNode.next = node;
        node.previous = newNode;
      } else {
        newNode.next = node.next;
        newNode.previous = node;
        node.next = newNode;
        newNode.next.previous = newNode;
      }
      if(total % 2 == 0) {
        return medianNode;
      }
      return medianNode.previous;
    } else {
      Node node = medianNode;
      while(node.value < input && node.next != null) {
        node = node.next;
      }
      Node newNode = new Node(input);
      if(node.next == null && node.value < input) {
        newNode.previous = node;
        node.next = newNode;
      } else {
        newNode.next = node;
        newNode.previous = node.previous;
        node.previous = newNode;
        newNode.previous.next = newNode;
      }

      if(total % 2 == 0) {
        return medianNode.next;
      } else {
        return medianNode;
      }
    }

  }

}
