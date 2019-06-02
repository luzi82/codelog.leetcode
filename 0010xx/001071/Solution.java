import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length()==0)return "";
        if(str2.length()==0)return "";
        
        int lenGcd = gcd(str1.length(),str2.length());
        String ret = str1.substring(0,lenGcd);

        char[] retCharArray = ret.toCharArray();
        char[] str1CharArray = str1.toCharArray();
        char[] str2CharArray = str2.toCharArray();
        
        for(int i=0;i<str1CharArray.length;++i){
            if(str1CharArray[i]!=retCharArray[i%retCharArray.length])return "";
        }
        for(int i=0;i<str2CharArray.length;++i){
            if(str2CharArray[i]!=retCharArray[i%retCharArray.length])return "";
        }
        
        return ret;
    }
    
    public int gcd(int a,int b){
        if(a>b)return gcd(b,a);
        while(a>0){
            int t = b%a;
            b=a;
            a=t;
        }
        return b;
    }
}