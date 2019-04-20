import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public static final int SMALL = Integer.MIN_VALUE/4;

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int loopDone = 0;
        int charDone = 0;

        HashMap<Integer,Integer> cToNMap = new HashMap<>();
        HashMap<Integer,Integer> nToLoopMap = new HashMap<>();
        
        int n=0;
        while(n<n1){
            if(cToNMap.containsKey(charDone))break;
            cToNMap.put(charDone,n);
            nToLoopMap.put(n,loopDone);
            int[] ret = calCharLoop(charDone,s1,s2);
            //System.err.println(String.format("OPWZBYYOER c=%d, cl=%s",charDone,Test.join(ret)));
            charDone  = ret[0];
            loopDone += ret[1];
            ++n;
        }
        
        System.err.println(String.format("RKLIAPHIDZ n=%d, charDone=%d, loopDone=%d",n,charDone,loopDone));
        
        if(n<n1){
            int firstN = cToNMap.get(charDone);
            int nDiff = n-firstN;
            int remainNDiffCount = (n1-n)/nDiff;
            int nLoopDiff = loopDone - nToLoopMap.get(firstN);
            int remainLoopDiff = remainNDiffCount * nLoopDiff;

            //System.err.println(
            //    String.format("DGVPBMFSPL firstN=%d, nDiff=%d, remainNDiffCount=%d, remainLoopDiff=%d",
            //                firstN,nDiff,remainNDiffCount,remainLoopDiff
            //    )
            //);
            
            int modN = ((n1-n)%nDiff) + firstN;
            int modLoop = nToLoopMap.get(modN) - nToLoopMap.get(firstN);
            
            //System.err.println(String.format("DGVPBMFSPL remainLoopDiff=%d, modLoop=%d",remainLoopDiff,modLoop));
            
            loopDone += remainLoopDiff;
            loopDone += modLoop;
            
            n=n1;
        }
        
        return loopDone/n2;
    }
    
    // return {char,loop}
    public static int[] calCharLoop(int charDone,String s1,String s2){
        int loopDone = 0;
        int sLen = s1.length();
        for(int i=0;i<sLen;++i){
            char c1=s1.charAt(i);
            char c2=s2.charAt(charDone);
            if(c1==c2){
                ++charDone;
                if(charDone==s2.length()){
                    ++loopDone;
                    charDone=0;
                }
            }
        }
        return new int[]{charDone,loopDone};
    }
}