import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String convertToTitle(int n) {
        long nLong = n;
    
        // find digiCount
        int digiCount = 1;
        long digiMax = 1;
        while(digiMax<n){
            digiMax *= 26;
            ++digiCount;
        }
        
        // create digiValAry, [1,26,26^2...]
        long[] digiValAry = new long[digiCount];
        digiValAry[0] = 1;
        for(int i=1;i<digiCount;++i){
            digiValAry[i] = digiValAry[i-1] * 26;
        }
        
        // create digiAry, 100 -> [22,3]
        int remain = n;
        int[] digiAry = new int[digiCount];
        for(int i=digiCount-1;i>=0;--i){
            digiAry[i] = (int)( remain / digiValAry[i] );
            remain %= digiValAry[i];
        }
        
        // last non-zero
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
        
        // reverse
        int[] reverseDigiAry = new int[digiAry.length];
        for(int i=0;i<digiAry.length;++i){
            reverseDigiAry[i] = digiAry[digiAry.length-1-i];
        }
        
        // build string
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<reverseDigiAry.length;++i){
            if(reverseDigiAry[i]==0)continue;
            sb.append((char)('A'-1+reverseDigiAry[i]));
        }
        
        // output
        return sb.toString();
    }
}
