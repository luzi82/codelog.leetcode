import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {

    public int shortestSubarray(int[] A, int K) {
        DcOut ret = dc(0,A.length,A,K);
        //System.err.println(String.format("SOAJROXWDY %d",ret.ans));
        return (ret.ans==Integer.MAX_VALUE)?(-1):ret.ans;
    }
    
    public static DcOut dc(int start,int end,int[] A, long K) {
        DcOut dc = _dc(start,end,A,K);

        //System.err.println(String.format("start=%d, end=%d, sum=%d",start,end,dc.sum));
        //System.err.print("startSumList");
        //for(long[] si:dc.startSumList){
        //    System.err.print(String.format(" %d-%d",si[0],si[1]));
        //}
        //System.err.println();
        //System.err.print("endSumList");
        //for(long[] si:dc.endSumList){
        //    System.err.print(String.format(" %d-%d",si[0],si[1]));
        //}
        //System.err.println();
        //System.err.println();

        return dc;
    }

    public static DcOut _dc(int start,int end,int[] A, final long K) {
        DcOut ret = new DcOut();
        if(end==start+1){
            long v = A[start];
            if(v>=K){
                ret.ans = 1;
            }else if(v<K){
                ret.sum = v;
                if(v>0){
                    ret.startSumList.addFirst(new long[]{start,v});
                    ret.endSumList.addLast(new long[]{end,v});
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
        if((lhs.startSumList.size()>0)&&(rhs.endSumList.size()>0)){
            Iterator<long[]> lhsStartSumItr = lhs.startSumList.iterator();
            Iterator<long[]> rhsEndSumItr   = rhs.endSumList.iterator();
            long[] lhsStartSum = lhsStartSumItr.next();
            long[] rhsEndSum = rhsEndSumItr.next();
            while(true){
                long sum = lhsStartSum[1]+rhsEndSum[1];
                if(sum>=K){
                    ret.ans = (int)Math.min(ret.ans,rhsEndSum[0]-lhsStartSum[0]);
                    if(!lhsStartSumItr.hasNext())break;
                    lhsStartSum = lhsStartSumItr.next();
                }else{
                    if(!rhsEndSumItr.hasNext())break;
                    rhsEndSum = rhsEndSumItr.next();
                }
            }
        }
        
        Stream<long[]> stream;

        // build startSumList
        {
            ret.startSumList = rhs.startSumList;
            final long sumMax = ret.startSumList.isEmpty()?0:ret.startSumList.getFirst()[1];
            final long plus = rhs.sum;
            ret.startSumList.addAll(0,
                lhs.startSumList.stream()
                    .peek(iv->iv[1]+=plus)
                    .filter(iv->iv[1]>sumMax)
                    .filter(iv->iv[1]<K)
                    .collect(Collectors.toList())
            );
        }
        
        // build endSumList
        {
            ret.endSumList = lhs.endSumList;
            final long sumMax = ret.endSumList.isEmpty()?0:ret.endSumList.getLast()[1];
            final long plus = lhs.sum;
            ret.endSumList.addAll(
                rhs.endSumList.stream()
                    .peek(iv->iv[1]+=plus)
                    .filter(iv->iv[1]>sumMax)
                    .filter(iv->iv[1]<K)
                    .collect(Collectors.toList())
            );
        }
        
        return ret;
    }

    static class DcOut{
        public int ans = Integer.MAX_VALUE;
        public long sum;
        public LinkedList<long[]> startSumList=new LinkedList<>(); // [0]: start idx, [1]: sum
        public LinkedList<long[]> endSumList  =new LinkedList<>(); // [0]: end idx, [1]: sum
    }

}
