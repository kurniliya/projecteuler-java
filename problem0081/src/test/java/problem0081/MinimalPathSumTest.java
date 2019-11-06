package problem0081;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MinimalPathSumTest {

  @Test
  public void compute_2x2_down_then_right() {
    final long[][] triangle = {
        {1, 100},
        {90, 20}
    };
    assertThat(MinimalPathSum.compute(triangle), is(111L));
  }

  @Test
  public void compute_2x2_right_then_down() {
    final long[][] triangle = {
        {1, 90},
        {100, 20}
    };
    assertThat(MinimalPathSum.compute(triangle), is(111L));
  }

  @Test
  public void compute_3x3_down_then_right_then_down_then_right() {
    final long[][] triangle = {
        {10, 40, 30},
        {20, 50, 80},
        {70, 60, 90},
    };
    assertThat(MinimalPathSum.compute(triangle), is(230L));
  }

  @Test
  public void compute_demo_example() {
    final long[][] triangle = {
        {131, 673, 234, 103, 18},
        {201, 96, 342, 965, 150},
        {630, 803, 746, 422, 111},
        {537, 699, 497, 121, 956},
        {805, 732, 524, 37, 331}
    };
    assertThat(MinimalPathSum.compute(triangle), is(2427L));
  }
}
