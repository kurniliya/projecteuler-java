package problem0004;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LargestPalindromeProductTest {

  private LargestPalindromeProduct calculator = new LargestPalindromeProduct();
  private int expected;
  private int arg1;
  private int arg2;

  public LargestPalindromeProductTest(final int arg1, final int arg2, final int expected) {
    this.arg1 = arg1;
    this.arg2 = arg2;
    this.expected = expected;
  }

  @Parameterized.Parameters(name = "{index}: f({0}, {1})={2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {1, 9, 9},
        {1, 12, 121},
        {10, 99, 9009},
    });
  }

  @Test
  public void testCompute() {
    assertEquals(expected, calculator.compute(arg1, arg2));
  }
}
