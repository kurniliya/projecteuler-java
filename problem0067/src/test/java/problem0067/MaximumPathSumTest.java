package problem0067;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MaximumPathSumTest {

  @Test
  public void compute_one_level() {
    final long[][] triangle = {{5L}};
    assertThat(MaximumPathSum.compute(triangle), is(5L));
  }

  @Test
  public void compute_two_levels_right_path_has_best_score() {
    final long[][] triangle = {{5L}, {3L, 4L}};
    assertThat(MaximumPathSum.compute(triangle), is(9L));
  }

  @Test
  public void compute_two_levels_left_path_has_best_score() {
    final long[][] triangle = {{5L}, {4L, 3L}};
    assertThat(MaximumPathSum.compute(triangle), is(9L));
  }

  @Test
  public void compute_three_levels_right_path_has_best_score() {
    final long[][] triangle = {{5L}, {4L, 3L}, {1L, 2L, 4L}};
    assertThat(MaximumPathSum.compute(triangle), is(12L));
  }

  @Test
  public void compute_three_levels_left_path_has_best_score() {
    final long[][] triangle = {{5L}, {4L, 3L}, {3L, 2L, 1L}};
    assertThat(MaximumPathSum.compute(triangle), is(12L));
  }
}
