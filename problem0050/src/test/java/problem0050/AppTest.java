package problem0050;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class AppTest {

  @Test
  public void solve_demo01() {
    assertThat(App.solve(100)).isEqualTo(41L);
  }

  @Test
  public void solve_demo02() {
    assertThat(App.solve(1_000)).isEqualTo(953L);
  }

  @Test
  public void listOfPrimesUpTo_2() {
    assertThat(App.listOfPrimesUpTo(2)).isEmpty();
  }

  @Test
  public void listOfPrimesUpTo_3() {
    assertThat(App.listOfPrimesUpTo(3)).containsExactly(2L);
  }

  @Test
  public void listOfPrimesUpTo_20() {
    assertThat(App.listOfPrimesUpTo(20))
        .containsExactly(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L);
  }
}
