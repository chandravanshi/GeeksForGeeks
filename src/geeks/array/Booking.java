package geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class Booking {


  public static List<Integer> multiple(int x, int y, int z, int n) {
    List<Integer> list = new ArrayList<>();
    if(x == 0 || y==0) {
      return list;
    }
    for(int i=1; i<=n ;i++) {
      if((i%x==0 || i%y==0) && i%z != 0) {
        list.add(i);
      }
    }

    return list;

  }


  public static List<Integer> missingReservations(List<List<Integer>> firstReservationList, List<List<Integer>> secondReservationList) {
    Set<Integer> firstSet = new HashSet<>();
    List<Integer> returnList = new ArrayList<>();
    for(int i=0; i< firstReservationList.size(); i++) {
      firstSet.add(firstReservationList.get(i).get(0));
    }

    for(int j=0; j< secondReservationList.size(); j++) {
      if(!firstSet.contains(secondReservationList.get(j).get(0))) {
        returnList.add(secondReservationList.get(j).get(0));
      }
    }

    return returnList;

  }



  public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
    Map<Integer, Integer> breakCount = new HashMap<>();
    Map<Integer, Integer> lastBreak = new HashMap<>();
    for(int i= 0; i<employeeCalls.size(); i++) {
      int id = employeeCalls.get(i).get(0);
      int startTime = employeeCalls.get(i).get(1);
      int endTime = employeeCalls.get(i).get(2);
      if(lastBreak.containsKey(id)) {
        if (lastBreak.get(id) < startTime) {
          breakCount.put(id, breakCount.get(id) + 1);
        }
      } else {
        lastBreak.put(id, endTime);
        breakCount.put(id, 0);
      }
    }

    List<List<Integer>> returnList = new ArrayList<>();

    for(Entry<Integer, Integer> entry : breakCount.entrySet()) {
      if(entry.getValue() < k) {
        List<Integer> list  = new ArrayList<>();
        list.add(entry.getKey());
        list.add(entry.getValue());
        returnList.add(list);
      }
    }
    return returnList;
  }

  public static void main(String [] args) {
    String positive = "breakfast beach citycenter location metro view staff price";
    String negative = "not";
    List<Integer> ids = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    List<String> reviews = new ArrayList<>(Arrays.asList("yes no yes3 no2 no3","yes yes yes3 no2 no3","yes yes yes3 yes2 no3","yes no no3 no2 no3","yes no yes3 yes2 no3"));

    awardTopKHotels(positive, negative, ids, reviews, 3);
  }


  public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {

    Set<String> positive = new HashSet<>(Arrays.asList(positiveKeywords.split(" ")));
    Set<String> negative = new HashSet<>(Arrays.asList(negativeKeywords.split(" ")));
    List<Pair> pairs = new ArrayList<>();
    Map<Integer, Integer> ratings = new HashMap<>();
    for(int i = 0; i< hotelIds.size(); i++) {
      String [] reviewsWords  = reviews.get(i).split(" ");
      int currentScore = 0;
      for(String word : reviewsWords) {
        if(positive.contains(word)) {
          currentScore += 3;
        } else if (negative.contains(word)) {
          currentScore -= 1;
        }
      }
      if(ratings.containsKey(hotelIds.get(i))) {
        ratings.put(hotelIds.get(i), ratings.get(hotelIds.get(i)) + currentScore);
      } else {
        ratings.put(hotelIds.get(i), currentScore);
      }

    }
    for(Entry<Integer,Integer> entry : ratings.entrySet()) {
      Pair pair = new Pair();
      pair.id = entry.getKey();
      pair.score = entry.getValue();
      pairs.add(pair);
    }

    Collections.sort(pairs, Collections.reverseOrder());
    List<Integer> returnList = new ArrayList<>();
    for(int i=0; i<pairs.size(); i++) {
      if(i >= k) {
        break;
      }
      returnList.add(pairs.get(i).id);
    }
    return returnList;
  }


  static class Pair implements Comparable<Pair> {
    int id;
    int score;
    @Override
    public int compareTo(Pair o) {
      return this.score - o.score;
    }
  }

}
