package problem0012;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class HighlyDivisibleTriangularNumberTest {

  @Test
  public void compute_demo_case_4() {
    assertThat(HighlyDivisibleTriangularNumber.compute(4), is(6L));
  }

  @Test
  public void compute_demo_case_5() {
    assertThat(HighlyDivisibleTriangularNumber.compute(5), is(28L));
  }

  @Test
  public void countDivisors_of_3() {
    assertThat(HighlyDivisibleTriangularNumber.countDivisors(3), is(2L));
  }

  @Test
  public void countDivisors_of_4() {
    assertThat(HighlyDivisibleTriangularNumber.countDivisors(4), is(3L));
  }

  @Test
  public void countDivisors_of_21() {
    assertThat(HighlyDivisibleTriangularNumber.countDivisors(21), is(4L));
  }

  @Test
  public void countDivisors_of_28() {
    assertThat(HighlyDivisibleTriangularNumber.countDivisors(28), is(6L));
  }
}
