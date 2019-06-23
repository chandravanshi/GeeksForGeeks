package geeks.Strings;

public class Soultion {

  public static void main(String [] args) {
    System.out.println(rearrange("fsf34fg4h5j6"));
  }

  private static String rearrange(String s) {
    StringBuilder builder = new StringBuilder();
    char [] input = s.toCharArray();
    int sum = 0;
    for(char c : input) {
      if(Character.isDigit(c)) {
        sum += Character.digit(c, 10);
      } else {
        builder.append(c);
      }
    }

    builder.append(sum);

    return builder.toString();
  }

}
