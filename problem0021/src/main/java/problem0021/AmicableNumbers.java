package problem0021;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.annotations.VisibleForTesting;
import java.util.HashSet;
import java.util.List;
import utils.NumUtils;

/**
 * <h1>Amicable numbers</h1>
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then a
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class AmicableNumbers {

  static long compute(final int maxValue) {
    checkArgument(maxValue >= 2);

    HashSet<Long> amicableNumbers = new HashSet<>();

    for (long i = 2; i <= maxValue; ++i) {
      final long amicableCandidate = sumOfProperDivisors(i);

      if (amicableCandidate < i) {
        // We've already seen all the numbers less than current one.
        continue;
      } else if (amicableCandidate == i) {
        // Definition excludes perfect numbers: ...where a ≠ b...
        continue;
      }

      final long friendSumOfDivisors = sumOfProperDivisors(amicableCandidate);
      if (friendSumOfDivisors == i) {
        amicableNumbers.add(i);
        if (amicableCandidate < maxValue) {
          amicableNumbers.add(amicableCandidate);
        }
      }
    }

    return amicableNumbers.stream().mapToLong(n -> n).sum();
  }

  @VisibleForTesting
  static long sumOfProperDivisors(final long n) {
    final List<Long> factors = NumUtils.factors(n);
    return factors.stream().mapToLong(f -> f).filter(f -> f != n).sum();
  }
}
