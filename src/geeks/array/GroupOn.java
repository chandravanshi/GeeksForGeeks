package geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupOn {

  public static void main(String [] args) {
    List<Integer> val = Arrays.asList(1,2,3,5);
    System.out.println(minNum(4,val));
  }


  public static int minimumMoves(List<Integer> a, List<Integer> m) {
    int count = 0;
    for(int i= 0; i<a.size(); i++) {
      int first = a.get(i);
      int second = m.get(i);
      while(first != 0) {
        count += Math.abs(first%10 - second%10);
        first = first/10;
        second = second/10;
      }
    }
    return count;
  }


  public static int minNum(int threshold, List<Integer> happy) {
    List<Integer> difference = new ArrayList<>();
    for(int i=0; i< happy.size()-1; i++) {
      difference.add(happy.get(i+1) - happy.get(i));
    }

    int i = 0;
    int j = 0;
    int minimum = Integer.MAX_VALUE;
    int mini = i;
    int sum = difference.get(i);
    while(j < difference.size()) {
      while(threshold <= sum) {
        if(minimum > j-i+1) {
          minimum = j-i + 1;
          mini = i;
        }
        if(i == j) {
          return 2;
        }
        sum -= difference.get(i);
        i++;

      }
      if(j < difference.size()-1 ) {
        sum += difference.get(j+1);
      }
        j++;

    }
    if(mini > 0) {
      return ((i - 1) / 2 + 1) + (minimum + 1) / 2 + 1;
    }
    else {
      return (minimum + 1) / 2 + 1;
    }

  }

}
