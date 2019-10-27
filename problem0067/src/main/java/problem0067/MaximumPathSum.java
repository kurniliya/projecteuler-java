package problem0067;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;

/**
 * <h1>Maximum path sum II</h1>
 * <h2>Problem 67</h2>
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 * <p>
 * 3
 * <p>
 * 7 4
 * <p>
 * 2 4 6
 * <p>
 * 8 5 9 3
 * <p>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p>
 * Find the maximum total from top to bottom in triangle.txt (right click and
 * 'Save Link/Target As...'), a 15K text file containing a triangle with
 * one-hundred rows.
 * <p>
 * NOTE: This is a much more difficult version of Problem 18. It is not possible
 * to try every route to solve this problem, as there are 2<sup>99</sup>
 * altogether! If you could check one trillion (10<sup>12</sup>) routes every
 * second it would take over twenty billion years to check them all. There is an
 * efficient algorithm to solve it. ;o)
 */
public class MaximumPathSum {

  static long compute(final long[][] triangle) {
    checkNotNull(triangle);
    checkArgument(triangle.length > 0);

    final long[] score = new long[triangle.length];
    score[0] = triangle[0][0];

    for (int level = 1; level < triangle.length; ++level) {
      for (int i = level; i >= 0; --i) {
        final long leftParentScore = (i - 1) >= 0 ? score[i - 1] : 0;
        final long rightParentScore = score[i];
        score[i] =
            triangle[level][i] + Math.max(leftParentScore, rightParentScore);
      }
    }

    return Arrays.stream(score).max().getAsLong();
  }
}
