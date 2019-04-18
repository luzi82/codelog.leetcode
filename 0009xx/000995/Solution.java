import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minKBitFlips(int[] A, int K) {
        LinkedList<Integer> idxList = new LinkedList<>();
        int count = 0;

        for(int idx=0;idx<A.length;++idx){
            // pop expired idx from idxList
            while(true){
                if(idxList.isEmpty())break;
                if(idxList.getFirst()>idx-K)break;
                idxList.removeFirst();
            }
            
            int flip = idxList.size()%2;
            int af = (A[idx]+flip)%2;
            if(af==0){
                idxList.addLast(idx);
                ++count;
            }
        }
        
        while(true){
            if(idxList.isEmpty())break;
            if(idxList.getFirst()>A.length-K)break;
            idxList.removeFirst();
        }
        if(!idxList.isEmpty())return -1;
        
        return count;
    }
}
