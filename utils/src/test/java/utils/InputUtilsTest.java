package utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import org.junit.Test;

public class InputUtilsTest {

  @Test
  public void readBigIntegerListFromFile_read_all_data() throws IOException {
    final BigInteger[] expected = {
        new BigInteger("37107287533902102798797998220837590246510135740250"),
        new BigInteger("46376937677490009712648124896970078050417018260538")
    };

    assertThat(InputUtils.readBigIntegerListFromFile(testBigIntegerFile()),
        equalTo(expected));
  }

  @Test
  public void readSquareMatrixFromFile_read_all_data() throws IOException {
    final long[][] expected = {
        {8L, 0L},
        {49L, 365L}
    };

    assertThat(InputUtils.readSquareMatrixFromFile(testMatrixFile(), 2),
        equalTo(expected));
  }

  @Test
  public void readMatrixFromFile_read_subset_of_columns() throws IOException {
    final long[][] expected = {
        {8L},
        {49L}
    };

    assertThat(InputUtils.readMatrixFromFile(testMatrixFile(), 2, 1),
        equalTo(expected));
  }

  @Test
  public void readMatrixFromFile_read_subset_of_rows() throws IOException {
    final long[][] expected = {
        {8L, 0L}
    };

    assertThat(InputUtils.readMatrixFromFile(testMatrixFile(), 1, 2),
        equalTo(expected));
  }

  private File testBigIntegerFile() {
    return testFile("BigInteger.txt");
  }

  private File testMatrixFile() {
    return testFile("2x2.txt");
  }

  private File testFile(final String path) {
    final String resourcePath = InputUtilsTest.class
        .getResource("InputUtils/" + path)
        .getFile();
    return new File(resourcePath);
  }
}
