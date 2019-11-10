package utils;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class NumUtilsTest {

  @Test
  public void testFactorsPrimeNumber() {
    ArrayList<Long> result = NumUtils.factors(5);
    assertThat(result, hasItems(1L, 5L));
    assertThat(result.size(), is(2));
  }

  @Test
  public void testFactorsSquareNumber() {
    ArrayList<Long> result = NumUtils.factors(9);
    assertThat(result, hasItems(1L, 3L, 9L));
    assertThat(result.size(), is(3));
  }

  @Test
  public void testFactorsMultiplePrimes() {
    ArrayList<Long> result = NumUtils.factors(30);
    assertThat(result, hasItems(1L, 2L, 3L, 5L, 6L, 10L, 15L, 30L));
    assertThat(result.size(), is(8));
  }

  @Test
  public void testFactorsRepeatedPrimes() {
    ArrayList<Long> result = NumUtils.factors(220);
    assertThat(result,
        hasItems(1L, 2L, 4L, 5L, 10L, 11L, 20L, 22L, 44L, 55L, 110L, 220L));
    assertThat(result.size(), is(12));
  }

  @Test
  public void testDigits1() {
    assertThat(NumUtils.digits(1), is(Collections.singletonList(1)));
  }

  @Test
  public void testDigits20() {
    assertThat(NumUtils.digits(20), is(Arrays.asList(0, 2)));
  }

  @Test
  public void testDigitsBigInteger23() {
    assertThat(NumUtils.digits(BigInteger.valueOf(23)),
        is(Arrays.asList(3, 2)));
  }

  @Test
  public void testIsPalindromeSmallestInput() {
    assertThat(NumUtils.isPalindrome(1), is(true));
  }

  @Test
  public void testIsPalindromeTwoDigits() {
    assertThat(NumUtils.isPalindrome(23), is(false));
  }

  @Test
  public void testIsPalindromeThreeDigits() {
    assertThat(NumUtils.isPalindrome(323), is(true));
  }

  @Test
  public void testIsPalindromeFourDigits() {
    assertThat(NumUtils.isPalindrome(9009), is(true));
  }

  @Test
  public void testIsPrime1() {
    assertThat(NumUtils.isPrime(1), is(false));
  }

  @Test
  public void testIsPrime2() {
    assertThat(NumUtils.isPrime(2), is(true));
  }

  @Test
  public void testIsPrime3() {
    assertThat(NumUtils.isPrime(3), is(true));
  }

  @Test
  public void testIsPrime4() {
    assertThat(NumUtils.isPrime(4), is(false));
  }

  @Test
  public void testIsPrime5() {
    assertThat(NumUtils.isPrime(5), is(true));
  }

  @Test
  public void testIsPrime953() {
    assertThat(NumUtils.isPrime(953), is(true));
  }
}
