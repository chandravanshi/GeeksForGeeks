package geeks;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Goldaman {

  public static void main(String [] args) {
    calculatePossibleCombinations("2101");
  }


  static int nonRepeatingDigitProductCount(int x, int y, int z) {
    int sum = 0;
    for(int i=y; i<= z; i++) {
        Set<Integer> digits = converttoSet(i);
        Set<Integer> productDigigts = converttoSet(i * x);
        if(Collections.disjoint(digits, productDigigts)) {
          sum++;
        }
      }
    return sum;
  }

  private static Set<Integer> converttoSet(int n) {
    Set<Integer> digits = new HashSet<>();
    while(n/10 != 0) {
      digits.add(n%10);
      n = n/10;
    }
    digits.add(n);

    return digits;
  }


  public static long calculatePossibleCombinations(String inputStr) {

    char[] input= inputStr.toCharArray();
   return calaculate(input, input.length);

  }

  private static long calaculate(char [] input, int n) {
    int count[] = new int[n+1];
    count[0] = 1;
    count[1] = 1;
    if(input[0] == '0') {
      return 0;
    }

    for(int i=2; i<=n; i++) {
      count[i] = 0;
      if(input[i-1] > '0') {
        count[i] = count[i-1];
      }

      if(input[i-2] =='1' || input[i-2] == '2'  && input[i-1] < '7') {
        count[i] += count[i-2];
      }

    }
    return count[n];
  }

}
