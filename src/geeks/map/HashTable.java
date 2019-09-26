package geeks.map;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K,V> {
  int defaultLength = 20;
  List<Node<Pair<K,V>>> hashArray = new ArrayList<>();
  public HashTable() {
  }

  public void put(K key, V value) {
    int index = key.hashCode() % defaultLength;
    if(hashArray.get(index) == null) {
      hashArray.add(index, new Node<Pair<K,V>>(new Pair<K,V>(key, value)));
    } else {
      Node node = hashArray.get(index);
      while(node.next != null) {
        node = node.next;
      }

      node.next = new Node<Pair<K,V>>(new Pair<>(key, value));
    }
  }

  public V get(K key) {
    int index = key.hashCode() % defaultLength;
    if(hashArray.get(index) != null) {
      Node<Pair<K, V>> node = hashArray.get(index);
      while(node != null) {
        if(node.value.key.equals(key)) {
          return node.value.value;
        }
      }
    }
    return null;
  }



}
