package geeks.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solu {

  public static void main(String [] args) {
    /*List<Integer> arr = new ArrayList<>(Arrays.asList(5,5,5,7,7,3,4,7));
    List<String>*/

    System.out.println(getLuckyFloorNumber(12));
  }


  static List<String> packNumbers(List<Integer> arr) {
    List<String> response = new ArrayList<>();
    int counter=1;
    int previous = arr.get(0);
    for(int i=1; i< arr.size(); i++) {
      if(previous == arr.get(i)) {
        counter ++;
      } else {
        response.add(previous + ":" + counter);
        counter = 1;
        previous = arr.get(i);
      }
    }
    return response;
  }


  static int getLuckyFloorNumber(int n) {
      for(int i =1; i<=n; i++) {
        boolean a = checkforFour(i);
        boolean b = checkForThirteen(i);
        if(a || b) {
          n++;
        }
      }

      return n;

  }

  private static boolean checkForThirteen(int i) {
    while(i > 0) {
      if(i%100 == 13) {
        return true;
      }
      i = i/10;
    }
    return false;
  }

  private static boolean checkforFour(int i) {
    while(i > 0) {
      if(i%10 == 4) {
        return true;
      }
      i = i/10;
    }
    return false;
  }

}
