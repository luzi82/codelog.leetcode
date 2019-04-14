import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums==null)return 0;
        if(nums.length==0)return 0;
    
        TreeMap<Integer,int[]> numToLenCntMap = new TreeMap<>();
        for(int num:nums){
            int len = 0;
            int cnt = 0;

            NavigableMap<Integer,int[]> headMap = numToLenCntMap.headMap(num,false);
            if(!headMap.isEmpty()){
                len = headMap.lastEntry().getValue()[0];
                for(Map.Entry<Integer,int[]> numToLenCntEntry : headMap.descendingMap().entrySet()){
                    if(numToLenCntEntry.getValue()[0]!=len)break;
                    cnt += numToLenCntEntry.getValue()[1];
                }
                ++len;
            }else{
                len=1;cnt=1;
            }

            NavigableMap<Integer,int[]> tailMap = numToLenCntMap.tailMap(num,true);
            LinkedList<Integer> rmKeyList = new LinkedList<>();
            {
                for(Map.Entry<Integer,int[]> numToLenCntEntry : tailMap.entrySet()){
                    if(numToLenCntEntry.getValue()[0]>=len)break;
                    rmKeyList.add(numToLenCntEntry.getKey());
                }
            }
            
            for(Integer rmKey : rmKeyList){
                numToLenCntMap.remove(rmKey);
            }
            
            if(numToLenCntMap.containsKey(num)){
                int[] lenCnt = numToLenCntMap.get(num);
                if(lenCnt[0]<len){throw new Error();}
                else if(lenCnt[0]==len){lenCnt[1]+=cnt;}
                else{}
            }else{
                numToLenCntMap.put(num,new int[]{len,cnt});
            }
        }
        
        int ret = 0;
        int maxLen = numToLenCntMap.lastEntry().getValue()[0];
        for(Map.Entry<Integer,int[]> numToLenCntEntry : numToLenCntMap.descendingMap().entrySet()){
            int[] lenCnt = numToLenCntEntry.getValue();
            if(lenCnt[0]!=maxLen)break;
            ret += lenCnt[1];
        }
        
        return ret;
    }
}
