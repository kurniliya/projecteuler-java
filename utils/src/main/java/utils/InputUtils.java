package utils;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputUtils {

  public static long[][] readSquareMatrixFromFile(
      final File file, final int size)
      throws IOException {
    return readMatrixFromFile(file, size, size);
  }

  public static long[][] readMatrixFromFile(
      final File file, final int rowsCount, final int columnsCount)
      throws IOException {
    checkNotNull(file);
    checkArgument(file.isFile());
    checkArgument(rowsCount > 0);
    checkArgument(columnsCount > 0);

    long[][] result = new long[rowsCount][columnsCount];

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      int row = 0;
      while ((line = br.readLine()) != null && row < rowsCount) {
        int column = 0;
        final Scanner scanner = new Scanner(line);
        while (scanner.hasNext() && column < columnsCount) {
          result[row][column++] = scanner.nextLong();
        }
        ++row;
      }
    }

    return result;
  }
}
