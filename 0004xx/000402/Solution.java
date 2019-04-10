import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> retCharList = new LinkedList<>();
        char[] numCharAry = num.toCharArray();
        int numDone = 0;
        while(true){
            if(numDone>=numCharAry.length)break;
            if(k<=0)break;
            char numChar = numCharAry[numDone];
            ++numDone;
            while(true){
                if(retCharList.isEmpty())break;
                if(k<=0)break;
                char lastChar = retCharList.getLast();
                if(lastChar<=numChar)break;
                retCharList.removeLast();
                --k;
            }
            retCharList.addLast(numChar);
        }
        while(numDone<numCharAry.length){
            char numChar = numCharAry[numDone];
            ++numDone;
            retCharList.addLast(numChar);
        }
        while(k>0){
            retCharList.removeLast();
            --k;
        }
        
        // make string, ignore leading zero
        StringBuffer retSb = new StringBuffer();
        for(Character retChar:retCharList){
            if((retSb.length()<=0)&&(retChar=='0'))continue;
            retSb.append(retChar);
        }
        
        // if empty string, return zero
        if(retSb.length()<=0)return "0";
        
        return retSb.toString();
    }
}
