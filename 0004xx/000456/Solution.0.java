import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// wrong answer: {8,10,4,6,5}

class Solution {
    public boolean find132pattern(int[] nums) {
        int n1 = Integer.MAX_VALUE;
        int n1x = Integer.MAX_VALUE;
        int n3 = Integer.MIN_VALUE;
        
        for(int n:nums){
            if(n1<n && n<n3)return true;
            if(n<n1x){
                n1x=n;
            }else if(n>n3){
                n3=n;
                n1=n1x;
            }
        }
        
        return false;
    }
}
