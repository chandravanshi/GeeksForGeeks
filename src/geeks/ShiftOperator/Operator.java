package geeks.ShiftOperator;

public class Operator {

  public static void main(String [] args) {

    System.out.println(shiftLeft(7,4));
    System.out.println(shiftRight(7,4));

  }

  private static int shiftLeft(int value, int shift) {
    return value << shift;
  }

  private static int shiftRight(int value, int shift) {
    return value >> shift;
  }

}
