package problem0024;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class App {

  public static void main(String[] args) {
    final var alphabet = List.of('0', '1', '2', '3', '4',
        '5', '6', '7', '8', '9');
    System.out.println(solve(alphabet, 1_000_000 - 1).stream()
        .map(String::valueOf).reduce("", String::concat));
  }

  @VisibleForTesting
  @NotNull
  static <T> List<T> solve(
      @NotNull final List<T> alphabet,
      final long ordinal) {
    checkNotNull(alphabet);
    checkArgument(ordinal >= 0);

    final var size = alphabet.size();
    final long totalPermutations = factorial(size);
    final long numberOfIterations = ordinal % totalPermutations;

    if (numberOfIterations == 0) {
      return alphabet;
    }
    // Key observation:
    // Let's have n-element list. Leading element has the same value for
    // {@code remainderPermutations} = (n-1)! iterations.
    // These iterations go through all possible (n-1)! permutations of the
    // @{code remainder} leaving it in inverse original order, e.g.:
    //     0123 -> 0132 -> 0213 -> 0231 -> 0312 -> 0321 ...
    // The next iteration changes the leading element and the set of elements
    // in the remainder. Leading element simply moves to new value. Remainder
    // equals to the original input list with the element corresponding to
    // current leading element removed:
    // ... 0321 -> 1023.
    final long remainderPermutations = totalPermutations / size;
    final int numberOfCycles = Math
        .toIntExact(numberOfIterations / remainderPermutations);
    final T newValue = alphabet.get(numberOfCycles % size);
    final var remainder = new ArrayList<>(alphabet);
    remainder.remove(newValue);
    assert remainder.size() == size - 1;
    final long remainingTimes =
        numberOfIterations - numberOfCycles * remainderPermutations;
    assert remainingTimes >= 0;

    final var result = new ArrayList<T>();
    result.add(newValue);
    result.addAll(solve(remainder, remainingTimes));

    return result;
  }

  @Contract(pure = true)
  private static long factorial(final long n) {
    return LongStream.rangeClosed(1, n).reduce(1, (x, y) -> x * y);
  }
}
