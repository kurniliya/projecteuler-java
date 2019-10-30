package problem0243;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ResilienceTest {

  @Test
  public void countResilientFractions_complex_number_with_two_prime_factors() {
    assertThat(Resilience.countResilientFractions(12), is(4L));
  }

  @Test
  public void countResilientFractions_complex_number_with_three_prime_factors() {
    assertThat(Resilience.countResilientFractions(30), is(8L));
  }

  @Test
  public void countResilientFractions_complex_number_with_four_prime_factors() {
    assertThat(Resilience.countResilientFractions(210), is(48L));
  }

  @Test
  public void countResilientFractions_prime() {
    assertThat(Resilience.countResilientFractions(11), is(10L));
  }

  @Test
  public void countResilientFractions_prime_squared() {
    assertThat(Resilience.countResilientFractions(9), is(6L));
  }

  @Test
  public void countResilientFractions_large_prime() {
    assertThat(Resilience.countResilientFractions(997), is(996L));
  }

  @Test
  public void smallestDenominatorWithResilienceLessThan_4_10() {
    assertThat(Resilience.smallestDenominatorWithResilienceLessThan(4, 10),
        is(12L));
  }
}
