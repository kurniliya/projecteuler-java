package problem0004;

import java.util.ArrayList;
import java.util.Collections;

public class ProductGenerator {

  static ArrayList<Integer> generate(final int minFactor, final int maxFactor) {
    assert minFactor <= maxFactor;

    final ArrayList<Integer> result = new ArrayList<>();

    for (int i = maxFactor; i >= minFactor; i--) {
      for (int j = i; j >= minFactor; j--) {
        result.add(i * j);
      }
    }

    result.sort(Collections.reverseOrder());

    assert result.size() > 0;
    return result;
  }
}
