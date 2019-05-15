import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer,HashSet<Integer>> xToYSetMap = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> yToXSetMap = new HashMap<>();
        
        for(int[] xy:points){
            int x=xy[0];int y=xy[1];
            if(!xToYSetMap.containsKey(x)){
                xToYSetMap.put(x,new HashSet<Integer>());
            }
            xToYSetMap.get(x).add(y);
            if(!yToXSetMap.containsKey(y)){
                yToXSetMap.put(y,new HashSet<Integer>());
            }
            yToXSetMap.get(y).add(x);
        }
        
        int ret = Integer.MAX_VALUE;
        for(Map.Entry<Integer,HashSet<Integer>> xToYSet:xToYSetMap.entrySet()){
            int x0 = xToYSet.getKey();
            HashSet<Integer> ySet = xToYSet.getValue();
            for(int y0:ySet){
                HashSet<Integer> x1Set = yToXSetMap.get(y0);
                for(int y1:ySet){
                    if(y1<=y0)continue;
                    HashSet<Integer> xx1Set = yToXSetMap.get(y1);
                    for(int x1:x1Set){
                        if(x1==x0)continue;
                        if(!xx1Set.contains(x1))continue;
                        int a = Math.abs((x1-x0)*(y1-y0));
                        ret = Math.min(a,ret);
                    }
                }
            }
        }
        
        if(ret==Integer.MAX_VALUE)ret=0;
        
        return ret;
    }
    
}
