import java.lang.AssertionError;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.*;

class Fancy {

    Vector<Integer> originVec = new Vector<>();
    long m = 1;
    long c = 0;
    static final long BIG = 1_000_000_007;
    static final BigInteger BIG_BI = BigInteger.valueOf(BIG);

    public Fancy() {
    }
    
    public void append(int val) {
        val += BIG;
        val -= this.c;
        val %= BIG;

        BigInteger mBi = BigInteger.valueOf(this.m);
        BigInteger mInvBi = mBi.modInverse(BIG_BI);

        BigInteger valBi = BigInteger.valueOf(val);
        valBi = valBi.multiply(mInvBi);
        valBi = valBi.mod(BIG_BI);
        val = valBi.intValue();

        originVec.add(val);
    }
    
    public void addAll(int inc) {
        this.c += inc;
        this.c %= BIG;
    }
    
    public void multAll(int m) {
        this.m *= m;
        this.m %= BIG;
        this.c *= m;
        this.c %= BIG;
    }
    
    public int getIndex(int idx) {
        if(idx>=this.originVec.size())return -1;

        long ret = this.originVec.get(idx);
        ret *= this.m;
        ret += this.c;
        ret %= BIG;
        return (int)ret;
    }
}
