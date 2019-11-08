package problem0088;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.Test;

public class ProductSumNumbersTest {

  @Test
  public void compute_smallestArgument() {
    assertThat(ProductSumNumbers.compute(2)).isEqualTo(4L);
  }

  @Test
  public void compute_demoExample1() {
    assertThat(ProductSumNumbers.compute(6)).isEqualTo(30L);
  }

  @Test
  public void compute_demoExample2() {
    assertThat(ProductSumNumbers.compute(12)).isEqualTo(61L);
  }

  @Test
  public void listNumbers_demoExample1() {
    assertThat(ProductSumNumbers.listNumbers(6))
        .isEqualTo(List.of(4L, 6L, 8L, 12L));
  }

  @Test
  public void listNumbers_demoExample2() {
    assertThat(ProductSumNumbers.listNumbers(12))
        .isEqualTo(List.of(4L, 6L, 8L, 12L, 15L, 16L));
  }

  @Test
  public void setSizes_smallestArgument() {
    assertThat(ProductSumNumbers.setSizes(2)).isEmpty();
  }

  @Test
  public void setSizes_primeArgument() {
    assertThat(ProductSumNumbers.setSizes(11)).isEmpty();
  }

  @Test
  public void setSizes_4() {
    assertThat(ProductSumNumbers.setSizes(4)).containsExactly(2L);
  }

  @Test
  public void setSizes_6() {
    assertThat(ProductSumNumbers.setSizes(6)).containsExactly(3L);
  }

  @Test
  public void setSizes_8() {
    assertThat(ProductSumNumbers.setSizes(8)).containsExactly(4L, 5L);
  }

  @Test
  public void setSizes_9() {
    assertThat(ProductSumNumbers.setSizes(9)).containsExactly(5L);
  }

  @Test
  public void setSizes_10() {
    assertThat(ProductSumNumbers.setSizes(10)).containsExactly(5L);
  }

  @Test
  public void setSizes_12() {
    assertThat(ProductSumNumbers.setSizes(12)).containsExactly(6L, 7L, 8L);
  }

  @Test
  public void setSizes_14() {
    assertThat(ProductSumNumbers.setSizes(14)).containsExactly(7L);
  }

  @Test
  public void setSizes_15() {
    assertThat(ProductSumNumbers.setSizes(15)).containsExactly(9L);
  }

  @Test
  public void setSizes_16() {
    assertThat(ProductSumNumbers.setSizes(16))
        .containsExactly(8L, 10L, 11L, 12L);
  }
}
