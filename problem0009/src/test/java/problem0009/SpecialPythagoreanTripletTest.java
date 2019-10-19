package problem0009;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpecialPythagoreanTripletTest {

  @Test
  public void test_demonstrated_case() {
    assertThat(SpecialPythagoreanTriplet.compute(12), is(60));
  }

}