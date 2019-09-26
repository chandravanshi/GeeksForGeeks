package geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Another {

  public static void main(String [] args) {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> one = Arrays.asList(1,1,1,1);
    List<Integer> two = Arrays.asList(1,1,1,1);
    List<Integer> three = Arrays.asList(1,1,1,1);
    lists.add(one);
    lists.add(two);
    lists.add(three);

    System.out.println(numberOfPaths(lists));


  }

  public static int numberOfPaths(List<List<Integer>> a) {
    double modulo = Math.pow(10, 9) + 7;
    List<List<Integer>> list = new ArrayList<>();
    int n = a.get(0).size();
    int m = a.size();
    for(int i=0; i<m ; i++) {
      List<Integer> temp = new ArrayList<>();
      for(int j=0; j<n; j++) {

        if (a.get(i).get(j) > 0) {
          if (j - 1 >= 0 && i - 1 >= 0) {
            temp.add(j, (int)((temp.get(j - 1) + list.get(i - 1).get(j))%modulo));
          } else if (j - 1 < 0 && i - 1 >= 0) {
            temp.add(j, list.get(i - 1).get(j));
          } else if (i - 1 < 0 && j - 1 >= 0) {
            temp.add(j, temp.get(j - 1));
          } else if(i - 1 < 0 && j - 1 < 0) {
            temp.add(j, a.get(i).get(j));
          }
        } else {
          temp.add(j, 0);
      }

      }
      list.add(temp);
    }

    return list.get(m-1).get(n-1);

  }

}
