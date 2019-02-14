import java.io.*;
import java.util.*;
import java.math.*;

class Solution {

    public int maxPoints(Point[] points) {
        // no point, no problem
        if(points.length==0)return 0;
    
        // in case of all point at the same position
        boolean allPointSame = true;
        for(Point point : points){
            if(points[0].x!=point.x){
                allPointSame = false;
                break;
            }
            if(points[0].y!=point.y){
                allPointSame = false;
                break;
            }
        }
        if(allPointSame){
            return points.length;
        }

        HashMap<Vector<Long>,Integer> abcToCountMap = new HashMap<>();
        for(Point pointA : points){
            HashSet<Vector<Long>> abcSet = new HashSet<>();
            for(Point pointB : points){
                long ax=pointA.x;long ay=pointA.y;
                long bx=pointB.x;long by=pointB.y;
                if((ax==bx)&&(ay==by)){
                    continue;
                }
                Vector<Long> abc = new Vector<>(3);abc.setSize(3);
                if(ax==bx){
                    abc.set(0,1L);abc.set(1,0L);abc.set(2,-ax);
                }else if(ay==by){
                    abc.set(0,0L);abc.set(1,1L);abc.set(2,-ay);
                }else{
                    long a = by-ay;
                    long b = ax-bx;
                    long c = bx*ay-ax*by;
                    if(c==0){
                        long d = gcd(a,b);
                        a/=d;b/=d;
                        if(a<0){a=-a;b=-b;}
                    }else{
                        long d = gcd(a,b);
                        d = gcd(d,c);
                        a/=d;b/=d;c/=d;
                        if(a<0){a=-a;b=-b;c=-c;}
                    }
                    abc.set(0,a);abc.set(1,b);abc.set(2,c);
                }
                abcSet.add(abc);
            }
            for(Vector<Long> abc:abcSet){
                int oldCount = abcToCountMap.containsKey(abc) ? abcToCountMap.get(abc) : 0;
                abcToCountMap.put(abc,oldCount+1);
            }
        }
        //for(Map.Entry<Vector<Long>, Integer> abcCount : abcToCountMap.entrySet()){
        //    Vector<Long> abc = abcCount.getKey();
        //    int count = abcCount.getValue();
        //    System.err.println(String.format("%d %d %d %d",abc.get(0),abc.get(1),abc.get(2),count));
        //}
        
        int ret = Collections.max(abcToCountMap.values());
        //System.err.println("WDZWRPYLAW "+ret);
        return ret;
    }
    
    public long gcd(long a,long b){
        if(a<0){return gcd(-a,b);}
        if(b<0){return gcd(a,-b);}
        if(a==b)return a;
        if(a>b)return gcd(b,a);
        long c;
        while(a!=0){
            c=b%a;
            b=a;a=c;
        }
        return b;
    }
}
