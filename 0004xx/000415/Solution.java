import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String addStrings(String num1, String num2) {
        char[] c1Ary = num1.toCharArray();
        char[] c2Ary = num2.toCharArray();
        
        int maxDigit = Math.max(c1Ary.length,c2Ary.length)+2;
        char[] retAry = new char[maxDigit];

        int minNonZeroDigit = retAry.length;
        
        int carry = 0;
        for(int i=0;i<retAry.length;++i){
            int v = 0;
            if(i<c1Ary.length){
                v+=(c1Ary[c1Ary.length-1-i]-'0');
            }
            if(i<c2Ary.length){
                v+=(c2Ary[c2Ary.length-1-i]-'0');
            }
            v+=carry;
            carry = v/10;
            retAry[retAry.length-1-i] = (char)('0'+(v%10));
            if(v!=0){
                minNonZeroDigit=retAry.length-1-i;
            }
        }
        
        if(minNonZeroDigit==retAry.length)return "0";
        
        return new String(retAry,minNonZeroDigit,retAry.length-minNonZeroDigit);
    }
}
