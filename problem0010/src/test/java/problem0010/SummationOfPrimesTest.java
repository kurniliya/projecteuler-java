package problem0010;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SummationOfPrimesTest {

  @Test
  public void test_no_primes() {
    assertThat(SummationOfPrimes.compute(0), is(0L));
  }

  @Test
  public void test_first_prime() {
    assertThat(SummationOfPrimes.compute(3), is(2L));
  }

  @Test
  public void test_first_two_primes() {
    assertThat(SummationOfPrimes.compute(4), is(5L));
  }

  @Test
  public void test_demonstrated_case() {
    assertThat(SummationOfPrimes.compute(10), is(17L));
  }

  @Test
  public void test_integer_overflow() {
    assertThat(SummationOfPrimes.compute(1_000_000), is(37550402023L));
  }
}