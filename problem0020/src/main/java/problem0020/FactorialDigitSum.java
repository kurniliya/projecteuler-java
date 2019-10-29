package problem0020;

import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import utils.NumUtils;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * <p>
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p>
 * Find the sum of the digits in the number 100!
 */
public class FactorialDigitSum {

  static long compute(final int n) {
    final BigInteger factorial = BigIntegerMath.factorial(n);
    final ArrayList<Integer> digits = NumUtils.digits(factorial);

    return digits.stream().reduce(0, Integer::sum);
  }
}
