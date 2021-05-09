import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// [WKZLRYSMSG]

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
        
        TreeSet<U> pQueue = new TreeSet<>();
        HashSet<U> uDoneSet = new HashSet<>();
        
        U u0=new U(0,0);
        pQueue.add(u0);uDoneSet.add(u0);
        while(!pQueue.isEmpty()){
            U u=pQueue.last();pQueue.remove(u);
            
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
                pQueue.add(newU);
                uDoneSet.add(newU);
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
                pQueue.add(newU);
                uDoneSet.add(newU);
            }
        }
        
        return false;
    }
}
