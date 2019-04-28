import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel>=target)return 0;
    
        int stationDFCount = stations.length;
        
        int[] distanceAry = new int[stationDFCount+1];
        distanceAry[0] = startFuel;
        int distanceDone = 1;

        for(int s=0;s<stationDFCount;++s){
            int stationD = stations[s][0];
            int stationF = stations[s][1];
            for(int dIdx = distanceDone-1; dIdx>=0; --dIdx){
                if(distanceAry[dIdx] < stationD)break; // no fuel
                if(distanceAry[dIdx] >= target)continue; // skip
                int nextD = distanceAry[dIdx] + stationF;
                if( nextD > distanceAry[dIdx+1] ){
                    distanceAry[dIdx+1] = nextD;
                    distanceDone = Math.max(distanceDone, dIdx+2);
                }
            }
        }
        
        for(int dIdx=0;dIdx<distanceDone;++dIdx){
            if(distanceAry[dIdx]>=target)return dIdx;
        }
        return -1;
    }
}
