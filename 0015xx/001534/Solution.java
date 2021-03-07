import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isPossible(int[] target) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // store nagative

        for(int v: target){
          if(v<1)return false;
          sum += v;
          pq.add(-v);
        }

        while(true){
          long v0 = -pq.poll();
          if(v0==1)return true;
          long other = sum - v0;
          if(other==1)return true;
          if(other>=v0)return false;
          if(other==0)return false;
          long v1 = v0 % other;
          if(v1<1)return false;
          sum -= (v0-v1);
          pq.add((int)(-v1));
        }
    }
}
