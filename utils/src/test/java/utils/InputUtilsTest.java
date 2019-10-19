package utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import com.google.common.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import org.junit.Test;

public class InputUtilsTest {

  @Test
  public void readMatrixFromFile() throws IOException {

    final ArrayList<ArrayList<Long>> expected = Lists.newArrayList(
        Lists.newArrayList(8L, 0L),
        Lists.newArrayList(49L, 365L)
    );

    final URL url = InputUtilsTest.class.getResource("InputUtils/2x2.txt");
    final String path = url.getFile();

    assertThat(InputUtils.readMatrixFromFile(new File(path)),
        equalTo(expected));
  }
}
