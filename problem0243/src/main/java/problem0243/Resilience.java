package problem0243;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import utils.Factorization;
import utils.PrimeFactor;

/**
 * <h1>Resilience</h1>
 * <h2>Problem 243</h2>
 * A positive fraction whose numerator is less than its denominator is called a
 * proper fraction. For any denominator, d, there will be d−1 proper fractions;
 * for example, with d = 12: 1/12, 2/12, 3/12, 4/12, 5/12, 6/12, 7/12,
 * 8/12, 9/12, 10/12, 11/12.
 * <p>
 * We shall call a fraction that cannot be cancelled down a resilient fraction.
 * Furthermore we shall define the resilience of a denominator, R(d), to be the
 * ratio of its proper fractions that are resilient; for example, R(12) = 4/11.
 * In fact, d = 12 is the smallest denominator having a resilience R(d) < 4/10.
 * <p>
 * Find the smallest denominator d, having a resilience R(d) < 15499/94744.
 */
public class Resilience {

  static long smallestDenominatorWithResilienceLessThan(
      final long ratioNumerator,
      final long ratioDenominator) {
    checkArgument(ratioNumerator > 0);
    checkArgument(ratioDenominator > 1);

    for (long candidate = 2; candidate < Long.MAX_VALUE; ++candidate) {
      final long resilientFractionsCount = countResilientFractions(candidate);
      final long properFractionsCount = candidate - 1;

      if (resilientFractionsCount * ratioDenominator
          < properFractionsCount * ratioNumerator) {
        return candidate;
      }
    }

    return -1;
  }

  static long countResilientFractions(final long n) {
    checkArgument(n >= 2);

    long result = 1;  // 1/n is always a resilient fraction.
    final List<PrimeFactor> factors = Factorization.of(n).factors();
    final long[] primeFactors = factors.stream()
        .mapToLong(PrimeFactor::factor)
        .toArray();

    for (long i = 2; i < n; ++i) {
      if (isResilientFraction(i, primeFactors)) {
        result++;
      }
    }

    return result;
  }

  private static boolean isResilientFraction(final long numerator,
      final long[] denominatorPrimeFactors) {
    for (long factor : denominatorPrimeFactors) {
      if (numerator % factor == 0) {
        return false;
      }
    }

    return true;
  }
}
