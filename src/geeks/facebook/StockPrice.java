package geeks.facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StockPrice {


  public static void main(String [] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(reader.readLine());
    for(int i = 0; i< T; i++) {
      int n = Integer.parseInt(reader.readLine());
      int [] prices = new int[n];
      String line = reader.readLine();
      String [] array = line.split(" ");
      for(int j = 0; j < n; j++) {
        prices[j] = Integer.parseInt(array[j]);
      }
      getStock(prices);
      System.out.println();
    }
    /*int [] prices = {100, 180, 260, 310, 40, 535, 695};
    int [] prices1 = {23, 13, 25, 29, 33, 19, 34, 45, 69, 67};
    getStock(prices1);*/
  }

  public static void getStock(int [] prices) {

    int lowIndex = 0;
    int highIndex = 0;
    boolean flag = false;

    for(int i=1; i< prices.length; i++) {
      if(prices[i] > prices[highIndex]) {
        highIndex = i;
      } else if (prices[i] < prices[highIndex]){
        if(lowIndex != highIndex) {
          System.out.print("(" + lowIndex + " " + highIndex + ")" + " ");
          flag = true;
        }
        lowIndex = i;
        highIndex = i;
      }
    }

    if(lowIndex != highIndex) {
      System.out.print("("+lowIndex+" "+highIndex+")" + " ");
      flag = true;
    }
    if(!flag) {
      System.out.print("No Profit");
    }
  }

}
