import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    static final int A_LEN_MAX = 200010;

    static class X{
        int[] childToParent=new int[A_LEN_MAX];
        HashSet<Integer>[] parentToChildSet=new HashSet[A_LEN_MAX];
        int[] factorCount=new int[A_LEN_MAX];
    }

    public int largestComponentSize(int[] A) {
        if(A.length==0)return 0;
        if(A.length==1)return 1;
    
        X x = new X();

        for(int a:A){
            if(a==1)continue;
            Integer[] aFactorAry = getFactorAry(a);
            Integer[] aFactorParentAry = new Integer[aFactorAry.length];
            for(int i=0;i<aFactorParentAry.length;++i){
                aFactorParentAry[i] = toParent(x,aFactorAry[i]);
            }
            Integer minFactorParent = min(aFactorParentAry);
            addFactorCount(x, minFactorParent,1);
            for(Integer aFactorParent:aFactorParentAry){
                if(aFactorParent==minFactorParent)continue;
                if(toParent(x,aFactorParent)==minFactorParent)continue;
                Collection<Integer> childColl = getChildColl(x,aFactorParent);
                if(childColl!=null){
                    for(Integer child:childColl){
                        setParent(x,child, minFactorParent);
                        addChild(x,minFactorParent,child);
                    }
                }
                clearChildColl(x,aFactorParent);
                setParent(x,aFactorParent, minFactorParent);
                addChild(x,minFactorParent, aFactorParent);
                addFactorCount(x,minFactorParent, getFactorCount(x,aFactorParent));
                setFactorCount(x,aFactorParent, 0);
            }
        }

        int[] factorCountColl=getFactorCountColl(x);
        int ret = max(factorCountColl);
        if(ret<=0)ret=1;

        return ret;
    }

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
    
    public static Integer toParent(X x,int f){
        if(x.childToParent[f]==0)return f;
        return x.childToParent[f];
    }
    
    public static Integer min(Integer[] ary){
        Integer ret=ary[0];
        for(Integer v:ary){
            if(v<ret)ret=v;
        }
        return ret;
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
    
    static Collection<Integer> getChildColl(X x, int f){
        return x.parentToChildSet[f];
    }
    
    static void setParent(X x,int c,int p){
        x.childToParent[c]=p;
    }
    
    static void addChild(X x,int p,int c){
        HashSet<Integer> childSet;
        if(x.parentToChildSet[p]!=null){
            childSet=x.parentToChildSet[p];
        }else{
            childSet=new HashSet<Integer>();
            x.parentToChildSet[p]=childSet;
        }
        childSet.add(c);
    }
    
    static void clearChildColl(X x,int p){
        x.parentToChildSet[p]=null;
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
