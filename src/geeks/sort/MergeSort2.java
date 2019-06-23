package geeks.sort;

public class MergeSort2 {

  public static void main(String [] args) {

  }

  private static void sort(int [] input, int firstIndex, int lastIndex) {
    if(firstIndex < lastIndex) {
      int midIndex = (firstIndex + lastIndex)/2;
      sort(input, firstIndex, midIndex);
      sort(input, midIndex + 1, lastIndex);
      merge(input, firstIndex, midIndex, lastIndex);
    }
  }

  private static void merge(int [] input, int firstIndex, int midIndex, int lastIndex) {
    int i = firstIndex;
    int j = midIndex + 1;
    while(i <= midIndex || j <= lastIndex) {
      if(input[i] < input[j]) {
        i++;
      }
      i++;
    }
  }

}
