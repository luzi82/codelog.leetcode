import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strSplit = str.split(Pattern.quote(" "));
        if(strSplit.length!=pattern.length())return false;
        
        char[] pCharAry = pattern.toCharArray();
        
        HashMap<Character,String> charToStringMap = new HashMap<>();
        HashMap<String,Character> stringToCharMap = new HashMap<>();
        
        for(int i=0;i<pCharAry.length;++i){
            char pChar = pCharAry[i];
            String strS = strSplit[i];
            if(charToStringMap.containsKey(pChar)&&(!charToStringMap.get(pChar).equals(strS)))return false;
            if(stringToCharMap.containsKey(strS)&&(stringToCharMap.get(strS)!=pChar))return false;
            charToStringMap.put(pChar,strS);
            stringToCharMap.put(strS,pChar);
        }
        
        return true;
    }
}
