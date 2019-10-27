package problem0017;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableMap;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * <p>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 */
public class NumberLetterCounts {

  private static ImmutableMap<Integer, String> ELEMENTARY_NUMBERS = ImmutableMap
      .<Integer, String>builder()
      .put(0, "")
      .put(1, "one")
      .put(2, "two")
      .put(3, "three")
      .put(4, "four")
      .put(5, "five")
      .put(6, "six")
      .put(7, "seven")
      .put(8, "eight")
      .put(9, "nine")
      .put(10, "ten")
      .put(11, "eleven")
      .put(12, "twelve")
      .put(13, "thirteen")
      .put(14, "fourteen")
      .put(15, "fifteen")
      .put(16, "sixteen")
      .put(17, "seventeen")
      .put(18, "eighteen")
      .put(19, "nineteen")
      .build();

  private static ImmutableMap<Integer, String> TENS = ImmutableMap
      .<Integer, String>builder()
      .put(2, "twenty")
      .put(3, "thirty")
      .put(4, "forty")
      .put(5, "fifty")
      .put(6, "sixty")
      .put(7, "seventy")
      .put(8, "eighty")
      .put(9, "ninety")
      .build();

  static StringBuilder asNumeral(final int number) {
    int remainder = number;
    final StringBuilder result = new StringBuilder();

    addDecimalPlace(remainder, 1_000, "thousand", result);
    remainder %= 1_000;

    addDecimalPlace(remainder, 100, "hundred", result);
    remainder %= 100;

    addPlacesBelowHundred(result, remainder);

    return result;
  }

  private static void addPlacesBelowHundred(StringBuilder destination,
      final int number) {
    checkNotNull(destination);
    checkArgument(number >= 0 && number <= 99);

    if (number == 0) {
      return;
    }
    if (destination.length() > 0) {
      destination.append(" and");
    }

    if (number <= 19) {
      addComponent(destination, ELEMENTARY_NUMBERS.get(number));
      return;
    }

    final int tens = number / 10;
    final int digits = number % 10;

    addComponent(destination, TENS.get(tens));

    if (digits > 0) {
      addComponent(destination, ELEMENTARY_NUMBERS.get(digits), "-");
    }
  }

  private static void addDecimalPlace(final int number, final int factor,
      final String name, final StringBuilder destination) {
    final int count = number / factor;
    if (count <= 0) {
      return;
    }

    addComponent(destination, ELEMENTARY_NUMBERS.get(count));
    destination.append(" ").append(name);
  }

  private static void addComponent(final StringBuilder destination,
      final String component) {
    addComponent(destination, component, " ");
  }

  private static void addComponent(final StringBuilder destination,
      final String component, final String spacer) {
    if (destination.length() > 0) {
      destination.append(spacer);
    }
    destination.append(component);
  }
}
