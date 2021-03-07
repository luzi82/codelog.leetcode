import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean checkValidString(String s) {
        char[] sCharAry = s.toCharArray();

        int min=0;
        int max=0;
        for(char sChar:sCharAry){
          if(sChar=='('){
            ++min;
            ++max;
          }else if(sChar==')'){
            --min;
            --max;
          }else if(sChar=='*'){
            --min;
            ++max;
          }
          min = Math.max(0,min);
          if(max<0)return false;
        }

        return min==0;
    }
}
