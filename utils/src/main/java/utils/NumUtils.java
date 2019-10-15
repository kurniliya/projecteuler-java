package utils;

import java.util.ArrayList;

public class NumUtils {

  /**
   * @param n Number to split into digits.
   * @return List of digits, least significant first.
   */
  public static ArrayList<Integer> digits(final int n) {
    assert n > 0;

    final ArrayList<Integer> result = new ArrayList<>();

    int number = n;
    while (number > 0) {
      final int rightmostDigit = number % 10;
      result.add(rightmostDigit);
      number /= 10;
    }

    assert result.size() > 0;
    return result;
  }

  public static boolean isPalindrome(final int number) {
    return isPalindrome(digits(number));
  }

  private static boolean isPalindrome(final ArrayList<Integer> digits) {
    for (int i = 0; i < digits.size() / 2; i++) {
      if (!digits.get(i).equals(digits.get(digits.size() - i - 1))) {
        return false;
      }
    }
    return true;
  }
}
