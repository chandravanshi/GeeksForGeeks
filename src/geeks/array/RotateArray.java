package geeks.array;

public class RotateArray {

  public static void main(String [] args) {
      int [][] input = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
    //int[][] input = {{1}};
      rotateArray(input);
      printArray(input);
  }

  private static void rotateArray(int [][] input) {
    int n = input[0].length;
    for(int j = 0; j < n/2; j++) {
      for(int i=j; i< n-j-1; i++) {
        int temp2 = input[n-j-1][i];
        input[n-j-1][i] = input[i][j];
        int temp = input[n-j-i-1][n-j-1];
        input[n-j-i-1][n-j-1] = temp2;
        temp2 = input[j][n-i-1];
        input[j][n-i-1] = temp;
        input[i][j] = temp2;
      }
    }
  }

  private static void printArray(int[][] input) {
    for(int i=0; i< input.length; i++) {
      for(int j=0; j< input.length; j++) {
        System.out.print(input[i][j] + " ");
      }
      System.out.println();
    }
  }

}
