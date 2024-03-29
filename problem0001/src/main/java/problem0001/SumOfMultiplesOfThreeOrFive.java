package problem0001;

/**
 * Multiples of 3 and 5
 * <p>
 * Problem 1
 * <p>
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
class SumOfMultiplesOfThreeOrFive {

  public static int compute(final int rightBoundary) {
    assert rightBoundary >= 0;

    int result = 0;

    for (int i = 0; i < rightBoundary; i++) {
      if ((i % 3 == 0) || (i % 5 == 0)) {
        result += i;
      }
    }

    assert result >= 0;
    return result;
  }
}
