package problem0006;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SumSquareDifferenceTest {

  private int input;
  private int expected;

  public SumSquareDifferenceTest(int input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters(name = "{index}: f({0})={1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {10, 2640},
    });
  }

  @Test
  public void testCompute() {
    assertEquals(expected, SumSquareDifference.compute(input));
  }
}
