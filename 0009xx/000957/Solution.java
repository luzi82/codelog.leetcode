import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<Vector<Integer>,Integer> aryToStepMap = new HashMap<>();
        aryToStepMap.put(intAryToVector(cells),0);
        
        int step = 0;
        while(step<N){
            cells = next(cells);
            ++step;
            Vector<Integer> vec = intAryToVector(cells);
            if(aryToStepMap.containsKey(vec)){
                int step0 = aryToStepMap.get(vec);
                int stepDiff = step-step0;
                int remainStep = N-step;
                remainStep %= stepDiff;
                step = N - remainStep;
                break;
            }
            aryToStepMap.put(vec,step);
        }
        
        while(step<N){
            cells = next(cells);
            ++step;
        }
        
        return cells;
    }
    
    public static int[] next(int[] cells){
        int[] ret = new int[cells.length];
        for(int i=1;i<cells.length-1;++i){
            ret[i] = (cells[i-1]==cells[i+1])?1:0;
        }
        return ret;
    }

    public static Vector<Integer> intAryToVector(int[] ary){
        Vector<Integer> ret = new Vector<>(ary.length);
        for(int i=0;i<ary.length;++i){
            ret.add(ary[i]);
        }
        return ret;
    }
}
