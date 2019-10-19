package problem0009;

/**
 * Special Pythagorean triplet
 * <p>
 * Problem 9
 * <p>
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a^2 + b^2 = c2
 * <p>
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 */
class SpecialPythagoreanTriplet {

  static int compute(final int sumOfNumbers) {
    for (int a = 1; a < sumOfNumbers; a++) {
      for (int b = a; a + b < sumOfNumbers; b++) {
        final int c = sumOfNumbers - a - b;
        if (a * a + b * b == c * c) {
          return a * b * c;
        }
      }
    }
    return -1;
  }
}
