import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);

        int houseCnt = houses.length;
        int boxCnt = k;
        
        int[] houseDoneToDistAry = new int[houseCnt+1];
        int[] nextHouseDoneToDistAry = new int[houseCnt+1];

        for(int houseDone=0;houseDone<=houseCnt;++houseDone){
          houseDoneToDistAry[houseDone] = Integer.MAX_VALUE;
        }
        houseDoneToDistAry[0] = 0;
        
        for(int rBoxDone=0;rBoxDone<boxCnt;++rBoxDone){
          for(int houseDone=0;houseDone<=houseCnt;++houseDone){
            nextHouseDoneToDistAry[houseDone] = Integer.MAX_VALUE;
          }
          for(int rHouseDone=0;rHouseDone<houseCnt;++rHouseDone){
            int distance = houseDoneToDistAry[rHouseDone];
            if(distance>=Integer.MAX_VALUE)continue;
            int rightHouseIdx = rHouseDone;
            int midHouseIdx = rHouseDone;
            while(true){
              if(rightHouseIdx>=houseCnt)break;
              distance += houses[rightHouseIdx];
              distance -= houses[midHouseIdx];
              nextHouseDoneToDistAry[rightHouseIdx+1] = Math.min(nextHouseDoneToDistAry[rightHouseIdx+1],distance);
              ++rightHouseIdx;
              if(rightHouseIdx>=houseCnt)break;
              distance += houses[rightHouseIdx];
              distance -= houses[midHouseIdx];
              nextHouseDoneToDistAry[rightHouseIdx+1] = Math.min(nextHouseDoneToDistAry[rightHouseIdx+1],distance);
              ++rightHouseIdx;
              ++midHouseIdx;
            }
          }
          int[] tmpHouseDoneToDistAry = houseDoneToDistAry;
          houseDoneToDistAry = nextHouseDoneToDistAry;
          nextHouseDoneToDistAry = tmpHouseDoneToDistAry;
        }
        
        return houseDoneToDistAry[houseCnt];
    }
}
