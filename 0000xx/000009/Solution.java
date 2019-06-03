import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isPalindrome(int x) {
        String v = Integer.toString(x);
        
        char[] cAry = v.toCharArray();
        for(int i=0;i<cAry.length;++i){
            if(cAry[i]!=cAry[cAry.length-1-i])return false;
        }
        
        return true;
    }
}
