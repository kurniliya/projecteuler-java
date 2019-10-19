package problem0010;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.stream.LongStream;
import utils.NumUtils;

/**
 * Summation of primes
 * <p>
 * Problem 10
 * <p>
 * <p>
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 */
class SummationOfPrimes {

  static long compute(final long upperBoundary) {
    checkArgument(upperBoundary >= 0);

    final long result = LongStream
        .range(2, upperBoundary)
        .filter(NumUtils::isPrime)
        .sum();

    assert result >= 0;
    return result;
  }
}
