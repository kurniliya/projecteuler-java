package problem0003;

public class App {

  public static void main(String[] args) {
    final LargestPrimeFactor calculator = new LargestPrimeFactor();
    final long sum = calculator.compute(600851475143L);

    System.out.println(sum);
  }
}
