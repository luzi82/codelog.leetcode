import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<=0)return false;
        if(t<0)return false;
    
        TreeSet<Long> lastKValue=new TreeSet<>();
        HashMap<Long,Integer> vToCount = new HashMap<>();
        
        for(int i=0;i<nums.length;++i){
            if(i-k-1>=0){reduceValue(nums[i-k-1],lastKValue,vToCount);}
            long numsi = nums[i];
            //System.out.println(Test.join(lastKValue.toArray(new Long[0])));
            if(!lastKValue.subSet(numsi-t,true,numsi+t,true).isEmpty())return true;
            addValue(numsi,lastKValue,vToCount);
        }
        
        return false;
    }
    
    static void reduceValue(long i, TreeSet<Long> lastKValue, HashMap<Long,Integer> vToCount){
        int count = vToCount.containsKey(i)?vToCount.get(i):0;
        --count;
        vToCount.put(i,count);
        if(count==0){
            lastKValue.remove(i);
        }else{
            lastKValue.add(i);
        }
    }
    
    static void addValue(long i, TreeSet<Long> lastKValue, HashMap<Long,Integer> vToCount){
        int count = vToCount.containsKey(i)?vToCount.get(i):0;
        ++count;
        vToCount.put(i,count);
        if(count==0){
            lastKValue.remove(i);
        }else{
            lastKValue.add(i);
        }
    }
}
