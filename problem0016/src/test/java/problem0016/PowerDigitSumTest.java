package problem0016;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PowerDigitSumTest {

  @Test
  public void smallest_input() {
    assertThat(PowerDigitSum.compute(0), is(1L));
  }

  @Test
  public void one_digit_in_result() {
    assertThat(PowerDigitSum.compute(2), is(4L));
  }

  @Test
  public void two_digits_in_result() {
    assertThat(PowerDigitSum.compute(4), is(7L));
  }

  @Test
  public void three_digits_in_result() {
    assertThat(PowerDigitSum.compute(7), is(11L));
  }

  @Test
  public void demoed_case() {
    assertThat(PowerDigitSum.compute(15), is(26L));
  }
}
