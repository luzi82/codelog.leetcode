import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int atMostNGivenDigitSet(String[] D, int N) {
        if(N==0)return 0;
    
        final int L=0,E=1,M=2,LEM=3;

        // create dAry, dAry[i] = int(D[i])
        int[] dAry = new int[D.length];
        for(int i=0;i<dAry.length;++i){
            dAry[i] = Integer.parseInt(D[i]);
        }
    
        // create dAA
        // dAA[i][L] = num of element lesser than i in D
        // dAA[i][E] = num of element eq i in D
        // dAA[i][M] = num of element more than i in D
        int[][] dAA = new int[10][LEM];
        int dIdx = 0;
        dAA[0][M] = D.length;
        for(int i=1;i<10;++i){
            if((dIdx>=dAry.length)||(dAry[dIdx]!=i)){
                dAA[i][M] = dAA[i-1][M];
                dAA[i][E] = 0;
                dAA[i][L] = dAA[i-1][L]+dAA[i-1][E];
            }else{
                dAA[i][M] = dAA[i-1][M]-1;
                dAA[i][E] = 1;
                dAA[i][L] = dAA[i-1][L]+dAA[i-1][E];
                ++dIdx;
            }
        }
        
        // create nAry, nAry[i] = int(str(N)[i])
        String nStr = Integer.toString(N);
        int[] nAry = new int[nStr.length()];
        for(int i=0;i<nAry.length;++i){
            nAry[i] = nStr.charAt(nStr.length()-i-1)-'0';
        }
        
        // create nAA
        int[][] nAA = new int[nAry.length][LEM];
        {
            int n = nAry[0];
            int[] dLEM = dAA[n];
            nAA[0][M] = dLEM[M];
            nAA[0][E] = dLEM[E];
            nAA[0][L] = dLEM[L];
        }
        int t = dAry.length;
        for(int i=1;i<nAry.length;++i){
            int n = nAry[i];
            int[] dLEM = dAA[n];
            nAA[i][M] += dLEM[M]*t;
            nAA[i][M] += dLEM[E]*nAA[i-1][M];
            nAA[i][E] += dLEM[E]*nAA[i-1][E];
            nAA[i][L] += dLEM[L]*t;
            nAA[i][L] += dLEM[E]*nAA[i-1][L];
            t *= dAry.length;
        }
        
        // result
        int ret = 0;
        t = dAry.length;
        for(int i=1;i<nAry.length;++i){
            ret+=t;
            t*=dAry.length;
        }
        
        ret += nAA[nAA.length-1][L]+nAA[nAA.length-1][E];
        return ret;
    }
}
