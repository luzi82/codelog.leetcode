import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll(Pattern.quote("."), "[.]");
    }
}
