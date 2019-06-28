package geeks.heap;

public class BuildHeap {

  public static void main(String [] args) {

    int [] input = {34,2,3,2,4,34,25,76,12,5,2,9,8,23,1,2,12,56,32,45,32,36};
    buildHeap(input);
    for(int i=0;  i< input.length; i++) {
      System.out.print(input[i] + " ");
    }

  }

  private static void buildHeap(int [] input) {
    int n = input.length;
    for(int i = n/2 -1; i >=0 ; i--) {
      heapify(input, i, n);
    }
  }

  private static void heapify(int [] input, int position, int n) {
    if(position >= n/2) {
      return;
    }
    int leftIndex = 2*position+1;
    int rightIndex = 2*position+2;
    int maxIndex = position;
    if(leftIndex < n && input[leftIndex] > input[maxIndex]) {
      maxIndex = leftIndex;
    }
    if(rightIndex < n && input[rightIndex] > input[maxIndex]) {
      maxIndex = rightIndex;
    }
    if(maxIndex != position) {
      swap(input, position, maxIndex);
      heapify(input, maxIndex, n);
    }
   /* if(input[rightIndex] > input[leftIndex]) {
      maxIndex = rightIndex;
    }
    if(input[position] < input[maxIndex]) {
      swap(input, position, maxIndex);
    }*/

  }

  private static void swap(int [] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }


}
