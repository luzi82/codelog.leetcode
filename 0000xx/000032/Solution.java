import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int longestValidParentheses(String s) {
        char[] cAry = s.toCharArray();
        int ret = 0;
    
        HashMap<Integer,Integer> layerToIdx = new HashMap<>();
        int layer = 0;
        layerToIdx.put(0,0);
        for(int i=0;i<cAry.length;++i){
            char c = cAry[i];
            if(c=='('){
                ++layer;
                layerToIdx.put(layer,i+1);
            }else{
                --layer;
                if(layerToIdx.containsKey(layer)){
                    int idx = layerToIdx.get(layer);
                    int len = i+1-idx;
                    if(len>ret)ret=len;
                }else{
                    layerToIdx.put(layer,i+1);
                }
            }
        }
        
        return ret;
    }
}
