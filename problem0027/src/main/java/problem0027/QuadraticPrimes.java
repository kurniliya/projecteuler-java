package problem0027;

import static com.google.common.base.Preconditions.checkArgument;

import utils.NumUtils;

/**
 * <h1>Quadratic primes</h1>
 * <h2>Problem 27</h2>
 * Euler discovered the remarkable quadratic formula:
 * <p>
 * n²+n+41
 * <p>
 * It turns out that the formula will produce 40 primes for the consecutive
 * integer values 0≤n≤39. However, when n=40,40²+40+41=40(40+1)+41 is divisible
 * by 41, and certainly when n=41,41²+41+41 is clearly divisible by 41.
 * <p>
 * The incredible formula n²−79n+1601 was discovered, which produces 80 primes
 * for the consecutive values 0≤n≤79. The product of the coefficients, −79 and
 * 1601, is −126479.
 * <p>
 * Considering quadratics of the form:
 * <p>
 * n²+an+b, where |a|<1000 and |b|≤1000
 * <p>
 * where |n| is the modulus/absolute value of n e.g. |11|=11 and |−4|=4
 * <p>
 * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n=0.
 */
class QuadraticPrimes {

  static long compute(final long minLinear, final long maxLinear,
      final long minConst, final long maxConst) {
    checkArgument(minLinear <= maxLinear);
    checkArgument(minConst <= maxConst);

    long maxConsecutivePrimes = 0;
    long result = 0;
    for (long linear = minLinear; linear <= maxLinear; ++linear) {
      for (long constant = minConst; constant <= maxConst; ++constant) {
        final long consecutivePrimesCount = countConsecutivePrimes(linear,
            constant);
        if (consecutivePrimesCount > maxConsecutivePrimes) {
          maxConsecutivePrimes = consecutivePrimesCount;
          result = linear * constant;
        }
      }
    }

    return result;
  }

  static long countConsecutivePrimes(final long linear, final long constant) {
    long result = 0;
    long n = 0;
    while (NumUtils.isPrime(quadratic(linear, constant, n++))) {
      result++;
    }

    return result;
  }

  private static long quadratic(final long linear, final long constant,
      final long n) {
    return n * n + linear * n + constant;
  }
}
