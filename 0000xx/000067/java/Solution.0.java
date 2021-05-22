import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.math.*;

// lazy BigInteger

class Solution {
  public String addBinary(String a, String b) {
    BigInteger aBi = new BigInteger(a,2);
    BigInteger bBi = new BigInteger(b,2);
    BigInteger cBi = aBi.add(bBi);
    return cBi.toString(2);
  }
}
