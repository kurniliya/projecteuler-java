package problem0011;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import org.junit.Test;

public class LargestProductInAGridTest {

  @Test
  public void single_element_subset() {
    final ArrayList<ArrayList<Long>> matrix = Lists.newArrayList(
        Lists.newArrayList(3L, 2L),
        Lists.newArrayList(4L, 1L)
    );

    assertThat(LargestProductInAGrid.compute(matrix, 1), is(4L));
  }

  @Test
  public void max_product_is_in_horizontal_direction() {
    final ArrayList<ArrayList<Long>> matrix = Lists.newArrayList(
        Lists.newArrayList(1L, 2L),
        Lists.newArrayList(3L, 4L)
    );

    assertThat(LargestProductInAGrid.compute(matrix, 2), is(12L));
  }

  @Test
  public void max_product_is_in_vertical_direction() {
    final ArrayList<ArrayList<Long>> matrix = Lists.newArrayList(
        Lists.newArrayList(1L, 3L),
        Lists.newArrayList(2L, 4L)
    );

    assertThat(LargestProductInAGrid.compute(matrix, 2), is(12L));
  }

  @Test
  public void max_product_is_in_north_east_direction() {
    final ArrayList<ArrayList<Long>> matrix = Lists.newArrayList(
        Lists.newArrayList(1L, 3L),
        Lists.newArrayList(4L, 2L)
    );

    assertThat(LargestProductInAGrid.compute(matrix, 2), is(12L));
  }

  @Test
  public void max_product_is_in_south_east_direction() {
    final ArrayList<ArrayList<Long>> matrix = Lists.newArrayList(
        Lists.newArrayList(4L, 1L),
        Lists.newArrayList(2L, 3L)
    );

    assertThat(LargestProductInAGrid.compute(matrix, 2), is(12L));
  }
}
