package geeks;

public class Solution {
  public static void main(String [] args) {
    System.out.println(isPalindrome("abcfba"));
  }

  private static boolean isPalindrome(String input) {
    char [] sArray = input.toCharArray();
    int length = sArray.length;
    for(int i =0; i< length/2 +1 ; i++) {
      if(sArray[i] != sArray[length - i -1]) {
        return false;
      }
    }
    return true;
  }
}