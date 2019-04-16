import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int ringLen = ring.length();

        Map<Character,Set<Integer>> charToIdxSetMap = createCharToIdxSetMap(ring);
        
        Map<Integer,Integer> idxToStepMap = new HashMap<>();
        idxToStepMap.put(0,0);
        
        char[] keyCharAry = key.toCharArray();
        for(char keyChar : keyCharAry){
            idxToStepMap = update(keyChar,idxToStepMap,charToIdxSetMap,ringLen);
        }
        
        int ret = Integer.MAX_VALUE;
        for(Integer step : idxToStepMap.values()){
            ret = Math.min(ret,step);
        }
        return ret;
    }
    
    public static Map<Character,Set<Integer>> createCharToIdxSetMap(String ring){
        HashMap<Character,Set<Integer>> ret = new HashMap<>();
    
        char[] ringCharArray = ring.toCharArray();
        int ringCharArrayLen = ringCharArray.length;
        for(int i=0;i<ringCharArrayLen;++i){
            char lhs = ringCharArray[(i+ringCharArrayLen-1)%ringCharArrayLen];
            char rhs = ringCharArray[(i+ringCharArrayLen+1)%ringCharArrayLen];
            char me = ringCharArray[i];
            if((i!=0)&&(lhs==me)&&(rhs==me))continue;
            if(!ret.containsKey(me)){
                ret.put(me,new HashSet<Integer>());
            }
            ret.get(me).add(i);
        }
        
        return ret;
    }
    
    public static Map<Integer,Integer> update(char keyChar,Map<Integer,Integer> idxToStepMap, Map<Character,Set<Integer>> charToIdxSetMap,int ringLen){
        Map<Integer,Integer> nextIdxToStepMap = new HashMap<>();

        Set<Integer> nextIdxSet = charToIdxSetMap.get(keyChar);
        for(int nextIdx : nextIdxSet){
            int nextStep = Integer.MAX_VALUE;
            for(Map.Entry<Integer,Integer> idxToStepEntry : idxToStepMap.entrySet()){
                int idx = idxToStepEntry.getKey();
                int step = idxToStepEntry.getValue();
                int step0 = (idx+ringLen-nextIdx)%ringLen;
                int step1 = (nextIdx+ringLen-idx)%ringLen;
                step += Math.min(step0,step1);
                step += 1;
                nextStep = Math.min(nextStep,step);
            }
            nextIdxToStepMap.put(nextIdx,nextStep);
        }

        return nextIdxToStepMap;
    }
}
