import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class RandomizedSet {
    
    HashMap<Integer,Integer> idxToVMap = new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> vToIdxMap = new HashMap<Integer,Integer>();
    Random random=new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(vToIdxMap.containsKey(val)){return false;}
        int idx = idxToVMap.size();
        idxToVMap.put(idx,val);
        vToIdxMap.put(val,idx);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!vToIdxMap.containsKey(val)){return false;}
        int lastIdx = idxToVMap.size()-1;
        int idx = vToIdxMap.get(val);
        if(idx==lastIdx){
            idxToVMap.remove(idx);
            vToIdxMap.remove(val);
        }else{
            int lastVal = idxToVMap.get(lastIdx);
            idxToVMap.remove(lastIdx);
            vToIdxMap.remove(val);
            idxToVMap.put(idx,lastVal);
            vToIdxMap.put(lastVal,idx);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = random.nextInt(idxToVMap.size());
        return idxToVMap.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 