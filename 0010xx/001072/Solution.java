import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<Vector<Integer>,Integer> aryToCount = new HashMap<>();
        for(int[] ary:matrix){
            Vector<Integer> vec = toVector(ary);
            int count=0;
            if(aryToCount.containsKey(vec))count = aryToCount.get(vec);
            ++count;
            aryToCount.put(vec,count);
        }
        
        int ret = 0;
        for(int v:aryToCount.values()){
            ret = Math.max(v,ret);
        }
        
        return ret;
    }

    public Vector<Integer> toVector(int[] v){
        if(v[0]==0)return toVector0(v);
        return toVector1(v);
    }

    public Vector<Integer> toVector0(int[] v){
        Vector<Integer> ret = new Vector<Integer>(v.length);
        for(int i=0;i<v.length;++i){
            ret.add(v[i]);
        }
        return ret;
    }

    public Vector<Integer> toVector1(int[] v){
        Vector<Integer> ret = new Vector<Integer>(v.length);
        for(int i=0;i<v.length;++i){
            ret.add(1-v[i]);
        }
        return ret;
    }
}
