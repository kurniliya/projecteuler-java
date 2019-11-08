package utils;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Factorizer {

  private static final Map<Long, Set<Multiset<Long>>> known = new HashMap<>();

  /**
   * @param n Number to factorize.
   * @return List of all possible factorizations, including {@code n} itself.
   */
  @NotNull
  public static Set<Multiset<Long>> factorizations(final long n) {
    checkArgument(n >= 2);

    // Return cached value if there's one.
    final var maybeKnown = known.get(n);
    if (maybeKnown != null) {
      return maybeKnown;
    }

    final var resultBuilder = ImmutableSet.<Multiset<Long>>builder();

    final List<Long> factors = NumUtils.factors(n);

    for (long factor : factors) {
      if (factor == 1) {
        continue;
      }
      if (factor == n) {
        resultBuilder.add(ImmutableMultiset.of(n));
        continue;
      }
      final long remainder = n / factor;
      final var remainderFactorizations = factorizations(remainder);
      for (var remainderFactorization : remainderFactorizations) {
        var factorization = ImmutableMultiset.<Long>builder();
        factorization.add(factor);
        factorization.addAll(remainderFactorization);
        resultBuilder.add(factorization.build());
      }
    }
    var result = resultBuilder.build();
    var replacedValue = known.put(n, result);
    assert replacedValue == null : n;

    assert checkMemberTypes(result);
    assert checkProductsEqualToNumber(n, result);
    return result;
  }

  @Contract(pure = true)
  private static boolean checkMemberTypes(@NotNull Set<Multiset<Long>> list) {
    for (var element : list) {
      if (!(element instanceof ImmutableMultiset)) {
        return false;
      }
    }
    return true;
  }

  @Contract(pure = true)
  private static boolean checkProductsEqualToNumber(final long n,
      @NotNull Set<Multiset<Long>> list) {
    for (var factorization : list) {
      final long product = factorization.stream()
          .mapToLong(l -> l)
          .reduce(1, Math::multiplyExact);
      if (product != n) {
        return false;
      }
    }
    return true;
  }
}
