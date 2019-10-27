package problem0013;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import utils.InputUtils;

/**
 * <h1>Large sum</h1>
 * <h2>Problem 13</h2>
 * Work out the first ten digits of the sum of the following one-hundred
 * 50-digit numbers.
 */
class LargeSum {

  static BigInteger compute(final File file) throws IOException {
    final BigInteger[] input = InputUtils.readBigIntegerListFromFile(file);

    final BigInteger sum = Arrays.stream(input)
        .reduce(BigInteger.ZERO, BigInteger::add);
    BigInteger tenToTenthPower = BigInteger.valueOf(10_000_000_000L);
    BigInteger firstTenDigits = sum;
    while (firstTenDigits.compareTo(tenToTenthPower) > 0) {
      firstTenDigits = firstTenDigits.divide(BigInteger.TEN);
    }

    return firstTenDigits;
  }
}
