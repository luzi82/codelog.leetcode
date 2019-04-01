import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int primePalindrome(int N) {
        if(N==1)return 2;
        if((N>=8)&&(N<=11))return 11; 

        int nLen = getLen(N);
        
        int nLhsSize = (nLen+1)/2;
        int nLhsMin = getLhs(N, nLhsSize);

        int retLen = nLen;
        while(true){
            if(retLen%2==1){ // old
                // assume N = 123
                int retLhsLen = (retLen+1)/2; // 2
                int retLhs;
                if(retLen==nLen){
                    retLhs = nLhsMin; // 12
                }else{
                    retLhs = get100(retLhsLen); // 100
                }
                int retLhsMax = get100(retLhsLen+1); // 100, 1000
                for(;retLhs<retLhsMax;++retLhs){
                    int ret = getPalindromeOdd(retLhs); // 121, 10001
                    if(ret<N)continue; // ignore 121, go 131
                    if(isPrime(ret))return ret;
                }
            }else{ // even
                // only 11 is good

//                // assume N = 1234
//                int retLhsLen = retLen/2; // 2
//                int retLhs;
//                if(retLen==nLen){
//                    retLhs = nLhsMin; // 12
//                }else{
//                    retLhs = get100(retLhsLen); // 100
//                }
//                int retLhsMax = get100(retLhsLen+1); // 100, 1000
//                for(;retLhs<retLhsMax;++retLhs){
//                    int ret = getPalindromeEven(retLhs); // 1221, 10000001
//                    if(ret<=N)continue; // ignore 1221, go 1331
//                    if(isPrime(ret))return ret;
//                }
            }
            ++retLen;
        }
    }
    
    public static int getLen(int v){
        return Integer.toString(v).length();
    }
    
    public static int getLhs(int v,int len){
        String vStr = Integer.toString(v);
        return Integer.parseInt(vStr.substring(0,len));
    }
    
    public static int get100(int len){
        int ret = 1;
        for(int i=1;i<len;++i){
            ret*=10;
        }
        return ret;
    }
    
    public static int getPalindromeOdd(int v){
        String vStr = Integer.toString(v);
        if(vStr.length()==1)return v;
        String vStrRev = rev(vStr);
        String retStr = vStr + vStrRev.substring(1);
        return Integer.parseInt(retStr);
    }
    
    public static int getPalindromeEven(int v){
        String vStr = Integer.toString(v);
        String vStrRev = rev(vStr);
        String retStr = vStr + vStrRev;
        return Integer.parseInt(retStr);
    }
    
    public static String rev(String s){
        char[] cAry = s.toCharArray();
        char[] ret = new char[cAry.length];
        for(int i=0;i<cAry.length;++i){
            ret[i] = cAry[cAry.length-1-i];
        }
        return new String(ret);
    }
    
    /////

    static int primeNextTest = 3;
    static HashSet<Integer> primeSet = new HashSet<Integer>();
    static LinkedList<Integer> primeList = new LinkedList<Integer>();
    static {primeSet.add(2);primeList.add(2);}
    static boolean isPrime(int v){
        if(v<=1)return false;
        if(primeSet.contains(v))return true;
        for(int p:primeList){
            if(v%p==0)return false;
            if(p*p>v){
                primeSet.add(v);
                return true;
            }
        }
        while(true){
            boolean pntIsPrime = true;
            if(!primeSet.contains(primeNextTest)){
                for(int p:primeList){
                    if(primeNextTest%p==0){
                        pntIsPrime = false;
                        break;
                    }
                    if(p*p>primeNextTest)break;
                }
                if(pntIsPrime){
                    primeSet.add(primeNextTest);
                }
            }
            if(pntIsPrime){
                primeList.add(primeNextTest);
            }
            int pnt=primeNextTest;
            ++primeNextTest;
            if(v%pnt==0)return false;
            if(pnt*pnt>v){
                primeSet.add(v);
                return true;
            }
        }
    }

}
