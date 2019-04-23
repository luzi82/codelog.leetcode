import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int len = fronts.length;
        TreeSet<Integer> numSet = new TreeSet<>();
        HashSet<Integer> badSet = new HashSet<>();
        
        for(int i=0;i<len;++i){
            int f=fronts[i];
            int b=backs[i];
            if(f==b){
                badSet.add(f);
            }else{
                numSet.add(f);
                numSet.add(b);
            }
        }
        
        for(Integer v:numSet){
            if(!badSet.contains(v))return v;
        }
        
        return 0;
    }
}
