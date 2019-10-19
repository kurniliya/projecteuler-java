package problem0011;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import utils.InputUtils;

public class App {

  public static void main(String[] args) throws IOException {
    final int MATRIX_SIZE = 20;
    final URL fileUrl = App.class.getResource("input.txt");
    final long[][] matrix = InputUtils
        .readSquareMatrixFromFile(new File(fileUrl.getFile()), MATRIX_SIZE);
    System.out.println(LargestProductInAGrid.compute(matrix, MATRIX_SIZE, 4));
  }
}
