import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stoneQueue = new PriorityQueue<>();
        for(int stone:stones){
            stoneQueue.add(-stone);
        }
        
        while(stoneQueue.size()>=2){
            int y = -stoneQueue.poll();
            int x = -stoneQueue.poll();
            int d = y-x;
            if(d>0){
                stoneQueue.add(-d);
            }
        }
        
        if(stoneQueue.size()==0)return 0;
        return -stoneQueue.poll();
    }
}
