package problem0091;

import java.util.Objects;

/**
 * Right triangles with integer coordinates
 * <p>
 * Problem 91
 * <p>
 * The points P (x1, y1) and Q (x2, y2) are plotted at integer co-ordinates and
 * are joined to the origin, O(0,0), to form ΔOPQ.
 * <p>
 * ...picture omitted...
 * <p>
 * There are exactly fourteen triangles containing a right angle that can be
 * formed when each co-ordinate lies between 0 and 2 inclusive; that is, 0 ≤ x1,
 * y1, x2, y2 ≤ 2.
 * <p>
 * ...picture omitted...
 * <p>
 * Given that 0 ≤ x1, y1, x2, y2 ≤ 50, how many right triangles can be formed?
 */
class RightTrianglesWithIntegerCoordinates {

  public static int compute(final int maxCoordinate) {
    assert maxCoordinate >= 1;

    int result = 0;

    // P (x1, y1) iterates over whole space.
    for (int x1 = 0; x1 <= maxCoordinate; x1++) {
      for (int y1 = 0; y1 <= maxCoordinate; y1++) {
        // Q (x2, y2) iterates over whole space.
        for (int x2 = 0; x2 <= maxCoordinate; x2++) {
          for (int y2 = 0; y2 <= maxCoordinate; y2++) {
            final Vector p = new Vector(x1, y1);
            final Vector q = new Vector(x2, y2);

            if (formRightTriangle(p, q)) {
              result += 1;
            }
          }
        }
      }
    }

    // Account for the fact that the implementation considers equivalent
    // permutations -- e.g. {(0, 1), (1, 0)} and {(1, 0), (0, 1)} -- twice,
    // as both P and Q iterate over whole space.
    //
    // Alternative would be iterating more carefully to avoid generating
    // equivalent cases twice in the first place. Such approach would make
    // for more complex iteration logic. Performance of the chosen version is
    // good enough for final problem set, so complication isn't warranted.
    assert result % 2 == 0 : result;
    result /= 2;

    return result;
  }

  private static boolean formRightTriangle(final Vector a, final Vector b) {
    if (a.isParallelTo(b)) {
      return false;
    }

    final Vector c = a.minus(b);
    return a.isOrthogonalTo(b) || a.isOrthogonalTo(c) || b.isOrthogonalTo(c);
  }

  private static class Vector {

    final int x;
    final int y;

    Vector(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    int crossProduct(final Vector other) {
      return this.x * other.y - this.y * other.x;
    }

    int dotProduct(final Vector other) {
      return this.x * other.x + this.y * other.y;
    }

    boolean isOrthogonalTo(final Vector other) {
      return this.dotProduct(other) == 0;
    }

    boolean isParallelTo(final Vector other) {
      return this.crossProduct(other) == 0;
    }

    Vector minus(final Vector other) {
      return new Vector(this.x - other.x, this.y - other.y);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Vector vector = (Vector) o;
      return x == vector.x &&
          y == vector.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
