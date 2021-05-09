import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// try to remove log from WKZLRYSMSG by using stack instead of tree, WA, test("aa","ab","aaba",true);

class Solution {

    static class U implements Comparable{
        int done1;int done2;
        U(int done1,int done2){this.done1=done1;this.done2=done2;}
        public int compareTo(Object o){
            U u=(U)o;
            if(u.done1+u.done2!=this.done1+this.done2)return (this.done1+this.done2)-(u.done1+u.done2);
            if(this.done1!=u.done1)return this.done1-u.done1;
            if(this.done2!=u.done2)return this.done2-u.done2;
            return 0;
        }
        public boolean equals(Object o){
            return this.compareTo(o)==0;
        }
        public int hashCode(){
            return Objects.hash(done1,done2);
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1Ary = s1.toCharArray();
        char[] c2Ary = s2.toCharArray();
        char[] c3Ary = s3.toCharArray();
        
        if(c1Ary.length+c2Ary.length!=c3Ary.length)return false;
        
        LinkedList<Integer> d3Stack=new LinkedList<>();
        HashMap<Integer,LinkedList<U>> d3ToUList = new HashMap<>();
        HashSet<U> uDoneSet = new HashSet<>();
        
        U u0=new U(0,0);
        push(u0,d3Stack,d3ToUList,uDoneSet);
        while(!d3Stack.isEmpty()){
            U u=pop(d3Stack,d3ToUList);
            
            // go 1
            int done1 = u.done1;
            int done3 = u.done1+u.done2;
            while(true){
                if(done1>=c1Ary.length)break;
                if(c1Ary[done1]!=c1Ary[u.done1])break;
                if(c1Ary[done1]!=c3Ary[done3])break;
                ++done1;++done3;
            }
            if(done3>=c3Ary.length)return true;
            U newU = new U(done1,u.done2);
            if(!uDoneSet.contains(newU)){
                push(newU,d3Stack,d3ToUList,uDoneSet);
            }
            
            // go 2
            int done2 = u.done2;
            done3 = u.done1+u.done2;
            while(true){
                if(done2>=c2Ary.length)break;
                if(c2Ary[done2]!=c2Ary[u.done2])break;
                if(c2Ary[done2]!=c3Ary[done3])break;
                ++done2;++done3;
            }
            if(done3>=c3Ary.length)return true;
            newU = new U(u.done1,done2);
            if(!uDoneSet.contains(newU)){
                push(newU,d3Stack,d3ToUList,uDoneSet);
            }
        }
        
        return false;
    }
    
    public static void push(U u0,LinkedList<Integer> d3Stack,HashMap<Integer,LinkedList<U>> d3ToUList,HashSet<U> uDoneSet){
        int d3 = u0.done1+u0.done2;
        int maxLen = (d3Stack.isEmpty())?-1:d3Stack.getLast();
        if(d3>maxLen){
            d3Stack.addLast(d3);
        }
        if(!d3ToUList.containsKey(d3)){
            d3ToUList.put(d3,new LinkedList<U>());
        }
        LinkedList<U> uList = d3ToUList.get(d3);
        uList.addLast(u0);
        
        uDoneSet.add(u0);
    }
    
    public static U pop(LinkedList<Integer> d3Stack,HashMap<Integer,LinkedList<U>> d3ToUList){
        int maxLen = d3Stack.getLast();
        LinkedList<U> uList = d3ToUList.get(maxLen);
        U u = uList.removeLast();
        if(uList.size()<=0){
            d3ToUList.remove(maxLen);
            d3Stack.removeLast();
        }
        return u;
    }
}
