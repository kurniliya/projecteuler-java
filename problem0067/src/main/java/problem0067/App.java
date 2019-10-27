package problem0067;

import java.io.File;
import java.io.IOException;
import utils.InputUtils;

public class App {

  public static void main(String[] args) throws IOException {
    final String file = App.class.getResource("p067_triangle.txt").getFile();
    final long[][] input = InputUtils
        .readSquareMatrixFromFile(new File(file), 100);
    System.out.println(MaximumPathSum.compute(input));
  }
}
