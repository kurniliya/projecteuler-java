package utils;

import java.math.BigInteger;
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

  /**
   * @param n Number to split into digits.
   * @return List of digits, least significant first.
   */
  public static ArrayList<Integer> digits(final BigInteger n) {
    assert n.compareTo(BigInteger.ZERO) > 0;

    final ArrayList<Integer> result = new ArrayList<>();

    BigInteger number = n;
    while (number.compareTo(BigInteger.ZERO) > 0) {
      BigInteger[] pair = number.divideAndRemainder(BigInteger.TEN);
      result.add(pair[1].intValueExact());
      number = pair[0];
    }

    assert result.size() > 0;
    return result;
  }

  public static boolean isPalindrome(final int number) {
    return isPalindrome(digits(number));
  }

  public static boolean isPrime(final long number) {
    if (number <= 1) {
      return false;
    }

    for (int i = 2; i * i <= number; i++) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
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
