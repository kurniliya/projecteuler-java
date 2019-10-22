package problem0015;

public class App {

  public static void main(String[] args) {
    System.out.println(f(20));
  }

  static long f(final int size) {
    return f(size, size);
  }

  static long f(final int width, final int height) {
    final long[][] values = new long[width + 1][height + 1];

    values[0][0] = 0;
    for (int x = 1; x < width + 1; ++x) {
      values[x][0] = 1;
    }
    for (int y = 1; y < height + 1; ++y) {
      values[0][y] = 1;
    }

    for (int x = 1; x < width + 1; ++x) {
      for (int y = 1; y < height + 1; ++y) {
        values[x][y] = values[x][y - 1] + values[x - 1][y];
      }
    }

    return values[width][height];
  }
}
