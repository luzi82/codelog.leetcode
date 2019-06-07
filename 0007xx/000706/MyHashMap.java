import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class MyHashMap {

    int[][] valueAryAry;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        valueAryAry = new int[1000][];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int k0 = key/1000;
        int k1 = key%1000;
        if(valueAryAry[k0]==null){
            valueAryAry[k0] = new int[1000];
            for(int i=0;i<1000;++i){
                valueAryAry[k0][i] = -1;
            }
        }
        valueAryAry[k0][k1]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int k0 = key/1000;
        int k1 = key%1000;
        if(valueAryAry[k0]==null) return -1;
        return valueAryAry[k0][k1];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int k0 = key/1000;
        int k1 = key%1000;
        if(valueAryAry[k0]==null)return;
        valueAryAry[k0][k1] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
