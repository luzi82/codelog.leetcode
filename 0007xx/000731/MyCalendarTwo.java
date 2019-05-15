import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class MyCalendarTwo {

    TreeMap<Integer,Integer> startToCount = new TreeMap<>();
    
    public MyCalendarTwo() {
        startToCount.put(0,0);
    }
    
    public boolean book(int start, int end) {
        TreeMap<Integer,Integer> newStartToCount = new TreeMap<>();

        Map.Entry<Integer,Integer> startEntry = startToCount.floorEntry(start);
        int startCount = startEntry.getValue()+1;
        if(startCount>=3)return false;
        newStartToCount.put(start,startCount);
        
        Map.Entry<Integer,Integer> endEntry = startToCount.floorEntry(end);
        int endCount = endEntry.getValue();
        newStartToCount.put(end,endCount);
        
        SortedMap<Integer,Integer> subMap = startToCount.tailMap(start).headMap(end);
        for(Map.Entry<Integer,Integer> subMapEntry:subMap.entrySet()){
            int count = subMapEntry.getValue()+1;
            if(count>=3)return false;
            newStartToCount.put(subMapEntry.getKey(),count);
        }
        
        startToCount.putAll(newStartToCount);
        
        return true;
    }
}
