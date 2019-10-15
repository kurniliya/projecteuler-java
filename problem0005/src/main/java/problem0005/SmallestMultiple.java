package problem0005;

/**
 * Smallest multiple
 * <p>
 * Problem 5
 * <p>
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 */
class SmallestMultiple {

  public static int compute(final int maxDivisor) {
    assert maxDivisor >= 1;

    for (int testValue = maxDivisor; ; testValue++) {
      for (int j = maxDivisor; j >= 1; j--) {
        if (j == 1) {
          assert testValue >= maxDivisor;
          return testValue;
        }
        if (testValue % j != 0) {
          break;
        }
      }
    }
  }
}
