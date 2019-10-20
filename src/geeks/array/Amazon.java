package geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amazon {

  public static void main(String [] args) {
     /* List<String> s = new ArrayList<>();
      s.add("asd qw we");
      s.add("aed qw we");
      List<String> sw = prioritizedOrders(2, s);
      for(String q : sw) {
        System.out.println(q);
      }*/

     List<Integer> list1 = Arrays.asList(1,0,1);
    List<Integer> list2 = Arrays.asList(1,0,0);
    List<Integer> list3 = Arrays.asList(1,9,1);
    List<List<Integer>> list = new ArrayList<>();
    list.add(list1);
    list.add(list2);
    list.add(list3);

    System.out.println(minimumDistance(3,3, list));
  }

  public static List<String> prioritizedOrders(int numOrders, List<String> orderList)
  {
    List<String> nonPrime = new ArrayList<>();
    List<String> prime = new ArrayList<>();
    Map<String, String> primeMap = new HashMap<>();
    for(String s : orderList) {
      String [] array = s.split(" ");
      if(checkIfNumber(array[1])) {
          nonPrime.add(s);
      } else {
        int index = s.indexOf(" ");
        String key = s.substring(index);
        primeMap.put(key, s);
        prime.add(key);

      }
    }
    Collections.sort(prime);
    List<String> result =  new ArrayList<>();
    for(int j=0; j<prime.size(); j++) {
      result.add(primeMap.get(prime.get(j)));
    }
    for(String s: nonPrime) {
      result.add(s);
    }
    return result;
  }


  private static boolean checkIfNumber(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch(NumberFormatException ex) {
      return false;
    }
  }


  static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
  {

    boolean [][] visited = new boolean[area.size()][area.get(0).size()];
    return minOrder(area, 0, 0, 0, visited);
  }

  static private int minOrder(List<List<Integer>> area, int i, int j, int distance, boolean[][] visited) {
    if(area.get(i).get(j) == 9) {
      return distance;
    }
    int first= Integer.MAX_VALUE;
    int second= Integer.MAX_VALUE;
    int third= Integer.MAX_VALUE;
    int fourth= Integer.MAX_VALUE;
    if(i+1 < area.size() && area.get(i+1).get(j) == 1 && !visited[i+1][j]) {
      visited[i+1][j] =  true;
      first = minOrder(area, i+1, j, distance +1, visited);
    }
    if(j+1 < area.get(0).size() && area.get(i).get(j+1) == 1 && !visited[i][j+1]) {
      visited[i][j+1] =  true;
      second = minOrder(area,i,j+1, distance+1,visited);
    }
    if(i-1>= 0 && area.get(i-1).get(j) == 1 && !visited[i-1][j]) {
      visited[i-1][j] =  true;
      third = minOrder(area,i-1,j, distance+1, visited);
    }
    if(j-1 >=0 && area.get(i).get(j-1) == 1 && !visited[i][j-1]) {
      visited[i][j-1] =  true;
      fourth = minOrder(area,i,j-1, distance+1, visited);
    }

    return findMin(first, second,third,fourth);

  }

  private static int findMin(int first, int second, int third, int fourth) {
    int val = Integer.MAX_VALUE;

    int val1 = Integer.min(first, second);
    if(val1 < val) {
      val = val1;
    }

    int val2 = Integer.min(third, fourth);
    if(val2 < val) {
      val = val2;
    }

    return val;
  }

}
