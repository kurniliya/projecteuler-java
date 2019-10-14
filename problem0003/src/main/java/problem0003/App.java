package problem0003;

public class App {

  public static void main(String[] args) {
    final LargestPrimeFactor calculator = new LargestPrimeFactor();
    final int sum = calculator.compute(600851475143L);

    System.out.println(sum);
  }
}
