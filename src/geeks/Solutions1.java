package geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions1 {

  public static void main(String [] args) {
    //finalPrice(Arrays.asList(2,3,1,2,4,2));
    //System.out.println(plusMult(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
  }


  public static void finalPrice(List<Integer> prices) {
    //List<Integer> sale = new ArrayList<>();
    long sale = 0;
    List<Integer> same = new ArrayList<>();
    for(int i=0; i< prices.size(); i++) {
      int amount = 0;
      for(int j =i+1; j< prices.size(); j++) {

        if(prices.get(i) >= prices.get(j)) {
          amount = prices.get(j);
          break;
        }
      }
      if(amount == 0) {
        same.add(i);
      }
      sale += (prices.get(i) - amount);
    }

    System.out.println(sale);
    for(int i=0; i< same.size(); i++) {
      System.out.print(same.get(i) + " ");
    }

  }

  public static String plusMult1(List<Integer> A) {
    long even = 0;
    long odd =0;
    int length = A.size();
    int i=0;
    int j= 2;
    while(i < length) {
      long evenpair = A.get(i);
      if(j < length) {
        evenpair = evenpair*A.get(j);
      }
      evenpair = evenpair%2;
      even += evenpair;
      even = even%2;
      i = i+4;
      j = j+4;
    }

    int m=1;
    int n= 3;
    while(m < length) {
      long oddPair = A.get(m);
      if(n < length) {
        oddPair = oddPair*A.get(m);
      }
      oddPair = oddPair%2;
      odd += oddPair;
      odd = odd%2;
      m = m+4;
      n = n+4;
    }
    long rEven =even%2;
    long rOdd = odd%2;
    if(rEven > rOdd) {
      return "EVEN";
    } else if(rEven < rOdd) {
      return "ODD";
    } else {
      return "NEUTRAL";
    }

  }

  public static String plusMult(List<Integer> A) {
    boolean flag = true;
    int i = 2;
    long even = A.get(0);
    while(i < A.size()) {
      if(flag) {
        even = even*A.get(i);
        even = even%2;
        flag=false;
      } else {
        even = even+A.get(i);
        even = even%2;
        flag = true;
      }
      i = i+2;
    }

    even = even%2;

    boolean flag2 = true;
    int j = 1;
    long odd = A.get(j);
    while(i < A.size()) {
      if(flag2) {
        odd = odd*A.get(j);
        odd = odd%2;
        flag2= false;
      } else {
        odd = odd+A.get(j);
        odd = odd%2;
        flag2 = true;
      }
      j = j+2;
    }

    odd = odd%2;

    if(even > odd) {
      return "EVEN";
    } else if(even < odd) {
      return "ODD";
    } else {
      return "NEUTRAL";
    }

  }


}
