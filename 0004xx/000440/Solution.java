import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int findKthNumber(int n, int k) {
        if(n<10)return k;
        
        --k;

        int[] nDigitAry=getDigitAry(n);
        
        int a1111 = (nDigitAry[0]-1)*nnnn(1,nDigitAry.length);
        if(k<a1111){
            int n1111 = nnnn(1,nDigitAry.length);
            String lhs = ""+(1+k/n1111);
            String rhs = getRhs(k%n1111,nDigitAry.length-1);
            return Integer.parseInt(lhs+rhs);
        }
        k-=a1111;
        if(k==0){
            return Integer.parseInt(Integer.toString(n).substring(0,1));
        }
        --k;
        
        for(int i=1;i<nDigitAry.length;++i){
            int v1111 = (nDigitAry[i])*nnnn(1,nDigitAry.length-i);
            if(k<v1111){
                int n1111 = nnnn(1,nDigitAry.length-i);
                String lhs = Integer.toString(n).substring(0,i);
                String mhs = ""+(k/n1111);
                String rhs = getRhs(k%n1111,nDigitAry.length-i-1);
                return Integer.parseInt(lhs+mhs+rhs);
            }
            k-=v1111;
            if(k==0){
                return Integer.parseInt(Integer.toString(n).substring(0,1+i));
            }
            --k;
        }
        
        for(int i=1;i<nDigitAry.length;++i){
            int i111 = nnnn(1,i);
            int max = (9-nDigitAry[nDigitAry.length-1-i])*i111;
            //System.out.println("max="+max);
            if(k<max){
                String lhs = Integer.toString(n).substring(0,nDigitAry.length-1-i);
                String mhs = ""+((nDigitAry[nDigitAry.length-1-i]+1)+k/i111);
                String rhs = getRhs(k%i111,i-1);
                //System.out.println(lhs+" "+mhs+" "+rhs+" "+(k%i111));
                return Integer.parseInt(lhs+mhs+rhs);
            }
            k-=max;
        }

        return 0;
    }
    
    public static String getRhs(int k,int len){
        if(k==0)return "";
        if(len==0)return "";
        --k;
        int i111 = nnnn(1,len);
        String lhs = ""+(k/i111);
        String rhs = getRhs(k%i111,len-1);
        return lhs+rhs;
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
