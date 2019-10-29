package problem0019;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 * <p>
 * <ul>
 * <li>1 Jan 1900 was a Monday.</li>
 * <li>
 * Thirty days has September,
 * <p>
 * April, June and November.
 * <p>
 * All the rest have thirty-one,
 * <p>
 * Saving February alone,
 * <p>
 * Which has twenty-eight, rain or shine.
 * <p>
 * And on leap years, twenty-nine.
 * </li>
 * <li>A leap year occurs on any year
 * evenly divisible by 4, but not on a century unless it is divisible by 400.
 * </ul>
 * <p>
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 */
public class CountingSundays {

  static long compute(final LocalDate start, final LocalDate end) {
    checkNotNull(start);
    checkNotNull(end);
    checkArgument(!start.isAfter(end));
    checkArgument(start.getDayOfMonth() == 1);

    LocalDate date = start;
    long result = 0;

    while (!date.isAfter(end)) {
      if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
        result++;
      }
      date = date.plusMonths(1);
    }

    return result;
  }
}
