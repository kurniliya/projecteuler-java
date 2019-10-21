package utils;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;

public class Factorization {

  private final ImmutableList<PrimeFactor> factors;

  private Factorization(final List<PrimeFactor> factors) {
    this.factors = ImmutableList.copyOf(factors);
  }

  public static Factorization of(final long n) {
    checkArgument(n >= 2);

    ImmutableList.Builder<PrimeFactor> factors = ImmutableList.builder();
    long number = n;
    for (long divisor = 2; divisor * divisor <= number; ++divisor) {
      if (number % divisor != 0) {
        continue;
      }

      long power = 0;
      while (number % divisor == 0) {
        ++power;
        number /= divisor;
      }
      factors.add(PrimeFactor.of(divisor, power));
    }

    // Do not forget that final remainder could also be a prime factor.
    if (number > 1) {
      factors.add(PrimeFactor.of(number, 1));
    }

    return new Factorization(factors.build());
  }

  public ImmutableList<PrimeFactor> factors() {
    return factors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Factorization that = (Factorization) o;
    return Objects.equals(factors, that.factors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(factors);
  }

  @Override
  public String toString() {
    return "Factorization{" +
        "factors=" + factors +
        '}';
  }
}
