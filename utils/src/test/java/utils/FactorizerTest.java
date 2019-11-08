package utils;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMultiset;
import org.junit.Test;

public class FactorizerTest {

  @Test
  public void factorizations_smallestPrime() {
    assertThat(Factorizer.factorizations(2))
        .containsExactly(ImmutableMultiset.of(2L));
  }

  @Test
  public void factorizations_secondSmallestPrime() {
    assertThat(Factorizer.factorizations(3))
        .containsExactly(ImmutableMultiset.of(3L));
  }

  @Test
  public void factorizations_squaredPrime() {
    assertThat(Factorizer.factorizations(2 * 2))
        .containsExactly(
            ImmutableMultiset.of(2L, 2L),
            ImmutableMultiset.of(4L));
  }

  @Test
  public void factorizations_cubedPrime() {
    assertThat(Factorizer.factorizations(3 * 3 * 3))
        .containsExactly(
            ImmutableMultiset.of(3L, 3L, 3L),
            ImmutableMultiset.of(3L, 9L),
            ImmutableMultiset.of(27L));
  }

  @Test
  public void factorizations_productOfTwoPrimes() {
    assertThat(Factorizer.factorizations(2 * 3))
        .containsExactly(
            ImmutableMultiset.of(2L, 3L),
            ImmutableMultiset.of(6L));
  }

  @Test
  public void factorizations_productOfThreePrimes() {
    assertThat(Factorizer.factorizations(2 * 3 * 5))
        .containsExactly(
            ImmutableMultiset.of(2L, 3L, 5L),
            ImmutableMultiset.of(2L, 15L),
            ImmutableMultiset.of(3L, 10L),
            ImmutableMultiset.of(5L, 6L),
            ImmutableMultiset.of(30L));
  }

  @Test
  public void factorizations_productOfSquaredPrimeAndPrime() {
    assertThat(Factorizer.factorizations(2 * 2 * 3))
        .containsExactly(
            ImmutableMultiset.of(2L, 2L, 3L),
            ImmutableMultiset.of(2L, 6L),
            ImmutableMultiset.of(3L, 4L),
            ImmutableMultiset.of(12L));
  }

  @Test
  public void factorizations_productOfPrimeAndSquaredPrime() {
    assertThat(Factorizer.factorizations(2 * 3 * 3))
        .containsExactly(
            ImmutableMultiset.of(2L, 3L, 3L),
            ImmutableMultiset.of(2L, 9L),
            ImmutableMultiset.of(3L, 6L),
            ImmutableMultiset.of(18L));
  }

  @Test
  public void factorizations_productOfPrimeAndCubedPrime() {
    assertThat(Factorizer.factorizations(2 * 2 * 2 * 3))
        .containsExactly(
            ImmutableMultiset.of(2L, 2L, 2L, 3L),
            ImmutableMultiset.of(2L, 2L, 6L),
            ImmutableMultiset.of(2L, 4L, 3L),
            ImmutableMultiset.of(2L, 12L),
            ImmutableMultiset.of(4L, 6L),
            ImmutableMultiset.of(8L, 3L),
            ImmutableMultiset.of(24L));
  }

  @Test
  public void factorizations_productOfTwoSquaredPrimes() {
    assertThat(Factorizer.factorizations(2 * 2 * 3 * 3))
        .containsExactly(
            ImmutableMultiset.of(2L, 2L, 3L, 3L),
            ImmutableMultiset.of(2L, 2L, 9L),
            ImmutableMultiset.of(2L, 3L, 6L),
            ImmutableMultiset.of(2L, 18L),
            ImmutableMultiset.of(4L, 3L, 3L),
            ImmutableMultiset.of(4L, 9L),
            ImmutableMultiset.of(3L, 12L),
            ImmutableMultiset.of(6L, 6L),
            ImmutableMultiset.of(36L));
  }

  @Test
  public void factorizations_productOfCubedAndSquaredPrimes() {
    assertThat(Factorizer.factorizations(2 * 2 * 2 * 3 * 3))
        .containsExactly(
            ImmutableMultiset.of(2L, 2L, 2L, 3L, 3L),
            ImmutableMultiset.of(2L, 2L, 2L, 9L),
            ImmutableMultiset.of(2L, 2L, 3L, 6L),
            ImmutableMultiset.of(2L, 4L, 3L, 3L),
            ImmutableMultiset.of(2L, 2L, 18L),
            ImmutableMultiset.of(2L, 3L, 12L),
            ImmutableMultiset.of(2L, 4L, 9L),
            ImmutableMultiset.of(2L, 6L, 6L),
            ImmutableMultiset.of(4L, 3L, 6L),
            ImmutableMultiset.of(8L, 3L, 3L),
            ImmutableMultiset.of(2L, 36L),
            ImmutableMultiset.of(3L, 24L),
            ImmutableMultiset.of(4L, 18L),
            ImmutableMultiset.of(6L, 12L),
            ImmutableMultiset.of(8L, 9L),
            ImmutableMultiset.of(72L));
  }
}
