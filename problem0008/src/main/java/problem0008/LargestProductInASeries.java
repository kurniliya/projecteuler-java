package problem0008;

/**
 * Largest product in a series
 * <p>
 * Problem 8
 * <p>
 * The four adjacent digits in the 1000-digit number that have the greatest
 * product are 9 × 9 × 8 × 9 = 5832.
 * <p>
 * ...the number itself is left out for brevity...
 * <p>
 * Find the thirteen adjacent digits in the 1000-digit number that have the
 * greatest product. What is the value of this product?
 */
class LargestProductInASeries {

  private static final char[] REFERENCE_ARRAY =
      ("731671765313306249192251196744265747423553491949349698352031277450632623"
          + "957831801698480186947885184385861560789112949495459501737958331952"
          + "853208805511125406987471585238630507156932909632952274430435576689"
          + "664895044524452316173185640309871112172238311362229893423380308135"
          + "336276614282806444486645238749303589072962904915604407723907138105"
          + "158593079608667017242712188399879790879227492190169972088809377665"
          + "727333001053367881220235421809751254540594752243525849077116705560"
          + "136048395864467063244157221553975369781797784617406495514929086256"
          + "932197846862248283972241375657056057490261407972968652414535100474"
          + "821663704844031998900088952434506585412275886668811642717147992444"
          + "292823086346567481391912316282458617866458359124566529476545682848"
          + "912883142607690042242190226710556263211111093705442175069416589604"
          + "080719840385096245544436298123098787992724428490918884580156166097"
          + "919133875499200524063689912560717606058861164671094050775410022569"
          + "831552000559357297257163626956188267042825248360082325753042075296"
          + "3450").toCharArray();

  public static long compute(final int sliceSize) {
    assert sliceSize >= 1;

    long result = 0;
    final int numberOfSlices = REFERENCE_ARRAY.length - sliceSize + 1;
    for (int sliceStart = 0; sliceStart < numberOfSlices; sliceStart++) {
      long product = 1;
      for (int i = 0; i < sliceSize; i++) {
        product *= Character.getNumericValue(REFERENCE_ARRAY[sliceStart + i]);
      }
      result = Math.max(product, result);
    }

    return result;
  }
}
