package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    try {
      Option<Integer> returnValue = null;
      if (n>=0 && i>=0) {
        if (n == 0) { returnValue = Option.of(1);}
        else if (i == 0) {returnValue = Option.of(0);}
        else {
          int result = 1;
          for (int j = 0; j < n; j++) {
            result *= i;
            if (result == 0) {
              returnValue = Option.none();
            } else {
              returnValue = Option.of(result);
            }
          }
        }
      } else {
        returnValue = Option.none();
      }
      return returnValue;
    } catch (Exception e) {
      return Option.none();
    }
  }
}
