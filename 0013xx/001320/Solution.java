import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minimumDistance(String word) {
        char[] wordCharAry = word.toCharArray();

        HashMap<Vector<Character>, Integer> lrToCountMap = new HashMap<>();
        lrToCountMap.put(new Vector<>(Arrays.asList(new Character[]{0,0})),0);
        for(char wordChar:wordCharAry){
            HashMap<Vector<Character>, Integer> nxtLrToCountMap = new HashMap<>();
            for(Vector<Character> lr:lrToCountMap.keySet()){
                char l=lr.get(0);
                char r=lr.get(1);
                int oldCount = lrToCountMap.get(lr);
                int newCount;
                newCount = oldCount+diff(l,wordChar);
                put(nxtLrToCountMap, wordChar, r, newCount);
                newCount = oldCount+diff(r,wordChar);
                put(nxtLrToCountMap, l, wordChar, newCount);
            }
            lrToCountMap = nxtLrToCountMap;
        }
        
        int ret = Integer.MAX_VALUE;
        for(Integer count:lrToCountMap.values()){
            if(ret<=count)continue;
            ret = count;
        }
        return ret;
    }
    
    public int[] xy(char c){
        int v = c-'A';
        return new int[]{v/6,v%6};
    }
    
    public int diff(char a,char b){
        if(a==0)return 0;
        int[] axy=xy(a);
        int[] bxy=xy(b);
        return Math.abs(axy[0]-bxy[0])+Math.abs(axy[1]-bxy[1]);
    }
    
    public void put(HashMap<Vector<Character>, Integer> lrToCountMap, char l, char r, int count){
        Vector<Character> key = new Vector<>(Arrays.asList(new Character[]{l,r}));
        if(lrToCountMap.containsKey(key)){
            int oldCount=lrToCountMap.get(key);
            if(oldCount<=count)return;
        }
        lrToCountMap.put(key,count);
    }
}
