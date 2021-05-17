import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class TimeMap {

    HashMap<String,TreeMap<Integer,String>> keyToTimeStampToValueMapMap = new HashMap<String,TreeMap<Integer,String>>();
    
    /** Initialize your data structure here. */
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keyToTimeStampToValueMapMap.containsKey(key)){
            keyToTimeStampToValueMapMap.put(key,new TreeMap<Integer,String>());
        }
        
        keyToTimeStampToValueMapMap.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!keyToTimeStampToValueMapMap.containsKey(key))return "";
        TreeMap<Integer,String> timeStampToValueMap = keyToTimeStampToValueMapMap.get(key);
        Map.Entry<Integer,String> me = timeStampToValueMap.floorEntry(timestamp);
        if(me==null)return "";
        return me.getValue();
    }
}
