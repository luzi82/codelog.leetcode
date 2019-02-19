import java.io.*;
import java.util.*;
import java.math.*;

class Solution {

    public int shortestSubarray(int[] A, int K) {
        DcOut ret = dc(0,A.length,A,K);
        //System.err.println(String.format("SOAJROXWDY %d",ret.ans));
        return (ret.ans==Integer.MAX_VALUE)?(-1):ret.ans;
    }
    
    public static DcOut dc(int start,int end,int[] A, long K) {
        DcOut dc = _dc(start,end,A,K);

        //System.err.println(String.format("start=%d, end=%d, sum=%d",start,end,dc.sum));
        //System.err.print("sumStartList");
        //for(long[] si:dc.sumStartList){
        //    System.err.print(String.format(" %d-%d",si[0],si[1]));
        //}
        //System.err.println();
        //System.err.print("sumEndList");
        //for(long[] si:dc.sumEndList){
        //    System.err.print(String.format(" %d-%d",si[0],si[1]));
        //}
        //System.err.println();
        //System.err.println();

        return dc;
    }

    public static DcOut _dc(int start,int end,int[] A, long K) {
        DcOut ret = new DcOut();
        if(end==start+1){
            long v = A[start];
            if(v>=K){
                ret.ans = 1;
            }else if(v<K){
                ret.sum = v;
                if(v>0){
                    ret.sumStartList.addFirst(new long[]{v,start});
                    ret.sumEndList.addLast(new long[]{v,end});
                }
            }
            return ret;
        }
        int mid=(start+end)/2;

        DcOut lhs = dc(start,mid,A,K);
        ret.ans = Math.min(ret.ans,lhs.ans);
        if(ret.ans==1)return ret; // fast skip

        DcOut rhs = dc(mid,end,A,K);
        ret.ans = Math.min(ret.ans,rhs.ans);
        if(ret.ans==1)return ret; // fast skip
        
        ret.sum = lhs.sum + rhs.sum;

        // detect mid
        if((lhs.sumStartList.size()>0)&&(rhs.sumEndList.size()>0)){
            Iterator<long[]> lhsSumStartItr = lhs.sumStartList.iterator();
            Iterator<long[]> rhsSumEndItr   = rhs.sumEndList.iterator();
            long[] lhsSumStart = lhsSumStartItr.next();
            long[] rhsSumEnd = rhsSumEndItr.next();
            while(true){
                long sum = lhsSumStart[0]+rhsSumEnd[0];
                if(sum>=K){
                    ret.ans = (int)Math.min(ret.ans,rhsSumEnd[1]-lhsSumStart[1]);
                    if(!lhsSumStartItr.hasNext())break;
                    lhsSumStart = lhsSumStartItr.next();
                }else{
                    if(!rhsSumEndItr.hasNext())break;
                    rhsSumEnd = rhsSumEndItr.next();
                }
            }
        }
        
        long lastSum, currentSum, tmpSum;

        // build sumStartList
        ret.sumStartList = rhs.sumStartList;
        lastSum = ret.sumStartList.isEmpty()?0:ret.sumStartList.getFirst()[0];
        Iterator<long[]> itr = lhs.sumStartList.descendingIterator();
        while(itr.hasNext()){
            long[] lhsSumStart = itr.next();
            tmpSum = rhs.sum + lhsSumStart[0];
            if(tmpSum>=K)break;
            if(tmpSum<=lastSum)continue;
            ret.sumStartList.addFirst(new long[]{tmpSum,lhsSumStart[1]});
            lastSum = tmpSum;
        }
        
        // build sumEndList
        ret.sumEndList = lhs.sumEndList;
        lastSum = ret.sumEndList.isEmpty()?0:ret.sumEndList.getLast()[0];
        for(long[] rhsSumEnd:rhs.sumEndList){
            tmpSum = lhs.sum + rhsSumEnd[0];
            if(tmpSum>=K)break;
            if(tmpSum<=lastSum)continue;
            ret.sumEndList.addLast(new long[]{tmpSum,rhsSumEnd[1]});
            lastSum = tmpSum;
        }
        
        return ret;
    }

    static class DcOut{
        public int ans = Integer.MAX_VALUE;
        public long sum;
        public LinkedList<long[]> sumStartList=new LinkedList<>(); // sum: big to small, start: small to big
        public LinkedList<long[]> sumEndList  =new LinkedList<>(); // sum: small to big, end: big to small
    }

}
