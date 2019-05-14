import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// pass, but too complex

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        --k;
        
        // create n > count map, sorted
        TreeMap<Integer,Integer> nToCountMap=createNToCountMap(nums);
        
        // do bin search
        int min = 0;
        int max = nToCountMap.lastKey() - nToCountMap.firstKey();
        ++max;
        
        while(true){
            int mid = (min+max-1)/2;
            //System.err.println(String.format("%d %d %d",min,mid,max));
            int[] rankRange = getRankRange(mid,nToCountMap);
            //System.err.println(String.format("rankRange=[%d,%d)",rankRange[0],rankRange[1]));
            if(k<rankRange[0]){max=mid;}
            else if(k<rankRange[1]){return mid;}
            else{min=mid+1;}
        }
    }
    
    public static TreeMap<Integer,Integer> createNToCountMap(int[] nums){
        TreeMap<Integer,Integer> nToCountMap=new TreeMap<Integer,Integer>();
        for(int n:nums){
            int count = nToCountMap.containsKey(n)?nToCountMap.get(n):0;
            ++count;
            nToCountMap.put(n,count);
        }
        return nToCountMap;
    }
    
    public static int[] getRankRange(int len,TreeMap<Integer,Integer> nToCountMap){
        //System.err.println(String.format("getRankRange, len=%d",len));
        if(len==0){
            int count = 0;
            for(Map.Entry<Integer,Integer>e:nToCountMap.entrySet()){
                int c = e.getValue();
                count += c*(c-1)/2;
            }
            return new int[]{0,count};
        }
        Iterator<Map.Entry<Integer,Integer>> i=nToCountMap.entrySet().iterator();
        Iterator<Map.Entry<Integer,Integer>> j=nToCountMap.entrySet().iterator();
        Map.Entry<Integer,Integer> ie = i.next();
        j.next();
        Map.Entry<Integer,Integer> je = j.next();
        int lessCount = ie.getValue()*(ie.getValue()-1)/2;
        int eqCount = 0;
        int midCount = 0;
        while(true){
            int diff = je.getKey() - ie.getKey();
            //System.err.println(String.format("i=%d, j=%d, diff=%d, midCount=%d",ie.getKey(),je.getKey(),diff,midCount));
            if(diff==0){
                lessCount += je.getValue()*(je.getValue()-1)/2;
                // move j
                midCount += je.getValue();
                if(!j.hasNext())break;
                je = j.next();
            }else if(diff<len){
                lessCount += je.getValue()*ie.getValue();
                lessCount += je.getValue()*midCount;
                lessCount += je.getValue()*(je.getValue()-1)/2;
                // move j
                midCount += je.getValue();
                if(!j.hasNext())break;
                je = j.next();
            }else if(diff==len){
                eqCount += je.getValue()*ie.getValue();
                // move i
                ie = i.next();
                midCount -= ie.getValue();
            }else{
                // move i
                ie = i.next();
                midCount -= ie.getValue();
            }
            //System.err.println(String.format("lessCount=%d, eqCount=%d",lessCount,eqCount));
        }
        return new int[]{lessCount,lessCount+eqCount};
    }
}
