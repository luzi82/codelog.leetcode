import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public class MN{
        int m;int n;
        MN(int m,int n){this.m=m;this.n=n;}
        public int hashCode(){
            return Objects.hash(this.m,this.n);
        }
        public boolean equals(Object other){
            if(!(other instanceof MN))return false;
            MN otherMn = (MN)other;
            if(this.m!=otherMn.m)return false;
            if(this.n!=otherMn.n)return false;
            return true;
        }
    }

    public int smallestRepunitDivByK(int K) {
        if(K==1)return 1;
        int n = 1;
        int ret = 1;
        int mod = 1;
        HashSet<MN> mnHash=new HashSet<>();
        mnHash.add(new MN(mod,n));
        while(true){
            ++ret;
            n*=10;
            n%=K;
            mod += n;
            mod %= K;
            //System.err.println(""+mod+" "+n);
            if(mod==0)return ret;
            MN mn=new MN(mod,n);
            if(mnHash.contains(mn))return -1;
            mnHash.add(mn);
        }
    }
}
