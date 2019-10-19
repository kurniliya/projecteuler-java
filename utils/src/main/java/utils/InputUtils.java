package utils;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputUtils {

  public static ArrayList<ArrayList<Long>> readMatrixFromFile(
      final File file) throws IOException {
    checkNotNull(file);
    checkArgument(file.isFile());

    ArrayList<ArrayList<Long>> result = Lists.newArrayList();

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        final Scanner scanner = new Scanner(line);
        final ArrayList<Long> row = new ArrayList<>();
        while (scanner.hasNext()) {
          row.add(scanner.nextLong());
        }
        result.add(row);
      }
    }

    return result;
  }
}
