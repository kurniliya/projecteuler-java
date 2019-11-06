package problem0081;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * <h1>Path sum: two ways</h1>
 * In the 5 by 5 matrix below, the minimal path sum from the top left to the
 * bottom right, by only moving to the right and down, is indicated in bold red
 * and is equal to 2427.
 * <p>
 * <matrix skipped>
 * <p>
 * Find the minimal path sum, in matrix.txt (right click and "Save Link/Target
 * As..."), a 31K text file containing a 80 by 80 matrix, from the top left to
 * the bottom right by only moving right and down.
 */
public class MinimalPathSum {

  static long compute(final long[][] matrix) {
    checkNotNull(matrix);
    checkArgument(matrix.length > 0);

    final int size = matrix.length;
    final long[] score = new long[size];

    score[0] = matrix[0][0];
    for (int col = 1; col < size; ++col) {
      score[col] = score[col - 1] + matrix[0][col];
    }

    for (int row = 1; row < size; ++row) {
      score[0] += matrix[row][0];
      for (int col = 1; col < size; ++col) {
        final long leftParentScore = score[col - 1];
        final long upperParentScore = score[col];
        score[col] =
            matrix[row][col] + Math.min(leftParentScore, upperParentScore);
      }
    }

    return score[size - 1];
  }
}
