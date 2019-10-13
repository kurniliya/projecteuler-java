package problem0001;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SumOfMultiplesOfThreeOrFiveTest {

  @Test
  public void testUpToOne() {
    assertEquals(0, SumOfMultiplesOfThreeOrFive.compute(1));
  }

  @Test
  public void testUpToThree() {
    assertEquals(0, SumOfMultiplesOfThreeOrFive.compute(3));
  }

  @Test
  public void testUpToFour() {
    assertEquals(3, SumOfMultiplesOfThreeOrFive.compute(4));
  }

  @Test
  public void testUpToSix() {
    assertEquals(8, SumOfMultiplesOfThreeOrFive.compute(6));
  }

  @Test
  public void testUpToTen() {
    assertEquals(23, SumOfMultiplesOfThreeOrFive.compute(10));
  }
}
