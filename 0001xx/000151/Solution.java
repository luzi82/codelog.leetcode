import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Solution {
    public String reverseWords(String s) {
        String[] sSplit = s.split(" ");
        Stream<String> sStream = Arrays.stream(sSplit);
        sStream = sStream.filter(i -> i.length()>0);
        List<String> sList = sStream.collect(Collectors.toList());
        Collections.reverse(sList);
        String ret = String.join(" ",sList);
        return ret;
    }
}
