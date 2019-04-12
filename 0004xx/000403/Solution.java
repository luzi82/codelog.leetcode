import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean canCross(int[] stones) {
        // build posToFromLenSetMap
        HashMap<Integer,HashSet<Integer>> posToFromLenSetMap=new HashMap<>();
        for(int pos:stones){
            posToFromLenSetMap.put(pos,new HashSet<Integer>());
        }
        
        posToFromLenSetMap.get(0).add(0);
        
        for(int pos:stones){
            HashSet<Integer> fromLenSet = posToFromLenSetMap.get(pos);
            for(int fromLen : fromLenSet){
                for(int diff=-1;diff<=1;++diff){
                    int len = fromLen+diff;
                    if(len>0){
                        int nextPos = pos + len;
                        if(posToFromLenSetMap.containsKey(nextPos)){
                            posToFromLenSetMap.get(nextPos).add(len);
                        }
                    }
                }
            }
        }
        
        return posToFromLenSetMap.get(stones[stones.length-1]).size() > 0;
    }
}
