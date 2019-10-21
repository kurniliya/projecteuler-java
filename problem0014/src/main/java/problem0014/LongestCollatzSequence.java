package problem0014;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.stream.LongStream;

/**
 * <h1>Longest Collatz sequence</h1>
 * <h2>Problem 14</h2>
 * The following iterative sequence is defined for the set of positive
 * integers:
 * <p>
 * n → n/2 (n is even)
 * <p>
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following
 * sequence: 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * <p>
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem), it
 * is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
class LongestCollatzSequence {

  private static final long START_SEED = 1;

  public static long compute(final long maxValue) {
    checkArgument(maxValue >= 1);

    long longestChainSeed = START_SEED;
    long longestChainLength = Long.MIN_VALUE;
    for (long seed = START_SEED; seed < maxValue + 1; ++seed) {
      final long length = chainLength(seed);
      if (length > longestChainLength) {
        longestChainLength = length;
        longestChainSeed = seed;
      }
    }

    return longestChainSeed;
  }

  static LongStream CollatzChainStream(final long seed) {
    checkArgument(seed > 0);

    return LongStream
        .iterate(seed, i -> i != 1, i -> i % 2 == 0 ? i / 2 : 3 * i + 1);
  }

  private static long chainLength(final long seed) {
    return CollatzChainStream(seed).count();
  }
}
