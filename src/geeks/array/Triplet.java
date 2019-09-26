package geeks.array;

import java.util.ArrayList;
import java.util.List;

public class Triplet {

  public static void main(String [] args) {
    int [] input = {4,1,6,8,2,5,3,9,8,10};
    printTriplets(input);

  }


  private static List<Integer> findAllSinglets(int [] input, int index) {
    int element = input[index];
    List<Integer> singlets = new ArrayList<>();
    for(int i = index+1; i< input.length; i++) {
      if(input[i] > element) {
        singlets.add(input[i]);
      }
    }
    return singlets;
  }

  private static void printTriplets(int [] input) {
    for(int i=0; i<input.length; i++) {
      List<Doublet> doublets = findAllDoublet(input, i);
      if(doublets.size() > 0) {
        printAllTriplets(input[i], doublets);
      }
    }
  }

  private static void printAllTriplets(int i, List<Doublet> doublets) {
    for(int k=0; k<doublets.size(); k++) {
      System.out.println(i + " "+ doublets.get(k).first+" "+ doublets.get(k).second);
    }
  }


  private static List<Doublet> findAllDoublet(int [] input, int index) {
    int element = input[index];
    List<Doublet> doublets = new ArrayList<>();
    for(int i= index+1; i<input.length; i++) {
      if(input[i] > element) {
        List<Integer> singlets = findAllSinglets(input, i);
        if(singlets.size() > 0) {
          addToDoubletList(input[i], singlets, doublets);
        }
      }
    }
    return doublets;
  }

  private static void addToDoubletList(int element, List<Integer> singlets, List<Doublet> doublets) {
    for(int j=0; j<singlets.size(); j++) {
      doublets.add(new Doublet(element, singlets.get(j)));
    }
  }


  static class Doublet {
    int first;
    int second;

    public Doublet(int first, int second) {
      this.first= first;
      this.second = second;
    }
  }



  /*public static void findTriplet(int [] input) {
    for(int i=0; i< input.length -2; i++ ) {
      int first = input[i];
      IndexedElement second = findTrip(input, i+1, first);
      IndexedElement third = null;
      if(second != null) {
        third = findTrip(input, second.index+1, second.element);
      }
      if(second != null && third != null) {
        System.out.println(first + " "+ second.element + " "+ third.element);
      }
    }
  }

  private static IndexedElement findTrip(int[] input, int index, int element) {
    if(index >= input.length) {
      return null;
    }
   for(int i= index; i< input.length; i++) {
     if(input[i] > element) {
       return new IndexedElement(input[i], i);
     }
   }

   return null;
  }




  static class IndexedElement {
    int element;
    int index;

    public  IndexedElement(int element, int index) {
      this.element = element;
      this.index = index;
    }

  }*/

}
