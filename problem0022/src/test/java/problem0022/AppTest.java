package problem0022;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class AppTest {

  @Test
  public void wordScore_COLIN() {
    assertThat(App.score("\"COLIN\"")).isEqualTo(53L);
  }
}
