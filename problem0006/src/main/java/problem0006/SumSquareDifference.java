package problem0006;

import java.util.stream.IntStream;

/**
 * Sum square difference
 * <p>
 * Problem 6
 * <p>
 * The sum of the squares of the first ten natural numbers is, 1² + 2² + ... +
 * 10² = 385
 * <p>
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... +
 * 10)² = 552 = 3025
 * <p>
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 */
class SumSquareDifference {

  public static int compute(final int maxNumber) {
    assert maxNumber >= 0;

    final int sumOfNumbers = IntStream
        .rangeClosed(1, maxNumber)
        .sum();
    final int sumOfSquares = IntStream
        .rangeClosed(1, maxNumber)
        .map(i -> i * i)
        .sum();

    final int squaredSum = sumOfNumbers * sumOfNumbers;
    final int result = squaredSum - sumOfSquares;

    assert result >= 0;
    return result;
  }
}
