package utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class InputUtilsTest {

  @Test
  public void readSquareMatrixFromFile_read_all_data() throws IOException {
    final long[][] expected = {
        {8L, 0L},
        {49L, 365L}
    };

    assertThat(InputUtils.readSquareMatrixFromFile(testFile(), 2),
        equalTo(expected));
  }

  @Test
  public void readMatrixFromFile_read_subset_of_columns() throws IOException {
    final long[][] expected = {
        {8L},
        {49L}
    };

    assertThat(InputUtils.readMatrixFromFile(testFile(), 2, 1),
        equalTo(expected));
  }

  @Test
  public void readMatrixFromFile_read_subset_of_rows() throws IOException {
    final long[][] expected = {
        {8L, 0L}
    };

    assertThat(InputUtils.readMatrixFromFile(testFile(), 1, 2),
        equalTo(expected));
  }

  private File testFile() {
    final String resourcePath = InputUtilsTest.class
        .getResource("InputUtils/2x2.txt")
        .getFile();
    return new File(resourcePath);
  }
}
