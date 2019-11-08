package utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.Lists;
import org.junit.Test;

public class PrimeFactorizationTest {

  @Test
  public void test_first_prime_number() {
    assertThat(PrimeFactorization.of(2).factors(),
        is(Lists.newArrayList(PrimeFactor.of(2, 1))));
  }

  @Test
  public void test_second_prime_number() {
    assertThat(PrimeFactorization.of(3).factors(),
        is(Lists.newArrayList(PrimeFactor.of(3, 1))));
  }

  @Test
  public void test_composite_number() {
    assertThat(PrimeFactorization.of(4).factors(),
        is(Lists.newArrayList(PrimeFactor.of(2, 2))));
  }

  @Test
  public void test_composite_number_with_several_factors() {
    assertThat(PrimeFactorization.of(28).factors(),
        is(Lists.newArrayList(
            PrimeFactor.of(2, 2),
            PrimeFactor.of(7, 1))));
  }

  @Test
  public void test_composite_number_with_several_factors_and_powers() {
    assertThat(PrimeFactorization.of(72).factors(),
        is(Lists.newArrayList(
            PrimeFactor.of(2, 3),
            PrimeFactor.of(3, 2))));
  }

  @Test
  public void test_composite_number_with_three_factors() {
    assertThat(PrimeFactorization.of(220).factors(),
        is(Lists.newArrayList(
            PrimeFactor.of(2, 2),
            PrimeFactor.of(5, 1),
            PrimeFactor.of(11, 1))));
  }
}
