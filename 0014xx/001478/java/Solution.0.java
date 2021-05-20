import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);

        int houseCnt = houses.length;
        int boxCnt = k;
        
        int[][] boxDoneToHouseDoneToDistAryAry = new int[boxCnt+1][houseCnt+1];
        for(int boxDone=0;boxDone<=boxCnt;++boxDone){
            for(int houseDone=0;houseDone<=houseCnt;++houseDone){
                boxDoneToHouseDoneToDistAryAry[boxDone][houseDone]=Integer.MAX_VALUE;
            }
        }

        // fill boxDoneToHouseDoneToDistAryAry[1][*]
        boxDoneToHouseDoneToDistAryAry[1][1] = 0;

        int leftPtr = 1;
        int midPtr = 1;
        int rightPtr = 1;
        int d = 0;
        while(true){
            ++rightPtr;
            if(rightPtr>houseCnt)break;
            d += houses[rightPtr-1];
            d -= houses[midPtr-1];
            boxDoneToHouseDoneToDistAryAry[1][rightPtr] = d;
            ++rightPtr;
            if(rightPtr>=houseCnt)break;
            ++midPtr;
            d += houses[rightPtr-1];
            d -= houses[midPtr-1];
            boxDoneToHouseDoneToDistAryAry[1][rightPtr] = d;
        }
        
        for(int boxDone=2;boxDone<=boxCnt;++boxDone){
            for(int houseDone0=boxDone-1;houseDone0<=houseCnt-1;++houseDone0){
                d = boxDoneToHouseDoneToDistAryAry[boxDone-1][houseDone0];
                boxDoneToHouseDoneToDistAryAry[boxDone][houseDone0+1] = Math.min(boxDoneToHouseDoneToDistAryAry[boxDone][houseDone0+1],d);
                leftPtr = midPtr = rightPtr = houseDone0+1;
                while(true){
                    ++rightPtr;
                    if(rightPtr>houseCnt)break;
                    d += houses[rightPtr-1];
                    d -= houses[midPtr-1];
                    boxDoneToHouseDoneToDistAryAry[boxDone][rightPtr] = Math.min(boxDoneToHouseDoneToDistAryAry[boxDone][rightPtr],d);
                    ++rightPtr;
                    if(rightPtr>houseCnt)break;
                    ++midPtr;
                    d += houses[rightPtr-1];
                    d -= houses[midPtr-1];
                    boxDoneToHouseDoneToDistAryAry[boxDone][rightPtr] = Math.min(boxDoneToHouseDoneToDistAryAry[boxDone][rightPtr],d);
                }
            }
        }
        
        return boxDoneToHouseDoneToDistAryAry[boxCnt][houseCnt];
    }
}
