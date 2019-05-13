import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> max3Set = new TreeSet<Integer>();
        for(int n:nums){
            max3Set.add(n);
            while(max3Set.size()>3){
                max3Set.pollFirst();
            }
        }
        
        if(max3Set.size()==3){
            return max3Set.pollFirst();
        }else{
            return max3Set.pollLast();
        }
    }
}
