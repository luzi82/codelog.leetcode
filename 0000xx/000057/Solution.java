import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.lang.Math;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        boolean startDone=false;
        boolean endDone=false;

        LinkedList<Interval> resultList = new LinkedList<>();
        Interval iv = null; // new interval to add
        
        // comment: []=interval, {}=newInterval
        
        int ns=newInterval.start;
        int ne=newInterval.end;
        for(Interval interval : intervals){
            int is=interval.start;
            int ie=interval.end;
            if(!startDone){
                if((ns<is)&&(ne<is)){ // {} .. [] 
                    resultList.add(newInterval);
                    resultList.add(interval);
                    startDone=true;
                    endDone=true;
                    continue;
                }else if((ns<=ie)&&(ne<=ie)){ // {[ .. }]
                    iv = new Interval();
                    iv.start = Math.min(ns,is);
                    iv.end   = ie;
                    resultList.add(iv);
                    startDone=true;
                    endDone=true;
                    continue;
                }else if(ns<=ie){  // {[ .. ] .. }
                    iv = new Interval();
                    iv.start = Math.min(ns,is);
                    startDone = true;
                    continue;
                }else{ // [] .. {}
                    resultList.add(interval);
                    continue;
                }
            }else if(!endDone){
                if(ne<is){ // { .. } .. []
                    iv.end = ne;
                    resultList.add(iv);
                    resultList.add(interval);
                    endDone=true;
                    continue;
                }else if(ne<=ie){ // { .. [}]
                    iv.end = Math.max(ne,ie);
                    resultList.add(iv);
                    endDone=true;
                    continue;
                }else{ // { .. [] .. }
                    // skip interval, do nothing
                    continue;
                }
            }else{ // {} .. []
                resultList.add(interval);
            }
        }
        
        if(!startDone){
            resultList.add(newInterval);
            startDone=true;
            endDone=true;
        }else if(!endDone){
            iv.end = ne;
            resultList.add(iv);
            endDone=true;
        }
        
        return resultList;
    }
    
    public static void main(String[] argv){
        test(new int[]{1,3,6,9},new int[]{2,5},new int[]{1,5,6,9});
        test(new int[]{1,2,3,5,6,7,8,10,12,16},new int[]{4,9},new int[]{1,2,3,10,12,16});
        test(new int[]{3,4,5,6},new int[]{1,2},new int[]{1,2,3,4,5,6});
        test(new int[]{3,4,5,6},new int[]{7,8},new int[]{3,4,5,6,7,8});
    }
    
    public static void test(int[] _intervals,int[] _newInterval,int[] _expected){
        System.out.println(
            String.format("_intervals=%s, _newInterval=%s, _expected=%s",
                Arrays.toString(_intervals),
                Arrays.toString(_newInterval),
                Arrays.toString(_expected)
            )
        );
        LinkedList<Interval> intervals = new LinkedList<>();
        for(int i=0;i<_intervals.length/2;++i){
            int i0=i*2;int i1=i0+1;
            intervals.add(new Interval(_intervals[i0],_intervals[i1]));
        }
        Interval newInterval = new Interval(_newInterval[0],_newInterval[1]);
        Solution solution = new Solution();
        List<Interval> result = solution.insert(intervals, newInterval);
        int[] _result = new int[result.size()*2];
        int i=0;
        for(Interval resultU:result){
            _result[i]=resultU.start;
            ++i;
            _result[i]=resultU.end;
            ++i;
        }
        System.out.println(String.format("_result=%s",Arrays.toString(_result)));
        aassert(Arrays.equals(_expected,_result));
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }

}
