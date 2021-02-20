import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxEvents(int[][] events) {
        Event[] eventAry = new Event[events.length];
        for(int i=0;i<events.length;++i){
          eventAry[i] = new Event(events[i][0],events[i][1]+1);
        }

        Arrays.sort(eventAry);

        PriorityQueue<Integer> endQ = new PriorityQueue<>();
        int d = eventAry[0].s;
        int eventAryIdx = 0;
        int ret = 0;
        while(true){
          // System.err.println(String.format("d=%d",d));

          // pump eventAry to endQ
          while(true){
            if(eventAryIdx>=eventAry.length)break;
            if(eventAry[eventAryIdx].s>d)break;
            endQ.add(eventAry[eventAryIdx].e);
            ++eventAryIdx;
          }

          // remove outdated ev from endQ
          while(true){
            if(endQ.isEmpty())break;
            if(endQ.peek()>d)break;
            endQ.poll();
          }

          if(!endQ.isEmpty()){
            int e = endQ.poll();
            // System.err.println(String.format("e=%d",d));
            ++ret;
          }

          // go next day
          ++d;

          // skip empty day
          if(endQ.isEmpty()){
            if(eventAryIdx>=eventAry.length)break;
            d = eventAry[eventAryIdx].s;
          }
        }

        return ret;
    }

    class Event implements Comparable<Event>{
      int s;int e;
      Event(int s,int e){
        this.s=s;this.e=e;
      }
      public int compareTo(Event other){
        int d;
        d = this.s - other.s;
        if(d!=0)return d;
        d = this.e - other.e;
        if(d!=0)return d;
        return 0;
      }
    }
}
