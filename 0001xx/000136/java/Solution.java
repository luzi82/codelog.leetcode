import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> vSet = new HashSet<Integer>();
        for(int n:nums){
            if(vSet.contains(n)){
                vSet.remove(n);
            }else{
                vSet.add(n);
            }
        }
        for(int v:vSet){
            return v;
        }
        return -1;
    }
}
