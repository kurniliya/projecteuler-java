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
  public void countResilientFractions_11() {
    assertThat(Resilience.countResilientFractions(11), is(10L));
  }

  @Test
  public void countResilientFractions_30() {
    assertThat(Resilience.countResilientFractions(30), is(8L));
  }

  @Test
  public void countResilientFractions_997() {
    assertThat(Resilience.countResilientFractions(997), is(996L));
  }

  @Test
  public void smallestDenominatorWithResilienceLessThan_4_10() {
    assertThat(Resilience.smallestDenominatorWithResilienceLessThan(4, 10),
        is(12L));
  }
}
