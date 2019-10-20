package geeks.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Traversal {

  public static Graph graph;

 public static void main(String [] args) throws IOException {
   //graph = createGraph();
   //bfs(0);
   //dfs(0);
 /*  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
   String [] a = r.readLine().split(" ");
   System.out.println(a);*/
   Scanner in = new Scanner(System.in);
   String ar = in.next();
   System.out.println(ar);


 }

  public static void bfs(int v) {
   boolean [] visited = new boolean [graph.size];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    while(!queue.isEmpty()) {
      int element = queue.poll();
      visited[element] = true;
      System.out.println(element);
      Iterator<Integer> iterator = graph.adj[element].iterator();
      while(iterator.hasNext()) {
        int next = iterator.next();
        if(!visited[next]) {
          queue.add(next);
          visited[next] = true;
        }
      }
    }
  }

  public static void dfs(int v) {
   boolean [] visited = new boolean[graph.size];
   dfsUtil(v, visited);
  }

  public static void dfsUtil(int v, boolean [] visited) {
    LinkedList<Integer> children = graph.adj[v];
    Iterator<Integer> iterator = children.iterator();
    visited[v] = true;
    System.out.print(v + " ");
    while(iterator.hasNext()) {
      int next = iterator.next();
      if(!visited[next])
        dfsUtil(next, visited);
    }
  }


  public static Graph createGraph() {
    Graph graph = new Graph(5);
    graph.addEdge(0,4);
    graph.addEdge(4,3);
    graph.addEdge(3,2);
    graph.addEdge(2,1);
    graph.addEdge(4,2);
    return graph;
  }



}
