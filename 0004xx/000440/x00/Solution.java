import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int findKthNumber(int n, int k) {
        if(n<10)return k;
        
        int nk=n-k;
        int[] nDigitAry=getDigitAry(n);
        
        for(int i=0;i<nDigitAry.length-1;++i){
            int nnn=nnnn(nDigitAry[i],nDigitAry.length-i);
            System.out.println("nnn="+nnn);
            if(nk<nnn){
                String retLhs = Integer.toString(n).substring(0,i);
                String retRhs = getRhs(nk,nDigitAry.length-i);
                System.out.println("lhs="+retLhs+" rhs="+retRhs);
                return Integer.parseInt(retLhs+retRhs);
            }
            nk-=nnn;
        }
        
//        for(int i=nDigitAry.length;i>0;--i){
//            if(nk==0)return Integer.parseInt(Integer.toString(n).substring(0,i));
//            --nk;
//            int nnn = nnnn(nDigitAry[i-1],nDigitAry.length-i+1);
//            if(nk<nnn)return 0; // todo
//            nk -= nnn;
//        }
        
        return 0;
    }
    
    public static String getRhs(int nk,int c){
        if(c==0)return "";
        int n111 = nnnn(1,c);
        int q = nk/n111;
        if(q==10)return "";
        return ""+(9-q)+getRhs(nk%n111,c-1);
    }

    public static int nnnn(int n,int c){
        int ret=0;
        for(int i=0;i<c;++i){
            ret*=10;
            ret+=n;
        }
        return ret;
    }
    
    public static int[] getDigitAry(int v){
        String nString=Integer.toString(v);
        char[] charAry = nString.toCharArray();
        int[] ret=new int[charAry.length];
        for(int i=0;i<ret.length;++i){
            ret[i]=charAry[i]-'0';
        }
        return ret;
    }

}
