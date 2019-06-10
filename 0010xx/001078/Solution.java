import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;


class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        LinkedList<String> retList = new LinkedList<>();
        String[] textSplitAry = text.split(Pattern.quote(" "));
        for(int i=0;i<textSplitAry.length-2;++i){
            if(!textSplitAry[i].equals(first))continue;
            if(!textSplitAry[i+1].equals(second))continue;
            retList.addLast(textSplitAry[i+2]);
        }
        return retList.toArray(new String[0]);
    }
}
