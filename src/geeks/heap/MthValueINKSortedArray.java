package geeks.heap;

import java.util.ArrayList;
import java.util.List;

public class MthValueINKSortedArray {

  public static void main(String [] args) {
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(3);

    List<Integer> list2 = new ArrayList<>();
    list2.add(2);
    list2.add(4);
    list2.add(6);

    List<Integer> list3 = new ArrayList<>();
    list3.add(0);
    list3.add(9);
    list3.add(10);
    list3.add(11);

    List<List<Integer>> list = new ArrayList<>();
    list.add(list1);
    list.add(list2);
    list.add(list3);

    mthSmallest(list, 5);

  }

  public static void mthSmallest(List<List<Integer>> arrays, int m) {
    int k = arrays.size();
    int [] index = new int[k];
    int [] values = new int[k];
    //values[0] = arrays.get(0).get(0);
    for(int i = 0; i<k; i++ ) {
      values[i] = arrays.get(i).get(0);
      arrays.get(i).remove(0);
    }
    BuildHeap.buildMinHeap(values, index);
    int count = 0;
    while(count != m-1) {
      values[0] = arrays.get(index[0]).get(0);
      heapify(values, index, 0);
    }

    System.out.println(values[0]);

  }

  private static void heapify(int [] values, int [] index, int ind) {
    int n = values.length;
    int leftIndex = ind*2 +1;
    int rightIndex = ind*2 +2;
    int minIndex = ind;
    if(leftIndex < n && values[minIndex] > values[leftIndex]) {
      minIndex = leftIndex;
    }
    if(rightIndex < n && values[minIndex] > values[rightIndex]) {
      minIndex = rightIndex;
    }

    if(minIndex != ind) {
      swap(values, index, minIndex, ind);
      heapify(values, index, minIndex);
    }
  }

  private static void swap(int [] input, int [] index, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;

    int tempIndex = index[i];
    index[i] = index[j];
    index[j] = tempIndex;
  }




}
