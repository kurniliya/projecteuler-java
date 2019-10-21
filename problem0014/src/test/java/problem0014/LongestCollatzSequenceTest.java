package problem0014;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class LongestCollatzSequenceTest {

  @Test
  public void compute_smallest_input() {
    assertThat(LongestCollatzSequence.compute(1), is(1L));
  }

  @Test
  public void compute_demoed_input() {
    assertThat(LongestCollatzSequence.compute(13), is(9L));
  }

  @Test
  public void CollatzChain() {
    long[] expected = {13L, 40L, 20L, 10L, 5L, 16L, 8L, 4L, 2L};
    long[] actual = LongestCollatzSequence.CollatzChainStream(13)
        .toArray();
    assertThat(actual, is(expected));
  }
}
