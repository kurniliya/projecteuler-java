package problem0243;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ResilienceTest {

  @Test
  public void countResilientFractions_12() {
    assertThat(Resilience.countResilientFractions(12), is(4L));
  }

  @Test
  public void smallestDenominatorWithResilienceLessThan_4_10() {
    assertThat(Resilience.smallestDenominatorWithResilienceLessThan(4, 10),
        is(12L));
  }
}
