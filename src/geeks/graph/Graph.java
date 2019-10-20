package geeks.graph;

import java.util.LinkedList;

public class Graph {
  int                    size;
  LinkedList<Integer> [] adj;

  public Graph(int size) {
    this.size = size;
    adj = new LinkedList[size];
    for(int i =0; i< adj.length; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
  }

}
