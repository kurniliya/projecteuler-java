package problem0001;

public class App {

  public static void main(String[] args) {
    final int MAX_VALUE = 1_000;
    final int sum = SumOfMultiplesOfThreeOrFive.compute(MAX_VALUE);

    System.out.println(sum);
  }
}
