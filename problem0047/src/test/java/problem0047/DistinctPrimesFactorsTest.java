package problem0047;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DistinctPrimesFactorsTest {

  @Test
  public void compute_two_consecutive_numbers_with_two_distinct_factors() {
    assertThat(DistinctPrimesFactors.compute(2, 2), is(14L));
  }

  @Test
  public void compute_three_consecutive_numbers_with_three_distinct_factors() {
    assertThat(DistinctPrimesFactors.compute(3, 3), is(644L));
  }
}
