package utils;

import java.util.Objects;

public class PrimeFactor {

  private final long factor;
  private final long power;

  private PrimeFactor(final long factor, final long power) {
    this.factor = factor;
    this.power = power;
  }

  public static PrimeFactor of(final long factor, final long power) {
    return new PrimeFactor(factor, power);
  }

  public long factor() {
    return factor;
  }

  public long power() {
    return power;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrimeFactor that = (PrimeFactor) o;
    return factor == that.factor &&
        power == that.power;
  }

  @Override
  public int hashCode() {
    return Objects.hash(factor, power);
  }

  @Override
  public String toString() {
    return "PrimeFactor{" +
        "factor=" + factor +
        ", power=" + power +
        '}';
  }
}
