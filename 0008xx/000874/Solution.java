import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    static final long BIG = 1000000000L+7;

    public int nthMagicalNumber(int N, int A, int B) {
        long abgcdV = gcd(A,B);
        //System.err.println(String.format("abgcdV=%d",abgcdV));
        long ablcmV = ((long)A*(long)B/abgcdV);
        //System.err.println(String.format("ablcmV=%d",ablcmV));
        long unitIdxCnt = (ablcmV/A) + (ablcmV/B) - 1;
        //System.err.println(String.format("unitIdxCnt=%d",unitIdxCnt));
        long retQuotientIdx = N/unitIdxCnt;
        //System.err.println(String.format("retQuotientIdx=%d",retQuotientIdx));
        
        long retQuotientV = ((ablcmV%BIG)*retQuotientIdx)%BIG;
        
        long modIdx = N%unitIdxCnt;
        long retModV = 0;
        if(modIdx == 0){
            retModV=0;
        }else{
            long minV=0;
            long maxV=ablcmV;
            while(true){
                long midV = (minV+maxV)/2;
                long midIdx = (midV/A) + (midV/B);
                if(midIdx==modIdx){
                    retModV = midV;
                    break;
                }else if(midIdx>modIdx){
                    maxV = midV;
                }else{
                    minV = midV;
                }
            }
            long modAV = retModV%A;
            long modBV = retModV%B;
            retModV-=Math.min(modAV,modBV);
        }
        
        long retV = (retQuotientV+retModV);
        
        return (int)(retV%BIG);
    }
    
    static int gcd(int a,int b){
        if(b<a)return gcd(b,a);
        while(true){
            int c = b%a;
            if(c==0)return a;
            b=a;
            a=c;
        }
    }
}
