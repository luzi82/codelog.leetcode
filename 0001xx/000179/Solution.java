import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String largestNumber(int[] nums) {
        // handle all zero case
        boolean allZero=true;
        for(int i:nums){
            if(i!=0){allZero=false;break;}
        }
        if(allZero)return "0";
    
        // convert num to string
        String[] numStringAry = new String[nums.length];
        for(int i=0;i<nums.length;++i){
            numStringAry[i] = Integer.toString(nums[i]);
        }

        // special sort
        Arrays.sort(numStringAry,COMP);
        
        // join string
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<numStringAry.length;++i){
            String numString = numStringAry[i];
            sb.append(numString);
        }
        
        // output
        return sb.toString();
    }
    
    public static Comparator<String> COMP = new Comparator<String>(){
        public int compare(String a,String b){
            if(a.equals(b))return 0;
            char[] aCharArrey = a.toCharArray();
            char[] bCharArrey = b.toCharArray();
            int aLen = a.length();
            int bLen = b.length();
            int lcm = aLen*bLen/gcd(aLen,bLen);
            for(int i=0;i<lcm;++i){
                char aChar = aCharArrey[i%aLen];
                char bChar = bCharArrey[i%bLen];
                // bigger first
                if(aChar-bChar!=0)return bChar-aChar;
            }
            return bLen-aLen; // shorter first
        }
    };
    public static int gcd(int a,int b){
        if(a>b)return gcd(b,a);
        if(a==0)return b;
        return gcd(b%a,a);
    }
}
