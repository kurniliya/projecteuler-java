package problem0019;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import org.junit.Test;

public class CountingSundaysTest {

  @Test
  public void compute_same_date_non_sunday() {
    final LocalDate start = LocalDate.of(1900, 1, 1);
    assertThat(CountingSundays.compute(start, start), is(0L));
  }

  @Test
  public void compute_1900_before_first_sunday_the_first() {
    final LocalDate start = LocalDate.of(1900, 1, 1);
    final LocalDate end = LocalDate.of(1900, 3, 31);
    assertThat(CountingSundays.compute(start, end), is(0L));
  }

  @Test
  public void compute_1900_exactly_first_sunday_the_first() {
    final LocalDate start = LocalDate.of(1900, 1, 1);
    final LocalDate end = LocalDate.of(1900, 4, 1);
    assertThat(CountingSundays.compute(start, end), is(1L));
  }

  @Test
  public void compute_1900_whole_year() {
    final LocalDate start = LocalDate.of(1900, 1, 1);
    final LocalDate end = LocalDate.of(1900, 12, 31);
    assertThat(CountingSundays.compute(start, end), is(2L));
  }
}
