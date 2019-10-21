package problem0243;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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
    long time = System.nanoTime();

    for (long candidate = 2; candidate < Long.MAX_VALUE - 2; candidate += 2) {
      final long resilientFractionsCount = countResilientFractions(candidate);
      final long properFractionsCount = candidate - 1;

      if (resilientFractionsCount * ratioDenominator
          < properFractionsCount * ratioNumerator) {
        return candidate;
      }
      final long step = 1_000_000;
      if (candidate % step == 0) {
        final long elapsed = System.nanoTime() - time;
        System.out.println(
            String
                .format("%d sec: %d * %d",
                    TimeUnit.NANOSECONDS.toSeconds(elapsed),
                    candidate / step, step));
        time = System.nanoTime();
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
   *
   * @param n Denominator to count number of resilient fractions for.
   * @return Number of resilient factions.
   */
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
      final long sign = factorCombination.size() == 1 ? +1 : -1;
      nonResilientCount += sign * (n - 1) / divisor;
    }

    return (n - 1) - nonResilientCount;
  }
}
