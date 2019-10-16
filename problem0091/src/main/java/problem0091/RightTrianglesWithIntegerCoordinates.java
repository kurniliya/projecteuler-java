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
        final Vector p = new Vector(x1, y1);
        result += considerComplimentaryVectors(p, maxCoordinate);
      }
    }

    return result;
  }

  private static int considerComplimentaryVectors(final Vector p,
      final int maxCoordinate) {
    // Carefully iterate over complimentary Q (x2, y2) in such a way that
    // we don't consider equivalent triangles twice in the end of the day.
    //
    // I.e. 3!=6 possible permutations of {(0, 0), (0, 1), (1, 0)} are exactly
    // the same thing, hence, must be counted only once.
    // Origin (0, 0) figures in the implemented algorithm only implicitly,
    // so we have to only protect against miscounting remaining 2!=2
    // permutations of {(0, 1), (1, 0)}.
    int result = 0;

    // At the same vertical level, consider only points to the right.
    int y2 = p.y;
    for (int x2 = p.x + 1; x2 <= maxCoordinate; x2++) {
      final Vector q = new Vector(x2, y2);
      if (formRightTriangle(p, q)) {
        result++;
      }
    }

    // At higher vertical levels, consider all the points.
    for (y2 = p.y + 1; y2 <= maxCoordinate; y2++) {
      for (int x2 = 0; x2 <= maxCoordinate; x2++) {
        final Vector q = new Vector(x2, y2);
        if (formRightTriangle(p, q)) {
          result++;
        }
      }
    }

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
