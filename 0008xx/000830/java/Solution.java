import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        LinkedList<List<Integer>> intervalList = new LinkedList<>();
        char[] cAry = s.toCharArray();
        
        char lastC = cAry[0];
        int lastCStart = 0;
        for(int i=1;i<cAry.length;++i){
            if(cAry[i]==lastC)continue;
            int len = i-lastCStart;
            if(len>=3){
                intervalList.add(Arrays.asList(lastCStart,i-1));
            }
            lastC=cAry[i];
            lastCStart=i;
        }
        
        int len = cAry.length-lastCStart;
        if(len>=3){
            intervalList.add(Arrays.asList(lastCStart,cAry.length-1));
        }
        
        return intervalList;
    }
}
