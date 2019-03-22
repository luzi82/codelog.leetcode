import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    static class X{
        HashMap<Integer,Integer> childToParent=new HashMap<>();
        HashMap<Integer,HashSet<Integer>> parentToChildSet=new HashMap<>();
        HashMap<Integer,Integer> factorCount=new HashMap<>();
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

        Collection<Integer> factorCountSet=getFactorCountSet(x);
        if(factorCountSet.size()==0)return 1;

        return max(factorCountSet);
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
    
    public static Integer toParent(X x,int v){
        if(!x.childToParent.containsKey(v))return v;
        return x.childToParent.get(v);
    }
    
    public static Integer min(Integer[] ary){
        Integer ret=ary[0];
        for(Integer v:ary){
            if(v<ret)ret=v;
        }
        return ret;
    }
    
    public static Integer max(Collection<Integer> intColl){
        Integer ret=Integer.MIN_VALUE;
        for(Integer v:intColl){
            if(v>ret)ret=v;
        }
        return ret;
    }
    
    public static void addFactorCount(X x,int f,int c){
        if(x.factorCount.containsKey(f))c+=x.factorCount.get(f);
        x.factorCount.put(f,c);
    }
    
    static Collection<Integer> getChildColl(X x, int f){
        if(x.parentToChildSet.containsKey(f))return x.parentToChildSet.get(f);
        return null;
    }
    
    static void setParent(X x,int c,int p){
        x.childToParent.put(c,p);
    }
    
    static void addChild(X x,int p,int c){
        HashSet<Integer> childSet;
        if(x.parentToChildSet.containsKey(p)){
            childSet=x.parentToChildSet.get(p);
        }else{
            childSet=new HashSet<Integer>();
            x.parentToChildSet.put(p,childSet);
        }
        childSet.add(c);
    }
    
    static void clearChildColl(X x,int p){
        if(x.parentToChildSet.containsKey(p)){
            x.parentToChildSet.remove(p);
        }
    }

    public static void setFactorCount(X x,int f,int c){
        x.factorCount.put(f,c);
    }

    public static int getFactorCount(X x,int f){
        if(x.factorCount.containsKey(f))return x.factorCount.get(f);
        return 0;
    }

    static Collection<Integer> getFactorCountSet(X x){
        return x.factorCount.values();
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
