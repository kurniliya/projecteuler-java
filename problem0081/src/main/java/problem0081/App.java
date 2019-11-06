package problem0081;

import java.io.File;
import java.io.IOException;
import utils.InputUtils;

public class App {

  public static void main(String[] args) throws IOException {
    final String file = App.class.getResource("p081_matrix.txt").getFile();
    final long[][] input = InputUtils
        .readSquareMatrixFromFile(new File(file), 80);
    System.out.println(MinimalPathSum.compute(input));
  }
}
