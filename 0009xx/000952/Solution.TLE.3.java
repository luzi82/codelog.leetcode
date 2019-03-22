import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    static final int A_LEN_MAX = 20010;
    static final int VALUE_MAX = 100010;

    static class X{
        HashMap<Integer,HashSet<Integer>> nodeToEdgeSet=new HashMap<>();
        HashMap<Integer,Integer> nodeToMinEdge=new HashMap<>();
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
                addEdge(x,minFactor,aFactor);
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
    
    static void addEdge(X x,int a,int b){
        HashSet<Integer> edgeSet = x.nodeToEdgeSet.get(a);
        if(edgeSet==null){
            edgeSet = new HashSet<Integer>();
            x.nodeToEdgeSet.put(a,edgeSet);
        }
        edgeSet.add(b);
    }
    
    static void calNodeToMinEdge(X x){
        Integer[] pAry = x.nodeToEdgeSet.keySet().toArray(new Integer[0]);
        Arrays.sort(pAry);
        for(int p:pAry){
            Integer[] edgeAry = x.nodeToEdgeSet.get(p).toArray(new Integer[0]);
            Arrays.sort(edgeAry);
            int minEdge = p;
            HashSet<Integer> edgeList = new HashSet<>();
            for(int edge:edgeAry){
                if(edge>p)break;
                edgeList.add(edge);
                if(x.nodeToMinEdge.containsKey(edge))edge=x.nodeToMinEdge.get(edge);
                edgeList.add(edge);
                if(edge<minEdge)minEdge=edge;
            }
            if(minEdge>=p)continue;
            x.nodeToMinEdge.put(p,minEdge);
            for(int edge:edgeList){
                if(edge==minEdge)continue;
                x.nodeToMinEdge.put(edge,minEdge);
            }
        }
    }
    
    static void calFactorCount(X x){
        for(int i=VALUE_MAX-1;i>=0;--i){
            if(x.factorCount[i]==0)continue;
            Integer minEdge=x.nodeToMinEdge.get(i);
            if(minEdge==null)continue;
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
