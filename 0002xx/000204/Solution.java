import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int countPrimes(int n) {
        if(n<=2)return 0;
        preparePrime(n);
        // bin search
        int idx = Collections.binarySearch(primeV,n);
        if(idx<0){idx=-idx-1;}
        return idx;
    }

    static Vector<Integer> primeV=new Vector<Integer>();
    // cal all prime [2,max)
    static void preparePrime(int max){
        if(primeV.size()==0){
            primeV.add(2);
            primeV.add(3);
        }
        int p=primeV.lastElement()+2;
        while(p<max){
            boolean isPrime=true;
            for(int pp:primeV){
                if(p%pp==0){isPrime=false;break;}
                if(pp*pp>p){break;}
            }
            if(isPrime){
                primeV.add(p);
            }
            p+=2;
        }
    }
}
