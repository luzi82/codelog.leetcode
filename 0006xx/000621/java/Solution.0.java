import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] dToLastDoneAry = new int[26];
        for(int d=0;d<26;++d){
            dToLastDoneAry[d] = Integer.MIN_VALUE;
        }
        int[] dToRemainCntAry = new int[26];
        for(char c:tasks){
            int d = c-'A';
            ++dToRemainCntAry[d];
        }
        
        PriorityQueue<CntD> cntDPq = new PriorityQueue<>();
        for(int d=0;d<26;++d){
            if(dToRemainCntAry[d]<=0)continue;
            CntD cntD = new CntD();
            cntD.cnt = dToRemainCntAry[d];
            cntD.d = d;
            cntDPq.add(cntD);
        }
        
        int t = 0;
        while(true){
            if(cntDPq.size()<=0)break;
            LinkedList<CntD> cntDList = new LinkedList<>();
            while(true){
                if(cntDPq.size()<=0)break;
                CntD cntD = cntDPq.poll();
                int cnt = cntD.cnt;
                int d = cntD.d;
                if(t-n<=dToLastDoneAry[d]){
                    cntDList.add(cntD);
                    continue;
                }
                dToLastDoneAry[d]=t;
                --cntD.cnt;
                if(cntD.cnt>0){
                    cntDList.add(cntD);
                }
                break;
            }
            cntDPq.addAll(cntDList);
            ++t;
        }
        
        return t;
    }
    
    class CntD implements Comparable<CntD>{
        int cnt;
        int d;
        public int compareTo(CntD other){
            int diff;
            diff = this.cnt-other.cnt;
            if(diff!=0)return -diff;
            diff = this.d-other.d;
            if(diff!=0)return diff;
            return 0;
        }
    }
}
