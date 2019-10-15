package problem0002;

public class App {

  public static void main(String[] args) {
    final SumOfEvenFibonacciNumbers calculator = new SumOfEvenFibonacciNumbers();
    System.out.println(calculator.compute(4_000_000));
  }
}
