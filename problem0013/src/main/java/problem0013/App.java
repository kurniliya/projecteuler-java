package problem0013;

import java.io.File;
import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    final String resource = App.class.getResource("input.txt").getFile();
    System.out.println(LargeSum.compute(new File(resource)));
  }
}
