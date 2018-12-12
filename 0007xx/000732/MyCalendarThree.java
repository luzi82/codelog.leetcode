import java.util.*;
import java.lang.*;

class MyCalendarThree {

    TreeMap<Integer,Integer> countMap=new TreeMap<>();
    int maxCount = 0;

    public MyCalendarThree() {
        countMap.put(Integer.MIN_VALUE,0);
    }
    
    public int book(int start, int end) {
        // add start if not exist
        if(!countMap.containsKey(start)){
            int floorValue = countMap.floorEntry(start).getValue();
            countMap.put(start,floorValue);
        }
        
        // add end if not exist
        if(!countMap.containsKey(end)){
            int floorValue = countMap.floorEntry(end).getValue();
            countMap.put(end,floorValue);
        }
        
        // [start, end) ++, update maxCount
        SortedMap<Integer,Integer> countMapSub = countMap.tailMap(start);
        countMapSub = countMapSub.headMap(end);
        for(Map.Entry<Integer,Integer> me:countMapSub.entrySet()){
            int value = me.getValue();
            ++value;
            me.setValue(value);
            maxCount = Math.max(value,maxCount);
        }
        
        // return
        return maxCount;
    }
    
    public static void main(String[] argv){
        // test case from example
        MyCalendarThree nct = new MyCalendarThree();
        
        int ret;
        ret = nct.book(10,20);
        aassert(ret==1);
        ret = nct.book(50,60);
        aassert(ret==1);
        ret = nct.book(10,40);
        aassert(ret==2);
        ret = nct.book(5,15);
        aassert(ret==3);
        ret = nct.book(5,10);
        aassert(ret==3);
        ret = nct.book(25,55);
        aassert(ret==3);
        
    }

    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
 