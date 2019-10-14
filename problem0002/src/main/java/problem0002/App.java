package problem0002;

public class App {

  public static void main(String[] args) {
    final int MAX_VALUE = 4_000_000;
    final SumOfEvenFibonacciNumbers calculator = new SumOfEvenFibonacciNumbers();
    final int sum = calculator.compute(MAX_VALUE);

    System.out.println(sum);
  }
}
