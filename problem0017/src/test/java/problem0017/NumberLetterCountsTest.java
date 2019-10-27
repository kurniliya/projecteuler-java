package problem0017;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NumberLetterCountsTest {

  @Test
  public void asNumeral_1() {
    assertThat(NumberLetterCounts.asNumeral(1).toString(), is("one"));
  }

  @Test
  public void asNumeral_11() {
    assertThat(NumberLetterCounts.asNumeral(11).toString(), is("eleven"));
  }

  @Test
  public void asNumeral_19() {
    assertThat(NumberLetterCounts.asNumeral(19).toString(), is("nineteen"));
  }

  @Test
  public void asNumeral_20() {
    assertThat(NumberLetterCounts.asNumeral(20).toString(), is("twenty"));
  }

  @Test
  public void asNumeral_21() {
    assertThat(NumberLetterCounts.asNumeral(21).toString(), is("twenty-one"));
  }

  @Test
  public void asNumeral_99() {
    assertThat(NumberLetterCounts.asNumeral(99).toString(), is("ninety-nine"));
  }

  @Test
  public void asNumeral_100() {
    assertThat(NumberLetterCounts.asNumeral(100).toString(), is("one hundred"));
  }

  @Test
  public void asNumeral_999() {
    assertThat(NumberLetterCounts.asNumeral(999).toString(),
        is("nine hundred and ninety-nine"));
  }

  @Test
  public void asNumeral_1000() {
    assertThat(NumberLetterCounts.asNumeral(1_000).toString(),
        is("one thousand"));
  }

  @Test
  public void compute_1() {
    assertThat(NumberLetterCounts.compute(1), is(3));
  }
}
