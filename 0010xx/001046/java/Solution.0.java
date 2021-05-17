import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        TreeMap<Integer,Integer> sizeToCountMap = new TreeMap<>();
        for(int stone:stones){
            int count=1;
            if(sizeToCountMap.containsKey(stone)){
                count = sizeToCountMap.get(stone)+1;
            }
            sizeToCountMap.put(stone,count);
        }
        
        int remain = stones.length;
        while(remain>=2){
            Map.Entry<Integer,Integer> lastE = sizeToCountMap.lastEntry();
            int y,x;
            if(lastE.getValue()>2){
                y = lastE.getKey();
                x = lastE.getKey();
                sizeToCountMap.put(y,lastE.getValue()-2);
            }else if(lastE.getValue()==2){
                y = lastE.getKey();
                x = lastE.getKey();
                sizeToCountMap.remove(y);
            }else{
                y = lastE.getKey();
                sizeToCountMap.remove(y);
                lastE = sizeToCountMap.lastEntry();
                x = lastE.getKey();
                if(lastE.getValue()>1){
                    sizeToCountMap.put(x,lastE.getValue()-1);
                }else{
                    sizeToCountMap.remove(x);
                }
            }
            int d = y-x;
            if(d>0){
                int dCount = 1;
                if(sizeToCountMap.containsKey(d)){
                    dCount = sizeToCountMap.get(d)+1;
                }
                sizeToCountMap.put(d,dCount);
                --remain;
            }else{
                remain-=2;
            }
        }
        
        if(remain==0)return 0;
        return sizeToCountMap.lastKey();
    }
}
