package geeks.tree;

public class Google {


  public static void main(String [] args) {
    int [] input = {-1,7,0,7,-8};
    System.out.println(findMaxSumLLevel(input));
  }

  public static int findMaxSumLLevel(int [] input) {
    int maxSum = input[0];
    int k = 1;
    int maxsumLevel = k;
    int startIndex = 1;

    while(true) {
      int sum = input[startIndex];
      int toIndex = startIndex+ ((Long)Math.round(Math.pow(2, k))).intValue() - 1;
      for(int m=startIndex+1; m<input.length && m<= toIndex; m++) {
        sum += input[m];
        startIndex++;

      }
      if(maxSum < sum) {
        maxSum = sum;
        maxsumLevel = k;
      }

      if(startIndex >= input.length-1) {
        break;
      }

      k++;
      startIndex++;

    }

    return maxsumLevel+1;

  }

}
