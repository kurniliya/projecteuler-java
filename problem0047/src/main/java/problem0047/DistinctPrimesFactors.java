package problem0047;

import static com.google.common.base.Preconditions.checkArgument;

import utils.PrimeFactorization;

/**
 * <h1>Distinct primes factors</h1>
 * <p>
 * <h2>Problem 47</h2>
 * <p>
 * The first two consecutive numbers to have two distinct prime factors are:
 * <p>
 * 14 = 2 × 7
 * <p>
 * 15 = 3 × 5
 * <p>
 * The first three consecutive numbers to have three distinct prime factors
 * are:
 * <p>
 * 644 = 2² × 7 × 23
 * <p>
 * 645 = 3 × 5 × 43
 * <p>
 * 646 = 2 × 17 × 19.
 * <p>
 * Find the first four consecutive integers to have four distinct prime factors
 * each. What is the first of these numbers?
 */
class DistinctPrimesFactors {

  static long compute(final long consecutiveNumbersCount,
      final long distinctFactorsCount) {
    checkArgument(consecutiveNumbersCount >= 1);
    checkArgument(distinctFactorsCount >= 1);

    final long EMPTY_SEQUENCE = 0;

    long number = 2;
    long matchingSequenceStart = 0;
    int matchingSequenceLength = 0;
    while (true) {
      if (matchesCriteria(number, distinctFactorsCount)) {
        matchingSequenceLength++;
        if (matchingSequenceStart == EMPTY_SEQUENCE) {
          matchingSequenceStart = number;
        }
      } else {
        matchingSequenceLength = 0;
        matchingSequenceStart = EMPTY_SEQUENCE;
      }
      if (matchingSequenceLength >= consecutiveNumbersCount) {
        return matchingSequenceStart;
      }

      number++;
    }
  }

  private static boolean matchesCriteria(final long number,
      final long distinctFactorsCount) {
    return PrimeFactorization.of(number).factors().size() == distinctFactorsCount;
  }
}
