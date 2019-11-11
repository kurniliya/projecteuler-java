package problem0024;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.Test;

public class AppTest {

  @Test
  public void solve_3CharsPermutation0() {
    assertThat(App.solve(List.of('0', '1', '2'), 0))
        .containsExactly('0', '1', '2')
        .inOrder();
  }

  @Test
  public void solve_3CharsPermutation1() {
    assertThat(App.solve(List.of('0', '1', '2'), 1))
        .containsExactly('0', '2', '1')
        .inOrder();
  }

  @Test
  public void solve_3CharsPermutation2() {
    assertThat(App.solve(List.of('0', '1', '2'), 2))
        .containsExactly('1', '0', '2')
        .inOrder();
  }

  @Test
  public void solve_3CharsPermutation3() {
    assertThat(App.solve(List.of('0', '1', '2'), 3))
        .containsExactly('1', '2', '0')
        .inOrder();
  }

  @Test
  public void solve_3CharsPermutation4() {
    assertThat(App.solve(List.of('0', '1', '2'), 4))
        .containsExactly('2', '0', '1')
        .inOrder();
  }

  @Test
  public void solve_3CharsPermutation5() {
    assertThat(App.solve(List.of('0', '1', '2'), 5))
        .containsExactly('2', '1', '0')
        .inOrder();
  }

  @Test
  public void solve_3CharsPermutation6() {
    assertThat(App.solve(List.of('0', '1', '2'), 6))
        .containsExactly('0', '1', '2')
        .inOrder();
  }

  @Test
  public void solve_10CharsPermutation0() {
    assertThat(
        App.solve(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'), 0))
        .containsExactly('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        .inOrder();
  }

  @Test
  public void solve_10CharsPermutation1() {
    assertThat(
        App.solve(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'), 1))
        .containsExactly('0', '1', '2', '3', '4', '5', '6', '7', '9', '8')
        .inOrder();
  }

  @Test
  public void solve_10CharsPermutationOfLastSevenTerms() {
    assertThat(
        App.solve(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'),
            /* 7! - 1 = */ 5040 - 1))
        .containsExactly('0', '1', '2', '9', '8', '7', '6', '5', '4', '3')
        .inOrder();
  }

  @Test
  public void solve_10CharsLastPermutation() {
    assertThat(
        App.solve(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'),
            /* 10! - 1 = */ 3628800 - 1))
        .containsExactly('9', '8', '7', '6', '5', '4', '3', '2', '1', '0')
        .inOrder();
  }
}
