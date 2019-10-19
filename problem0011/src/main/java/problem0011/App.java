package problem0011;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import utils.InputUtils;

public class App {

  public static void main(String[] args) throws IOException {
    final URL fileUrl = App.class.getResource("input.txt");

    final ArrayList<ArrayList<Long>> matrix = InputUtils
        .readMatrixFromFile(new File(fileUrl.getFile()));
    System.out.println(LargestProductInAGrid.compute(matrix, 4));
  }
}
