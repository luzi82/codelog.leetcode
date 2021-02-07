import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    final Random random;
    final int randMax;
    final TreeMap<Integer, Integer> randIdxToValue;

    public Solution(int N, int[] blacklist) {
      blacklist = blacklist.clone();
      Arrays.sort(blacklist);

      // Create whitelist from blacklist
      //
      // 3, [1] -> [0,2]
      // 4, [2] -> [0,1,3]
      // 100, [10,11...19] -> [0-9,20-99]
      //
      // store whitelist as rand-id > v-output map
      // [0,2] -> {0:0,1:2}
      // [0,1,3] -> {0:0,2:3}
      // [0-9,20-99] -> {0:0,10:20}
      randIdxToValue = new TreeMap<Integer, Integer>();
      randIdxToValue.put(0,0);
      int lastIdx = 0;
      int lastV   = 0;
      for(int black:blacklist){
        // N = 100
        // black   = [10,11,12,13,14]
        // lastIdx = [ 0,10,10,10,10]
        // lastV   = [ 0,11,12,13,14]

        // idx     = [10,10,10,10,10]
        int idx = black - lastV + lastIdx;

        // value   = [11,12,13,14,15]
        int value = black + 1;

        randIdxToValue.put(idx, value);
        lastIdx = idx;
        lastV = value;
      }

      randMax = N - blacklist.length;
      random = new Random();
    }
    
    public int pick() {
      int rand = random.nextInt(randMax);
      int rand1 = rand + 1;

      SortedMap<Integer,Integer> headMap = randIdxToValue.headMap(rand1);
      int idx = headMap.lastKey();
      int value = randIdxToValue.get(idx);

      int ret = rand - idx + value;
      return ret;
    }

    public void trace(){
      System.err.println(String.format("MEBBXVVLMY randMax=%d",randMax));
      for(Map.Entry<Integer,Integer> me:randIdxToValue.entrySet()){
        System.err.println(String.format("MEJVEUKERB key=%d value=%d",me.getKey(),me.getValue()));
      }
    }
}
