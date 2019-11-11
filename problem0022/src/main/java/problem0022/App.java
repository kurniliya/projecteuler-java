package problem0022;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class App {

  public static void main(String[] args) throws IOException {
    var pathStr = App.class.getResource("p022_names.txt").getFile();
    var path = new File(pathStr);
    var text = Files.readString(path.toPath(), StandardCharsets.UTF_8);

    System.out.println(score(Arrays.asList(text.split(","))));
  }

  private static long score(@NotNull final List<String> list) {
    checkNotNull(list);

    list.sort(String::compareTo);
    long result = 0;
    for (int i = 0; i < list.size(); ++i) {
      final String word = list.get(i);
      result += (i + 1) * score(word);
    }
    return result;
  }

  @VisibleForTesting
  static long score(@NotNull final String word) {
    checkNotNull(word);

    long result = 0;
    for (int i = 0; i < word.length(); ++i) {
      final char c = word.charAt(i);
      if (c != '"') {
        result += c - 'A' + 1;
      }
    }
    return result;
  }
}
