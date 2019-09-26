package geeks.Strings;

public class Rotation {

  public static void main(String [] args) {
    System.out.println(checkIfRotated("wa", "aw"));
  }

  public static boolean checkIfRotated(String first, String second) {
    if(first.length() != second.length()) {
      return false;
    }
    int n = first.length();
    int i = 0;
    int j = 0;
    while(i < n && j < n) {
      if(first.charAt(i) == second.charAt(j)) {
        i++; j++;
      } else {
        i++;
        j = 0;
      }
    }

    if(isSubString(first.substring(0, n-j), (second.substring(j)))) {
      return true;
    }

    return false;
  }


  private static boolean isSubString(String s1, String s2) {
    return s1.equals(s2);
  }

}
