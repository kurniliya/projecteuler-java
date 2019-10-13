package problem0001;

class SumOfMultiplesOfThreeOrFive {

  public static int compute(final int rightBoundary) {
    assert rightBoundary >= 0;

    int result = 0;

    for (int i = 0; i < rightBoundary; i++) {
      if ((i % 3 == 0) || (i % 5 == 0)) {
        result += i;
      }
    }

    assert result >= 0;
    return result;
  }
}
