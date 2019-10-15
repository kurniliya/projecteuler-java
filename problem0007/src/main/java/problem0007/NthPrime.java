package problem0007;

import utils.NumUtils;

/**
 * 10001st prime
 * <p>
 * Problem 7
 * <p>
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * <p>
 * What is the 10 001st prime number?
 */
class NthPrime {

  public static int compute(final int ordinalToCompute) {
    assert ordinalToCompute >= 1;

    int ordinal = 0;
    for (int i = 2; ; i++) {
      if (NumUtils.isPrime(i)) {
        ordinal++;
      }

      if (ordinal == ordinalToCompute) {
        return i;
      }
    }
  }
}
