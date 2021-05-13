import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String getHint(String secret, String guess) {
        char[] sCAry = secret.toCharArray();
        char[] gCAry = guess.toCharArray();
        
        int a = 0;
        int b = 0;
        
        int[] sCToCntAry = new int[10];
        int[] gCToCntAry = new int[10];
        for(int i=0;i<sCAry.length;++i){
            char sC=sCAry[i];
            char gC=gCAry[i];
            if(sC==gC){
                ++a;
            }else{
                ++sCToCntAry[sC-'0'];
                ++gCToCntAry[gC-'0'];
            }
        }
        
        for(int i=0;i<10;++i){
            b += Math.min(sCToCntAry[i],gCToCntAry[i]);
        }
        
        return String.format("%dA%dB",a,b);
    }
}
