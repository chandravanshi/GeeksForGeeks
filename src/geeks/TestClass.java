package geeks;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.*/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
  public static void main(String args[] ) throws Exception {
    Map<Integer, List<Integer>> tree = new HashMap<>();


    /* Sample code to perform I/O:
     * Use either of these methods for inp*/

    //BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> weight = new ArrayList<>();
    boolean [] blackList = new boolean [n];
    for(int i=0; i<n-1; i++) {
      String [] line = br.readLine().split(" ");
      int a = Integer.parseInt(line[0]);
      int b = Integer.parseInt(line[1]);
      if(tree.get(a) != null) {
        tree.get(a).add(b);
      } else {
        List<Integer> list = new ArrayList();
        list.add(b);
        tree.put(a, list);
      }
    }

    String [] weightString = br.readLine().split(" ");
    for(int i =0; i< weightString.length; i++) {
      weight.add(Integer.parseInt(weightString[i]));
    }

    int spellCount = Integer.parseInt(br.readLine());
    for(int i=0; i<spellCount; i++) {
      String[] spells = br.readLine().split(" ");
      if(Integer.parseInt(spells[0]) == 1 ) {
        int a = Integer.parseInt(spells[1]);
        int b = Integer.parseInt(spells[2]);
        if(!blackList[a-1]) {

          weight.set(a-1, weight.get(a-1) + b);
        }
        for(int j =0; j< tree.get(a).size(); j++){
          if(!blackList[tree.get(a).get(j) -1]) {
            weight.set(tree.get(a).get(j) -1, weight.get(tree.get(a).get(j) -1) + b);
          }
        }
      } else if(Integer.parseInt(spells[0]) == 2) {
        int a = Integer.parseInt(spells[1]);
        int b = Integer.parseInt(spells[2]);
        if(!blackList[a-1]) {
          weight.set(a-1 , weight.get(a-1) + b);
        }

      }else if(Integer.parseInt(spells[0]) == 3) {
        int a = Integer.parseInt(spells[1]);
        if(blackList[a-1]) {

          blackList[a-1] = false;
        } else {
          blackList[a-1] = true;
        }

      } else if(Integer.parseInt(spells[0]) == 4) {
        int a = Integer.parseInt(spells[1]);
        System.out.println(weight.get(a-1));
      }
    }


    // Write your code here

  }


  public static class Tree {

  }
}
