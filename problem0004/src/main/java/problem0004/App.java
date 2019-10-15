package problem0004;

public class App {

  public static void main(String[] args) {
    final LargestPalindromeProduct calculator = new LargestPalindromeProduct();
    final long result = calculator.compute(100, 999);

    System.out.println(result);
  }
}
