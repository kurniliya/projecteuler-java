/*
 * Multiples of 3 and 5
 * Problem 1
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 *  we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
package problem0001;

public class App {

  public static void main(String[] args) {
    final int MAX_VALUE = 1_000;
    final int sum = SumOfMultiplesOfThreeOrFive.compute(MAX_VALUE);

    System.out.println(sum);
  }
}
