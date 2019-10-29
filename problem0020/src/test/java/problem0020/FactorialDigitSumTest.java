package problem0020;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FactorialDigitSumTest {

  @Test
  public void compute_simple() {
    assertThat(FactorialDigitSum.compute(2), is(2L));
  }

  @Test
  public void compute_severalDigits() {
    assertThat(FactorialDigitSum.compute(10), is(27L));
  }
}
