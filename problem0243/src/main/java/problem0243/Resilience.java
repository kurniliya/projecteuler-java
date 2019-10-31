package problem0243;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.stream.Collectors;
import utils.Factorization;
import utils.PrimeFactor;

/**
 * <h1>Resilience</h1>
 * <h2>Problem 243</h2>
 * A positive fraction whose numerator is less than its denominator is called a
 * proper fraction. For any denominator, d, there will be d−1 proper fractions;
 * for example, with d = 12: 1/12, 2/12, 3/12, 4/12, 5/12, 6/12, 7/12, 8/12,
 * 9/12, 10/12, 11/12.
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

    final long START_VALUE = 2;
    double minResilience = Double.MAX_VALUE;
    long minResilienceNumber = START_VALUE;
    long step = 1;

    for (long candidate = START_VALUE;
        candidate < Long.MAX_VALUE;
        candidate += step) {
      final long resilientFractionsCount = countResilientFractions(candidate);
      final long properFractionsCount = candidate - 1;

      if (resilientFractionsCount * ratioDenominator
          < properFractionsCount * ratioNumerator) {
        return candidate;
      }

      final double resilience =
          resilientFractionsCount / (double) properFractionsCount;
      if (resilience < minResilience) {
        minResilience = resilience;
        final long stepBetweenMinimums = candidate - minResilienceNumber;
        minResilienceNumber = candidate;
        if (stepBetweenMinimums > step) {
          step = stepBetweenMinimums;
        }
      }
    }

    return -1;
  }

  /**
   * Returns number of resilient fractions for given denominator.
   * <p>
   * Implementations idea:
   * <p>
   * Find prime factorization of the denominator. Then all the numerators
   * divisible by one of the prime factors are non-resilient, and the rest are
   * resilient.
   * <p>
   * First, we compute the number of numerators divisible by each of prime
   * factors by dividing number of all the possible numerators (n-1) by the
   * value of the factor. This procedure counts more than once every numerator
   * that is divisible by more than one of denominators's prime factors.
   * <p>
   * We then correct for this over-counting directly, by additionally computing
   * number of numerators that have been counted more than once, i.e. those
   * divisible by some combination of several prime factors.
   * <p>
   * See also for description of essentially the same idea:
   * https://cs.stackexchange.com/q/97501/60327
   *
   * @param n Denominator to count number of resilient fractions for.
   * @return Number of resilient fractions.
   */
  @VisibleForTesting
  static long countResilientFractions(final long n) {
    checkArgument(n >= 2);

    final Set<Long> factors = Factorization.of(n).factors().stream()
        .mapToLong(PrimeFactor::factor)
        .boxed()
        .collect(Collectors.toSet());
    long nonResilientCount = 0;

    Set<Set<Long>> factorCombinations = Sets.powerSet(factors);
    for (var factorCombination : factorCombinations) {
      if (factorCombination.size() == 0) {
        // Ignore empty set.
        continue;
      }
      long divisor = factorCombination.stream()
          .reduce(1L, (left, right) -> left * right);

      final long sign = (factorCombination.size() % 2) == 1 ? +1 : -1;
      nonResilientCount += sign * (n - 1) / divisor;
    }

    return (n - 1) - nonResilientCount;
  }
}
