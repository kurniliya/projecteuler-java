package problem0027;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QuadraticPrimesTest {

  @Test
  public void compute_1_1_41_41() {
    assertThat(QuadraticPrimes.compute(1, 1, 41, 41), is(41L));
  }

  @Test
  public void countConsecutivePrimes_1_41() {
    assertThat(QuadraticPrimes.countConsecutivePrimes(1, 41), is(40L));
  }

  @Test
  public void countConsecutivePrimes_minus_79_1601() {
    assertThat(QuadraticPrimes.countConsecutivePrimes(-79, 1601), is(80L));
  }
}
