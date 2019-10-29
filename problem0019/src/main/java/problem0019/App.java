package problem0019;

import java.time.LocalDate;

public class App {

  public static void main(String[] args) {
    System.out.println(CountingSundays.compute(
        LocalDate.of(1901, 1, 1),
        LocalDate.of(2000, 12, 31)));
  }
}
