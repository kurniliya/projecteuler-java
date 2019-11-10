package problem0050;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    final var primesSet = new HashSet<>(primes);

    final int primesSize = primes.size();
    for (int sublistSize = primesSize; sublistSize > 0; --sublistSize) {
      for (int sublistFrom = 0;
          sublistFrom + sublistSize <= primesSize;
          ++sublistFrom) {
        final int sublistTo = sublistFrom + sublistSize;
        var sublist = primes.subList(sublistFrom, sublistTo);
        var sum = sublist.stream().mapToLong(l -> l).sum();

        if (sum >= exclusiveUpperBoundary) {
          continue;
        }

        if (primesSet.contains(sum)) {
          System.out.println(sublist);
          return sum;
        }
      }
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
