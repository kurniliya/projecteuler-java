package problem0004;

import utils.NumUtils;

/**
 * Largest palindrome product
 * <p>
 * Problem 4
 * <p>
 * A palindromic number reads the same both ways. The largest palindrome made from the product of
 * two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
class LargestPalindromeProduct {

  /**
   * @param minFactor Start of the range.
   * @param maxFactor End of the range.
   * @return -1 if no palindrome was found.
   */
  int compute(final int minFactor, final int maxFactor) {
    for (int product : ProductGenerator.generate(minFactor, maxFactor)) {
      if (NumUtils.isPalindrome(product)) {
        return product;
      }
    }

    return -1;
  }
}
