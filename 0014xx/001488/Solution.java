import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
      int[] ret = new int[rains.length];

      HashSet<Integer> fullLakeSet = new HashSet<>();
      SortedSet<Integer> futureRainDaySet = new TreeSet<>();
      HashMap<Integer,LinkedList<Integer>> lakeIdToRainDayListMap = new HashMap<>();

      // fill lakeIdToRainDayListMap
      // [1,2,0,0,1,2] -> 1:[0,4], 2:[1,5]
      // [1,2,0,1,2]   -> 1:[0,3], 2:[1,4]
      for(int i=0;i<rains.length;++i){
        int rainLake = rains[i];
        if(rainLake==0)continue;
        if(!lakeIdToRainDayListMap.containsKey(rainLake)){
          lakeIdToRainDayListMap.put(rainLake,new LinkedList<Integer>());
        }
        LinkedList<Integer> lakeRainDayList = lakeIdToRainDayListMap.get(rainLake);
        lakeRainDayList.addLast(i);
      }

      // cal rains
      for(int day=0;day<rains.length;++day){
        int rainLake = rains[day];
        if(rainLake==0){
          if(futureRainDaySet.isEmpty()){
            ret[day] = 1;
          }else{
            int nextRainDay = futureRainDaySet.first();
            int nextRainLake = rains[nextRainDay];
            ret[day] = nextRainLake;
            fullLakeSet.remove(nextRainLake);
            futureRainDaySet.remove(nextRainDay);
          }
        }else{
          if(fullLakeSet.contains(rainLake)){
            return new int[0];
          }
          LinkedList<Integer> lakeRainDayList = lakeIdToRainDayListMap.get(rainLake);
          while(true){
            if(lakeRainDayList.isEmpty())break;
            if(lakeRainDayList.getFirst()>day)break;
            lakeRainDayList.removeFirst();
          }
          if(!lakeRainDayList.isEmpty()){
            int nextRainDay = lakeRainDayList.removeFirst();
            futureRainDaySet.add(nextRainDay);
          }
          fullLakeSet.add(rainLake);
          ret[day] = -1;
        }
      }

      // return
      return ret;
    }
}
