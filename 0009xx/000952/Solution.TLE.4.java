import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    static final int A_LEN_MAX = 20010;
    static final int VALUE_MAX = 100010;

    static class X{
        // nodeToEdgeSet
        HashSet<Integer>[] nodeToSmallEdgeSet=new HashSet[VALUE_MAX];
        int[] nodeToMinEdge=new int[VALUE_MAX];
        int[] factorCount=new int[VALUE_MAX];
    }

    public int largestComponentSize(int[] A) {
        if(A.length==0)return 0;
        if(A.length==1)return 1;
    
        X x = new X();

        for(int a:A){
            if(a==1)continue;
            Integer[] aFactorAry = getFactorAry(a);
            int minFactor = aFactorAry[0];
            addFactorCount(x, minFactor,1);
            for(int aFactor : aFactorAry){
                if(aFactor==minFactor)continue;
                //addEdge(x,minFactor,aFactor);
                addEdge(x,aFactor,minFactor);
            }
        }
        
        calNodeToMinEdge(x);
        calFactorCount(x);

        int[] factorCountColl=getFactorCountColl(x);
        int ret = max(factorCountColl);
        if(ret<=0)ret=1;

        return ret;
    }
    
    public static int min(int[] ary){
        int ret=ary[0];
        for(int v:ary){
            if(v<ret)ret=v;
        }
        return ret;
    }
    
    public static int min(Integer[] ary){
        int ret=ary[0];
        for(int v:ary){
            if(v<ret)ret=v;
        }
        return ret;
    }
    
    public static int min(Collection<Integer> ary){
        return Collections.min(ary);
    }
    
    public static int max(int[] intAry){
        int ret=Integer.MIN_VALUE;
        for(int v:intAry){
            if(v>ret)ret=v;
        }
        return ret;
    }
    
    public static void addFactorCount(X x,int f,int c){
        x.factorCount[f]+=c;
    }
    
    static void addEdge(X x,int b,int a){
        HashSet<Integer> edgeSet = x.nodeToSmallEdgeSet[b];
        if(edgeSet==null){
            edgeSet = new HashSet<Integer>();
            x.nodeToSmallEdgeSet[b]=edgeSet;
        }
        edgeSet.add(a);
    }
    
    static void calNodeToMinEdge(X x){
        for(int i=0;i<VALUE_MAX;++i){
            if(x.nodeToSmallEdgeSet[i]==null)continue;
            Collection<Integer> edgeAry = x.nodeToSmallEdgeSet[i];
            int minEdge = i;
            HashSet<Integer> edgeList = new HashSet<>();
            for(int edge:edgeAry){
                edgeList.add(edge);
                if(x.nodeToMinEdge[edge]!=0)edge=x.nodeToMinEdge[edge];
                edgeList.add(edge);
                if(edge<minEdge)minEdge=edge;
            }
            if(minEdge>=i)continue;
            edgeList.add(i);
            for(int edge:edgeList){
                if(edge==minEdge)continue;
                x.nodeToMinEdge[edge]=minEdge;
            }
        }
    }
    
    static void calFactorCount(X x){
        for(int i=VALUE_MAX-1;i>=0;--i){
            if(x.factorCount[i]==0)continue;
            int minEdge=x.nodeToMinEdge[i];
            if(minEdge==0)continue;
            x.factorCount[minEdge] += x.factorCount[i];
            x.factorCount[i] = 0;
        }
    }
    
    public static void setFactorCount(X x,int f,int c){
        x.factorCount[f]=c;
    }

    public static int getFactorCount(X x,int f){
        return x.factorCount[f];
    }

    static int[] getFactorCountColl(X x){
        return x.factorCount;
    }

/////////////////////////////////////

    public static Integer[] getFactorAry(int v){
        LinkedList<Integer> ret=new LinkedList<>();
        int primeIdx=0;
        while(v!=1){
            int prime = getPrime(primeIdx);
            if(v%prime==0){
                ret.addLast(prime);
                while(v%prime==0){
                    v/=prime;
                }
            }
            ++primeIdx;
        }
        return ret.toArray(new Integer[0]);
    }
    
    static Vector<Integer> primeV=new Vector<Integer>();
    static int getPrime(int idx){
        if(primeV.size()==0){
            primeV.add(2);
            primeV.add(3);
        }
        while(idx>=primeV.size()){
            int p=primeV.lastElement();
            while(true){
                p+=2;
                boolean isPrime=true;
                for(int pp:primeV){
                    if(p%pp==0){isPrime=false;break;}
                    if(pp*pp>p){break;}
                }
                if(isPrime)break;
            }
            primeV.add(p);
        }
        return primeV.get(idx);
    }

}
