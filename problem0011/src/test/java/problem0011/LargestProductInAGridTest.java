package problem0011;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LargestProductInAGridTest {

  @Test
  public void single_element_subset() {
    final long[][] matrix = {
        {3L, 2L},
        {4L, 1L}
    };
    assertThat(LargestProductInAGrid.compute(matrix, 2, 1), is(4L));
  }

  @Test
  public void max_product_is_in_horizontal_direction() {
    final long[][] matrix = {
        {1L, 2L},
        {3L, 4L}
    };
    assertThat(LargestProductInAGrid.compute(matrix, 2, 2), is(12L));
  }

  @Test
  public void max_product_is_in_vertical_direction() {
    final long[][] matrix = {
        {1L, 3L},
        {2L, 4L}
    };
    assertThat(LargestProductInAGrid.compute(matrix, 2, 2), is(12L));
  }

  @Test
  public void max_product_is_in_north_east_direction() {
    final long[][] matrix = {
        {1L, 3L},
        {4L, 2L}
    };
    assertThat(LargestProductInAGrid.compute(matrix, 2, 2), is(12L));
  }

  @Test
  public void max_product_is_in_south_east_direction() {
    final long[][] matrix = {
        {4L, 1L},
        {2L, 3L}
    };
    assertThat(LargestProductInAGrid.compute(matrix, 2, 2), is(12L));
  }
}
