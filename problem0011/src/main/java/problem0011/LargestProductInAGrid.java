package problem0011;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;

/**
 * Largest product in a grid
 * <p>
 * Problem 11
 * <p>
 * In the 20×20 grid below, four numbers along a diagonal line have been marked
 * in red.
 * <p>
 * ...the grid is omitted...
 * <p>
 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
 * <p>
 * What is the greatest product of four adjacent numbers in the same direction
 * (up, down, left, right, or diagonally) in the 20×20 grid?
 */
public class LargestProductInAGrid {

  static long compute(final ArrayList<ArrayList<Long>> matrix,
      final int subsetSize) {
    checkNotNull(matrix);
    checkArgument(subsetSize > 0);

    final int rowsCount = matrix.size();
    final int colsCount = matrix.get(1).size();
    checkArgument(subsetSize <= rowsCount);
    checkArgument(subsetSize <= colsCount);

    long result = Long.MIN_VALUE;

    result = Math.max(result,
        maxDiagonalNorthEast(matrix, rowsCount, colsCount, subsetSize));
    result = Math.max(result,
        maxDiagonalSouthEast(matrix, rowsCount, colsCount, subsetSize));
    result = Math
        .max(result, maxHorizontal(matrix, rowsCount, colsCount, subsetSize));
    result = Math
        .max(result, maxVertical(matrix, rowsCount, colsCount, subsetSize));

    return result;
  }

  private static long maxDiagonalNorthEast(
      final ArrayList<ArrayList<Long>> matrix,
      final int numRows,
      final int numCols,
      final int subsetSize) {
    long result = Long.MIN_VALUE;

    for (int startRow = subsetSize - 1; startRow < numRows; ++startRow) {
      for (int startCol = 0; startCol < numCols - subsetSize + 1; ++startCol) {
        long product = 1;
        for (int i = 0; i < subsetSize; i++) {
          product *= matrix.get(startRow - i).get(startCol + i);
        }
        result = Math.max(result, product);
      }
    }

    return result;
  }

  private static long maxDiagonalSouthEast(
      final ArrayList<ArrayList<Long>> matrix,
      final int numRows,
      final int numCols,
      final int subsetSize) {
    long result = Long.MIN_VALUE;

    for (int startRow = 0; startRow < numRows - subsetSize + 1; ++startRow) {
      for (int startCol = 0; startCol < numCols - subsetSize + 1; ++startCol) {
        long product = 1;
        for (int i = 0; i < subsetSize; i++) {
          product *= matrix.get(startRow + i).get(startCol + i);
        }
        result = Math.max(result, product);
      }
    }

    return result;
  }

  private static long maxHorizontal(final ArrayList<ArrayList<Long>> matrix,
      final int numRows,
      final int numCols,
      final int subsetSize) {
    long result = Long.MIN_VALUE;

    for (int startRow = 0; startRow < numRows; ++startRow) {
      for (int startCol = 0; startCol < numCols - subsetSize + 1; ++startCol) {
        long product = 1;
        for (int i = 0; i < subsetSize; i++) {
          product *= matrix.get(startRow).get(startCol + i);
        }
        result = Math.max(result, product);
      }
    }

    return result;
  }

  private static long maxVertical(final ArrayList<ArrayList<Long>> matrix,
      final int numRows,
      final int numCols,
      final int subsetSize) {
    long result = Long.MIN_VALUE;

    for (int startCol = 0; startCol < numCols; ++startCol) {
      for (int startRow = 0; startRow < numRows - subsetSize + 1; ++startRow) {
        long product = 1;
        for (int i = 0; i < subsetSize; i++) {
          product *= matrix.get(startRow + i).get(startCol);
        }
        result = Math.max(result, product);
      }
    }

    return result;
  }

}
