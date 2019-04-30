import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int countPrimes(int n) {
        if(n<=2)return 0;
        preparePrime(n);
        // bin searcy
        if(n>primeV.get(primeV.size()-1))return primeV.size();
        int startIdx=0,endIdx=primeV.size();
        while(true){
            int mIdx = (startIdx+endIdx-1)/2;
            if(primeV.get(mIdx)==n){return mIdx;}
            if(primeV.get(mIdx)<n && n<primeV.get(mIdx+1)){return mIdx+1;}
            if(primeV.get(mIdx)<n){startIdx=mIdx+1;}
            if(primeV.get(mIdx)>n){endIdx=mIdx;}
        }
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
