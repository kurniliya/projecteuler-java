package problem0015;

public class App {

  public static void main(String[] args) {
    System.out.println(f(20));
  }

  static long f(final long size) {
    return f(size, size);
  }

  static long f(final long m, final long n) {
    if (n == 0 && m == 0) {
      return 0;
    } else if (m == 0 || n == 0) {
      return 1;
    }

    return f(m, n - 1) + f(m - 1, n);
  }
}
