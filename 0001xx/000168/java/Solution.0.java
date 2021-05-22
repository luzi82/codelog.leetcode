import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String convertToTitle(int n) {
        // create digiAry, 100 -> [22,3,0...]
        int remain = n;
        int[] digiAry = new int[20];
        for(int i=0;i<digiAry.length;++i){
            digiAry[i] = remain%26;
            remain /= 26;
        }

        // check last non-zero
        int end = 0;
        for(int i=0;i<digiAry.length;++i){
            if(digiAry[i]==0)continue;
            end = i;
        }
        
        // carry
        for(int i=0;i<end;++i){
            if(digiAry[i]>0)continue;
            digiAry[i] += 26;
            digiAry[i+1]--;
        }
        
        // build string
        StringBuffer sb = new StringBuffer();
        for(int i=digiAry.length-1;i>=0;--i){
            if(digiAry[i]==0)continue;
            sb.append((char)('A'-1+digiAry[i]));
        }
        
        // output
        return sb.toString();
    }
}
