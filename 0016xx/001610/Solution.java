import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public static double ESL = 0.0000001;

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
      double detectRange = angle * Math.PI / 180;
      detectRange+=ESL;

      int zeroCnt = 0;

      TreeMap<Double,Integer> directionToCountMap = new TreeMap<>();
      for(List<Integer> point:points){
        double direction = getDirection(point, location);
        if(direction==-100){
          ++zeroCnt;
        }else if(directionToCountMap.get(direction)==null){
          directionToCountMap.put(direction,1);
          directionToCountMap.put(direction+Math.PI*2,1);
        }else{
          int c = directionToCountMap.get(direction);
          directionToCountMap.put(direction,c+1);
          directionToCountMap.put(direction+Math.PI*2,c+1);
        }
      }

      int total = 0;
      TreeMap<Double,Integer> directionToTotalMap = new TreeMap<>();
      for(double direction:directionToCountMap.keySet()){
        total += directionToCountMap.get(direction);
        directionToTotalMap.put(direction,total);
      }

      // for(Map.Entry<Double,Integer> me:directionToTotalMap.entrySet()){
      //   System.err.println(String.format("d=%f, c=%d",me.getKey(),me.getValue()));
      // }

      int ret = 0;
      for(double direction:directionToTotalMap.keySet()){
        if(direction>Math.PI*2)break;
        double direction2 = direction+detectRange;
        int t0 = directionToTotalMap.get(direction);
        int t1 = directionToTotalMap.headMap(direction2, true).lastEntry().getValue();
        int c = t1-t0;
        c += directionToCountMap.get(direction);
        ret = Math.max(ret,c);
      }

      ret += zeroCnt;

      return ret;
    }

    double getDirection(List<Integer> point,List<Integer> location){
      int x = point.get(0)-location.get(0);
      int y = point.get(1)-location.get(1);
      if(x==0&&y==0){
        return -100;
      }
      return Math.atan2(y, x);
    }
}
