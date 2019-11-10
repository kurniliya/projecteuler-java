package problem0050;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import utils.NumUtils;

public class App {

  public static void main(String[] args) {
    System.out.println(solve(1_000_000));
  }

  @VisibleForTesting
  static long solve(final long exclusiveUpperBoundary) {
    checkArgument(exclusiveUpperBoundary >= 2);

    final var primes = listOfPrimesUpTo(exclusiveUpperBoundary);
    final long startTime = System.nanoTime();

    final int primesSize = primes.size();

    long leftmostSublistSum = primes.stream().mapToLong(l -> l).sum();
    for (int sublistSize = primesSize; sublistSize > 0; --sublistSize) {
      long sum = leftmostSublistSum;

      for (int sublistFrom = 0;
          sublistFrom + sublistSize <= primesSize;
          ++sublistFrom) {
        final int sublistTo = sublistFrom + sublistSize;

        if (sum >= exclusiveUpperBoundary) {
          break;
        }

        if (NumUtils.isPrime(sum)) {
          final long endTime = System.nanoTime();
          final var sublist = primes.subList(sublistFrom, sublistTo);
          System.out.println(sublist);
          System.out.println("Search took " + TimeUnit.NANOSECONDS
              .toMillis(endTime - startTime) / 1_000.0 + " sec");
          return sum;
        }
        sum += (primes.get(sublistTo) - primes.get(sublistFrom));
      }

      leftmostSublistSum -= primes.get(sublistSize - 1);
    }

    throw new AssertionError();
  }

  @VisibleForTesting
  @NotNull
  static List<Long> listOfPrimesUpTo(final long lastExclusive) {
    var result = new ArrayList<Long>();
    if (lastExclusive <= 2) {
      return result;
    }

    result.add(2L);
    for (long i = 3; i < lastExclusive; i += 2) {
      if (NumUtils.isPrime(i)) {
        result.add(i);
      }
    }

    return result;
  }
}
