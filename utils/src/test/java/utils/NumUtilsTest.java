package utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Enclosed.class)
public class NumUtilsTest {

  public static class BigIntegerDigitsTest {

    @Test
    public void testDigits() {
      assertThat(NumUtils.digits(BigInteger.valueOf(23)),
          is(Arrays.asList(3, 2)));
    }
  }

  @RunWith(Parameterized.class)
  public static class DigitsTest {

    private int arg1;
    private List<Integer> expected;

    public DigitsTest(final int arg1, final List<Integer> expected) {
      this.arg1 = arg1;
      this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: f({0})={1}")
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
          {1, Collections.singletonList(1)},
          {20, Arrays.asList(0, 2)},
      });
    }

    @Test
    public void test() {
      assertEquals(expected, NumUtils.digits(arg1));
    }
  }

  @RunWith(Parameterized.class)
  public static class IsPalindromeTest {

    private int arg1;
    private boolean expected;

    public IsPalindromeTest(final int arg1, final boolean expected) {
      this.arg1 = arg1;
      this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: f({0})={1}")
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
          {1, true},
          {23, false},
          {323, true},
          {9009, true},
      });
    }

    @Test
    public void test() {
      assertEquals(expected, NumUtils.isPalindrome(arg1));
    }
  }

  @RunWith(Parameterized.class)
  public static class IsPrimeTest {

    private int arg1;
    private boolean expected;

    public IsPrimeTest(final int arg1, final boolean expected) {
      this.arg1 = arg1;
      this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: f({0})={1}")
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
          {1, false},
          {2, true},
          {3, true},
          {4, false},
          {5, true},
      });
    }

    @Test
    public void test() {
      assertEquals(expected, NumUtils.isPrime(arg1));
    }
  }
}
