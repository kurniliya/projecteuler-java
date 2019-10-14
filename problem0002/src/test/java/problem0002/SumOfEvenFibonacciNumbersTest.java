package problem0002;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SumOfEvenFibonacciNumbersTest {

  private SumOfEvenFibonacciNumbers calculator = new SumOfEvenFibonacciNumbers();
  private int expected;
  private int input;

  public SumOfEvenFibonacciNumbersTest(int input, int expected) {
    this.expected = expected;
    this.input = input;
  }

  @Parameterized.Parameters(name = "{index}: f({0})={1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {1, 0},
        {2, 2},
        {100, 44},
    });
  }

  @Test
  public void testCompute() {
    assertEquals(expected, calculator.compute(input));
  }
}
