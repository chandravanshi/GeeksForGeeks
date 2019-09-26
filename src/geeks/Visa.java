package geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Visa {

  public static void main(String [] args) {
    List<Integer> values = Arrays.asList(10,20,7);

    System.out.println(minSum(values, 4));
  }


  public static long pilesOfBoxes(List<Integer> boxesInPiles) {
    Collections.sort(boxesInPiles);
    List<Integer> value = new ArrayList<>();
    value.add(0);
    for(int i=1; i< boxesInPiles.size(); i++) {
      if(boxesInPiles.get(i) > boxesInPiles.get(i-1)) {
        value.add(value.get(i-1) + 1);
      } else {
        value.add(value.get(i-1));
      }
    }
    int sum = 0;
    for(int i=0; i< value.size(); i++) {
      sum += value.get(i);
    }
    return sum;
  }


  public static int minSum(List<Integer> num, int k) {
    Collections.sort(num, Collections.reverseOrder());
    int i =0;
    while(i < k) {
      int val =(int)Math.ceil(num.get(0)/2.0);
      placeInArray(val, num);
      i++;
    }

    int sum =0;
    for(int j=0; j< num.size(); j++) {
      sum += num.get(j);
    }
    return sum;
  }

  private static void placeInArray(int val, List<Integer> num) {
    num.set(0, val);
    for(int i=1; i< num.size(); i++) {
      if(num.get(i) > num.get(i-1)) {
        swap(num, i, i-1);
      }
    }
  }

  private static void swap(List<Integer> num, int i, int j) {
    int temp = num.get(i);
    num.set(i, num.get(j));
    num.set(j, temp);
  }

}
