package problem0004;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ProductGeneratorTest {

  private List<Integer> expected;
  private int minFactor;
  private int maxFactor;

  public ProductGeneratorTest(final int minFactor, final int maxFactor, final List<Integer> expected) {
    this.minFactor = minFactor;
    this.maxFactor = maxFactor;
    this.expected = expected;
  }

  @Parameterized.Parameters(name = "{index}: f({0}, {1})={2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {1, 1, Collections.singletonList(1)},
        {1, 2, Arrays.asList(4, 2, 1)},
        {1, 3, Arrays.asList(9, 6, 4, 3, 2, 1)},
    });
  }

  @Test
  public void testGenerate() {
    assertEquals(expected, ProductGenerator.generate(minFactor, maxFactor));
  }
}
