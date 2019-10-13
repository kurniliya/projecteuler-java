package problem0001;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SumOfMultiplesOfThreeOrFiveTest {

  @Parameterized.Parameters(name = "{index}: f({0})={1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
            { 3, 0 },
            { 4, 3 },
            { 6, 8 },
            { 10, 23 }
    });
  }

  private int input;
  private int expected;

  public SumOfMultiplesOfThreeOrFiveTest(int input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void testCompute() {
    assertEquals(expected, SumOfMultiplesOfThreeOrFive.compute(input));
  }
}
