package geeks.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Convert {


  public static void main(String [] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    String s = reader.readLine();
    String t = reader.readLine();

    System.out.println(convert(s, t));
  }


  private static int convert(String s, String t) {
    char [] first = s.toCharArray();
    char [] second = t.toCharArray();
    int n = first.length;
    int j = first.length -1;
    while(j >= 0) {
      if(first[n-1] == second[j]  && t.substring(0,n-j).equals(s.substring(j, n))) {
          return n-j-1;
      }
      j--;
    }
    return n-j;
  }


}
