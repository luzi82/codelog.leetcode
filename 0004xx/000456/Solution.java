import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// wrong answer: {8,10,4,6,5}

class Solution {
    public boolean find132pattern(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        TreeMap<Integer,Integer> minToMaxMap = new TreeMap<>();
        
        for(int n:nums){
            Map.Entry<Integer,Integer> rangeEntry = minToMaxMap.floorEntry(n);
            if((rangeEntry!=null)&&(rangeEntry.getValue()>n)){
                return true;
            }
            if(n<min){
                min = n;
                max = Integer.MIN_VALUE;
            }else if (n>max){
                max = n;
                minToMaxMap.put(min+1,max);
                LinkedList<Integer> rmKeyList = new LinkedList<>();
                for(Map.Entry<Integer,Integer> re:minToMaxMap.tailMap(min+1,false).entrySet()){
                    if(re.getValue()>max)break;
                    rmKeyList.addLast(re.getKey());
                }
                for(Integer rmKey:rmKeyList){
                    minToMaxMap.remove(rmKey);
                }
            }
        }
        
        return false;
    }
}
