import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] sCharAry = S.toCharArray();
        
        // remove -, convert uppercase
        char[] t0CharAry = new char[sCharAry.length];
        int t0Size = 0;
        for(char sChar:sCharAry){
            if(sChar=='-')continue;
            if((sChar>='a')&&(sChar<='z')){sChar-='a';sChar+='A';}
            t0CharAry[t0Size] = sChar;
            ++t0Size;
        }

        // output str
        StringBuffer sb = new StringBuffer();

        // output first group
        int firstSize = t0Size%K;
        int doneOffset = 0;
        if(firstSize>0){
            while(doneOffset<firstSize){
                sb.append(t0CharAry[doneOffset]);
                ++doneOffset;
            }
            if(doneOffset<t0Size){
                sb.append('-');
            }
        }
        
        // output other group
        while(doneOffset<t0Size){
            int endOffset = doneOffset+K;
            while(doneOffset<endOffset){
                sb.append(t0CharAry[doneOffset]);
                ++doneOffset;
            }
            if(doneOffset<t0Size){
                sb.append('-');
            }
        }
        return sb.toString();
    }
}
