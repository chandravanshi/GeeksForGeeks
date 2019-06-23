package geeks.sort;

public class MergeSort {

  public static void main(String [] args) {
     int [] input = {5,4,6,2,9,12,5,2,0,-4,-34,3,43,-2,39,45};
     int [] result = sort(input, 0, input.length-1);
     for(int i=0; i< result.length; i++) {
       System.out.print(result[i]+ " ");
     }

  }

  private static int[] sort(int [] input, int i, int j) {
    if(j == i) {
      int [] result = {input[i]};
      return result;
    }

    int mid= (i+j)/2;
    return merge(sort(input, i, mid), sort(input, mid+1, j));
  }

  private static int [] merge(int [] first, int [] second) {
    int m = first.length;
    int n = second.length;
    int [] result = new int [m + n];
    int i = 0;
    int j = 0;
    int k = 0;

    while(i < m && j < n) {
      if(first[i] <= second[j]) {
        result[k] = first[i];
        i++;
      } else {
        result[k] = second[j];
        j++;
      }
      k++;
    }

    if(i < m) {
      copy(result, i, k, first);
    }
    if(j < n) {
      copy(result, j, k, second);
    }
    return result;
  }


  private static void copy(int [] result, int i, int k, int [] input) {
    int n = input.length;

    while(i < n) {
      result[k] = input[i];
      i++;
      k++;
    }
  }

}
