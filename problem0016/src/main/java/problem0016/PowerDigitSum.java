package problem0016;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Arrays;

/**
 * <h1>Power digit sum</h1>
 * <h2>Problem 16</h2>
 * 2<sup>15</sup> = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * <p>
 * What is the sum of the digits of the number 2<sup>1000</sup>?
 */
public class PowerDigitSum {

  static long compute(final int power) {
    checkArgument(power >= 0);

    long[] digits = new long[power + 1];
    digits[0] = 1;
    int numberOfDigits = 1;

    long step = power;
    while (step-- > 0) {
      long carry = 0;
      for (int digitIndex = 0; digitIndex < numberOfDigits; ++digitIndex) {
        final long newValue = (2 * digits[digitIndex] + carry);
        digits[digitIndex] = newValue % 10;
        carry = newValue / 10;
      }
      if (carry > 0) {
        assert carry == 1 : carry;
        digits[numberOfDigits] = carry;
        numberOfDigits++;
      }
    }

    return Arrays.stream(digits).sum();
  }
}
