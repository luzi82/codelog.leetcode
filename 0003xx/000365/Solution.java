import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z>x+y)return false;
        if(z==x)return true;
        if(z==y)return true;
        if(z==x+y)return true;
        int gcdxy = gcd(x,y);
        if(z%gcdxy!=0)return false;
        return true;
    }
    
    public int gcd(int a,int b){
        if(a>b)return gcd(b,a);
        while(true){
            if(a==0)return b;
            int t=b%a;
            b=a;a=t;
        }
    }
}
