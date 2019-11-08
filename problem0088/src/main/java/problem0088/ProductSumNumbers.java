package problem0088;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Multiset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import utils.Factorizer;

public class ProductSumNumbers {

  public static long compute(final long lastSetSize) {
    checkArgument(lastSetSize >= 2);

    List<Long> numbers = listNumbers(lastSetSize);
    long result = numbers.stream()
        .mapToLong(n -> n)
        .reduce(0, Math::addExact);

    assert result > 0;
    return result;
  }

  @VisibleForTesting
  static List<Long> listNumbers(final long lastSetSize) {
    checkArgument(lastSetSize >= 2);

    final var result = new ArrayList<Long>();

    final Set<Long> requiredSizes = LongStream.rangeClosed(2, lastSetSize)
        .boxed()
        .collect(Collectors.toCollection(HashSet::new));
    assert requiredSizes.size() == lastSetSize - 1 : lastSetSize;

    long n = 2;
    while (!requiredSizes.isEmpty()) {
      final Set<Long> satisfiedSizes = setSizes(n);
      final var intersection = new HashSet<>(satisfiedSizes);
      intersection.retainAll(requiredSizes);

      if (requiredSizes.removeAll(satisfiedSizes)) {
        assert intersection.size() > 0 : n;
        result.add(n);
      } else {
        assert intersection.size() == 0 : n;
      }

      assert n <= 2 * lastSetSize;
      n++;
    }

    assert !result.isEmpty();
    assert result.size() == (new HashSet<>(result)).size();
    assert result.size() <= lastSetSize - 1;

    return result;
  }

  @VisibleForTesting
  static Set<Long> setSizes(final long n) {
    checkArgument(n >= 2);

    final Set<Long> result = new HashSet<>();

    final Set<Multiset<Long>> factorizations = Factorizer.factorizations(n);
    assert factorizations.size() >= 1 : n;

    for (Multiset<Long> factorization : factorizations) {
      assert factorization.stream()
          .mapToLong(l -> l)
          .reduce(1, Math::multiplyExact) == n : n;

      final long sumOfFactors = factorization.stream().mapToLong(l -> l).sum();
      assert sumOfFactors >= 2 : n;
      assert sumOfFactors <= n : n;

      final long numberOfFactors = factorization.size();
      //noinspection ConstantConditions
      assert numberOfFactors >= 1 : n;

      final long numberOfOnes = (n - sumOfFactors);
      assert numberOfOnes >= 0 : n;

      final long setSize = numberOfOnes + numberOfFactors;
      assert setSize >= 1 : n;
      assert setSize < n : n;

      if (setSize > 1) {
        result.add(setSize);
      }
    }

    return result;
  }
}
