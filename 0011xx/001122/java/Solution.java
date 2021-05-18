import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> cntMap=new HashMap<>();
        for(int v:arr2){
            cntMap.put(v,0);
        }
        
        Vector<Integer> remainAry=new Vector<>();
        for(int i=0;i<arr1.length;++i){
            int v=arr1[i];
            if(cntMap.containsKey(v)){
                int cnt=cntMap.get(v)+1;
                cntMap.put(v,cnt);
            }else{
                remainAry.add(v);
            }
        }
        
        int[] ret = new int[arr1.length];
        int idx=0;
        for(int v:arr2){
            int cnt=cntMap.get(v);
            for(int i=0;i<cnt;++i){
                ret[idx++]=v;
            }
        }
        
        Integer[] remainA = remainAry.toArray(new Integer[0]);
        Arrays.sort(remainA);
        for(int v:remainA){
            ret[idx++]=v;
        }
        
        return ret;
    }
}
