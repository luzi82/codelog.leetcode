import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// solution done in 05/14/2021 09:05 GMT+8

class Solution {
    public int minimumDistance(String word) {
        char[] cAry = word.toCharArray();

        HashMap<String,Integer> abToMindistMap = new HashMap<String,Integer>();
        abToMindistMap.put("**",0);
        
        for(char c:cAry){
            HashMap<String,Integer> nextAbToMindistMap = new HashMap<String,Integer>();
            for(Map.Entry<String,Integer> abToMindistMe : abToMindistMap.entrySet()){
                String ab = abToMindistMe.getKey();
                char a=ab.charAt(0);
                char b=ab.charAt(1);
                int mindist = abToMindistMe.getValue();
                
                int nextMindist;
                String nextAb;
                // move a
                nextMindist = mindist+distance(a,c);
                nextAb = new String(new char[]{c,b});
                if((!nextAbToMindistMap.containsKey(nextAb))||(nextMindist<nextAbToMindistMap.get(nextAb))){
                    nextAbToMindistMap.put(nextAb,nextMindist);
                }

                // move b
                nextMindist = mindist+distance(b,c);
                nextAb = new String(new char[]{a,c});
                if((!nextAbToMindistMap.containsKey(nextAb))||(nextMindist<nextAbToMindistMap.get(nextAb))){
                    nextAbToMindistMap.put(nextAb,nextMindist);
                }
            }
            abToMindistMap = nextAbToMindistMap;
        }
        
        int ret=Integer.MAX_VALUE;
        for(int mindist : abToMindistMap.values()){
            ret = Math.min(ret,mindist);
        }
        
        return ret;
    }
    
    public int[] toIj(char v){
        if(v=='*')return null;
        v-='A';
        return new int[]{v/6,v%6};
    }
    
    public int distance(char a,char b){
        if(a=='*')return 0;
        int[] aIj = toIj(a);
        int[] bIj = toIj(b);
        return Math.abs(aIj[0]-bIj[0])+Math.abs(aIj[1]-bIj[1]);
    }
    
    // public int toIdx(char a){
    //     if(a=='*')return 26;
    //     return a-'A';
    // }
}
