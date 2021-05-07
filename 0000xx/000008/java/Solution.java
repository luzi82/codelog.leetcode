import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// can be easy done with long64 type
// but done by int32 here only

class Solution {

    static final int MIN = Integer.MIN_VALUE;
    static final int MAX = Integer.MAX_VALUE;
    
    static final int BIG10 = 214748364;

    public int myAtoi(String str) {
        char[] cAry = str.toCharArray();
    
        int i=0;
        for(;i<cAry.length;++i){
            if(cAry[i]!=' ')break;
        }
        
        if(i==cAry.length)return 0;
        
        boolean positive = true;
        if(cAry[i]=='-'){positive=false;++i;}
        else if(cAry[i]=='+'){++i;}

        if(i==cAry.length)return 0;
        
        int retAbs = 0;
        
        for(;i<cAry.length;++i){
            char c = cAry[i];
            if(c<'0')break;
            if(c>'9')break;
            
            if(retAbs>BIG10){
                return positive?MAX:MIN;
            }else if(retAbs==BIG10){
                if(( positive)&&(c>='7'))return MAX;
                if((!positive)&&(c>='8'))return MIN;
            }
            
            retAbs*=10;
            retAbs+=(c-'0');
        }
        
        return positive?(retAbs):(-retAbs);
    }
}
