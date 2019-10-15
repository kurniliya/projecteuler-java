package problem0005;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SmallestMultipleTest {

  private int input;
  private int expected;

  public SmallestMultipleTest(int input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters(name = "{index}: f({0})={1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {1, 1},
        {4, 12},
    });
  }

  @Test
  public void testCompute() {
    assertEquals(expected, SmallestMultiple.compute(input));
  }
}
