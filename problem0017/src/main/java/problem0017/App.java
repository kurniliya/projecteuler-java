package problem0017;

public class App {

  public static void main(String[] args) {
    final StringBuilder result = new StringBuilder();
    for (int i = 1; i <= 1_000; ++i) {
      result.append(NumberLetterCounts.asNumeral(i));
    }
    for (int i = 0; i < result.length(); ++i) {
      if (result.charAt(i) == ' ' || result.charAt(i) == '-') {
        result.deleteCharAt(i);
      }
    }
    System.out.println(result.length());
  }
}
