import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public final int OVERFLOW = 0x7fffffff;

    public int divide(int dividend, int divisor) {
        if((dividend==0x80000000)&&(divisor==-1))return OVERFLOW;
        if(divisor==0)return OVERFLOW;
        if(dividend==0)return 0;
        if(divisor==1)return dividend; // dividend = 0x80000000 hardcode
        
        boolean retPositive = (dividend>0)==(divisor>0);
        
        long uDividend = abs(dividend);
        long uDivisor = abs(divisor);
        
        long uBit = 1;
        long uDivisorShift = uDivisor;
        while(uDivisorShift<=0x7fffffff){
            uBit<<=1;
            uDivisorShift<<=1;
        }
        
        long uDividendRemain = uDividend;
        long uRet = 0;
        while(uBit!=0){
            if(uDividendRemain>=uDivisorShift){
                uRet|=uBit;
                uDividendRemain-=uDivisorShift;
            }
            uDivisorShift>>=1;
            uBit>>=1;
        }
        
        if(uRet>0x7fffffff)return OVERFLOW;
        return (int)(retPositive?uRet:-uRet);
    }

    public long abs(int v){
        long vL = v;
        if(v<0)return -vL;
        return vL;
    }

}
