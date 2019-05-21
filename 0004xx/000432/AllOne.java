import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class AllOne {

    HashMap<String,Integer> keyToCountMap = new HashMap<>();
    HashMap<Integer,HashSet<String>> countToKeySetMap = new HashMap<>();
    HashMap<Integer,Integer> countToLessCountMap = new HashMap<>();
    HashMap<Integer,Integer> countToMoreCountMap = new HashMap<>();

    /** Initialize your data structure here. */
    public AllOne() {
        link(0,Integer.MAX_VALUE);
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int oldCount = this.getCount(key);
        int newCount = oldCount+1;
        int oldLess=0;
        if(oldCount>0){
            oldLess = countToLessCountMap.get(oldCount);
        }
        int oldMore=countToMoreCountMap.get(oldCount);
        int newLess = oldLess;
        if(oldCount>0){
            HashSet<String> oldKeySet = countToKeySetMap.get(oldCount);
            oldKeySet.remove(key);
            if(oldKeySet.size()==0){
                link(oldLess,oldMore);
            }else{
                newLess = oldCount;
            }
        }
        if(!countToKeySetMap.containsKey(newCount)){
            countToKeySetMap.put(newCount,new HashSet<>());
        }
        HashSet<String> newKeySet = countToKeySetMap.get(newCount);
        newKeySet.add(key);
        if(newCount!=oldMore){
            link(newCount,oldMore);
        }
        link(newLess,newCount);
        setCount(key,newCount);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        int oldCount = this.getCount(key);
        if(oldCount==0)return;
        int newCount = oldCount-1;
        int oldLess = countToLessCountMap.get(oldCount);
        int oldMore = countToMoreCountMap.get(oldCount);

        HashSet<String> oldKeySet = countToKeySetMap.get(oldCount);
        oldKeySet.remove(key);
        int newMore = oldMore;
        if(oldKeySet.size()==0){
            link(oldLess,oldMore);
        }else{
            newMore = oldCount;
        }

        if(newCount>0){
            HashSet<String> newKeySet = countToKeySetMap.get(newCount);
            newKeySet.add(key);
        }
        if(newCount!=oldLess){
            link(oldLess,newCount);
        }
        link(newCount,newMore);
        setCount(key,newCount);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        int count = countToLessCountMap.get(Integer.MAX_VALUE);
        if(count==0)return "";
        for(String s:countToKeySetMap.get(count)){
            return s;
        }
        return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        int count = countToMoreCountMap.get(0);
        if(count==Integer.MAX_VALUE)return "";
        for(String s:countToKeySetMap.get(count)){
            return s;
        }
        return "";
    }
    
    private int getCount(String key){
        if(!keyToCountMap.containsKey(key)){
            return 0;
        }
        return keyToCountMap.get(key);
    }
    
    private void setCount(String key,int count){
        if(count==0){
            keyToCountMap.remove(key);
            return;
        }
        keyToCountMap.put(key,count);
    }
    
    private void link(int less,int more){
        countToLessCountMap.put(more,less);
        countToMoreCountMap.put(less,more);
    }
}
