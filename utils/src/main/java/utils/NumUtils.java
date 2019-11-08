package utils;

import static com.google.common.base.Preconditions.checkArgument;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NumUtils {

  /**
   * @param n Number to split into digits.
   * @return List of digits, least significant first.
   */
  public static ArrayList<Integer> digits(final int n) {
    checkArgument(n > 0);

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
    checkArgument(n.compareTo(BigInteger.ZERO) > 0);

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

  /**
   * @param n Number to analyze.
   * @return List of factors, including 1 and n itself.
   */
  public static ArrayList<Long> factors(final long n) {
    checkArgument(n > 0);

    final List<PrimeFactor> primes = PrimeFactorization.of(n).factors();

    final long alphabetSize = primes.stream()
        .mapToLong(f -> f.power() + 1)
        .reduce(1, (x, y) -> x * y);

    assert alphabetSize <= Integer.MAX_VALUE;
    final ArrayList<Long> factors = new ArrayList<>((int) alphabetSize);
    computeFactors(primes, 1, factors);

    assert factors.size() == alphabetSize : n;
    return factors;
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

  private static void computeFactors(final List<PrimeFactor> primeFactors,
      final long factor, final List<Long> factors) {
    final PrimeFactor prime = primeFactors.get(0);
    final int primeFactorsSize = primeFactors.size();

    long complexFactor = 1;
    for (int i = 0; i <= prime.power(); ++i) {
      final long newFactor = factor * complexFactor;

      if (primeFactorsSize == 1) {
        factors.add(newFactor);
      } else {
        computeFactors(primeFactors.subList(1, primeFactorsSize),
            newFactor, factors);
      }
      complexFactor *= prime.factor();
    }
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
