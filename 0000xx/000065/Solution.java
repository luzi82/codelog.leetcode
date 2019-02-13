import java.util.regex.*;

class Solution {
    public boolean isNumber(String s) {
        // trim string
        s = s.trim();
    
        char[] sCharAry = s.toCharArray();
        
        if(sCharAry.length<=0)return false;
        
        // filter non-num char
        for(char sChar : sCharAry){
            if(!isNumChar(sChar))return false;
        }
        
        // regex
        if(!P.matcher(s).matches())return false;
        
        return true;
    }
    
    public static boolean isNumChar(char c){
        if((c>='0')&&(c<='9'))return true;
        if(c=='e')return true;
        if(c=='+')return true;
        if(c=='-')return true;
        if(c=='.')return true;
        return false;
    }
    
    public static Pattern P = Pattern.compile("^[+-]?((\\d+)|(\\.\\d+)|(\\d+\\.\\d+)|(\\d+\\.))(e[+-]?\\d+)?$");
}
