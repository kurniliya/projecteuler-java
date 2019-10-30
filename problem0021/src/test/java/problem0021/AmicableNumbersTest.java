package problem0021;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AmicableNumbersTest {

  @Test
  public void computeFirstPerfectNumber() {
    assertThat(AmicableNumbers.compute(6), is(0L));
  }

  @Test
  public void computeFirstAmicableNumber() {
    assertThat(AmicableNumbers.compute(220), is(220L));
  }

  @Test
  public void sumOfProperDivisors() {
    assertThat(AmicableNumbers.sumOfProperDivisors(284), is(220L));
  }
}
