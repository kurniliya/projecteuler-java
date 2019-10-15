/*
Largest prime factor
Problem 3

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */
package problem0003;

class LargestPrimeFactor {

  /**
   * Implements trivial division
   * <p>
   * https://cp-algorithms.com/algebra/factorization.html#toc-tgt-0
   *
   * @param inputNumber Number to find largest prime factor for.
   * @return Largest prime factor.
   */
  long compute(final long inputNumber) {
    assert inputNumber >= 2;

    long result = 0;
    long number = inputNumber;
    for (int divisor = 2; divisor * divisor <= number; divisor++) {
      while (number % divisor == 0) {
        result = divisor;
        number /= divisor;
      }
    }

    // Do not forget that final remainder could also be a prime factor.
    if (number > 1) {
      result = number;
    }

    assert result >= 2;
    return result;
  }
}
