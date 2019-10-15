package utils;

import static org.junit.Assert.assertEquals;

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

  @RunWith(Parameterized.class)
  public static class DigitsTest {

    private List<Integer> expected;
    private int arg1;

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

        private boolean expected;
        private int arg1;

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
}