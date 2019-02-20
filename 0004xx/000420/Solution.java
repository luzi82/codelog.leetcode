import java.io.*;
import java.util.*;
import java.math.*;

class Solution {

//    public static final char WC = '*';
    public static final char WC = '屌';
    public static final String WS = ""+WC;
    
    public static final boolean DEBUG = false;

    public int strongPasswordChecker(String s) {
        // A* search
        TreeSet<Unit> unitSet = new TreeSet<>();
        int hs=h(s);
        if(hs==0)return 0;
        unitSet.add(new Unit(hs,0,hs,s));
        
        int ret = Integer.MAX_VALUE;
        while(true){
            Unit unit = unitSet.pollFirst();
            if(unit==null)return ret;
            if(DEBUG)System.err.println(String.format("%d %d %d %s",unit.predictLen,unit.doneLen,unit.hv,unit.s));
            if(unit.predictLen>=ret)return ret;
            if(unit.hv==0){
                ret = Math.min(ret,unit.predictLen);
                continue;
            }
            int sLen = unit.s.length();
            if(sLen<20){
                tryAdd(unit,unitSet);
            }
            if(sLen>20){
                tryDel(unit,unitSet);
            }
            if(sLen>=6&&sLen<=20){
                tryMod(unit,unitSet);
            }
        }
    }
    
    public static void tryAdd(Unit unit,TreeSet<Unit> unitSet){
        String s = unit.s;
        int sLen = s.length();
        int nextDoneLen = unit.doneLen+1;
        for(int i=0;i<=sLen;++i){
            String s0 = s.substring(0,i)+WS+s.substring(i);
            int hv=h(s0);
            unitSet.add(new Unit(nextDoneLen+hv,nextDoneLen,hv,s0));
        }
    }

    public static void tryDel(Unit unit,TreeSet<Unit> unitSet){
        String s = unit.s;
        int sLen = s.length();
        int nextDoneLen = unit.doneLen+1;
        for(int i=0;i<sLen;++i){
            String s0 = s.substring(0,i)+s.substring(i+1);
            int hv=h(s0);
            unitSet.add(new Unit(nextDoneLen+hv,nextDoneLen,hv,s0));
        }
    }

    public static void tryMod(Unit unit,TreeSet<Unit> unitSet){
        String s = unit.s;
        int sLen = s.length();
        int nextDoneLen = unit.doneLen+1;
        for(int i=0;i<sLen;++i){
            String s0 = s.substring(0,i)+WS+s.substring(i+1);
            int hv=h(s0);
            unitSet.add(new Unit(nextDoneLen+hv,nextDoneLen,hv,s0));
        }
    }

    public static int h(String s){
        char[] charAry = s.toCharArray();
        boolean haveLower=false;
        boolean haveUpper=false;
        boolean haveDigit=false;
        int wildCount=0;
        int tripleCount=0;
        int sameCount=0;
        char lastChar=WC;
        for(char c:charAry){
            haveLower = haveLower || (c>='a'&&c<='z');
            haveUpper = haveUpper || (c>='A'&&c<='Z');
            haveDigit = haveDigit || (c>='0'&&c<='9');
            wildCount += (c==WC)?1:0;
            char nextLastChar = c;
            if((c!=WC)&&(c==lastChar)){
                ++sameCount;
                if(sameCount>=3){
                    tripleCount++;
                    sameCount=0;
                    nextLastChar=WC;
                }
            }else{
                sameCount=1;
            }
            lastChar = nextLastChar;
        }
        
        //System.err.println(String.format("tripleCount %s %d",s,tripleCount));
        
        int miss3Con = 0;
        miss3Con += haveLower?0:1;
        miss3Con += haveUpper?0:1;
        miss3Con += haveDigit?0:1;
        miss3Con -= wildCount;
        miss3Con = Math.max(0,miss3Con);

        int sLen = s.length();
        if(sLen<6){
            int miss = 6-sLen;
            int ret = 0;
            ret = Math.max(ret,miss3Con);
            ret = Math.max(ret,tripleCount);
            ret = Math.max(ret,miss);
            return ret;
        }
        
        if(sLen>20){
            int much = sLen-20;
            int ret = 0;
            ret = Math.max(ret,tripleCount);
            ret = Math.max(ret,much);
            ret += miss3Con;
            return ret;
        }
        
        int ret = 0;
        ret = Math.max(ret,miss3Con);
        ret = Math.max(ret,tripleCount);
        return ret;
    }

    static class Unit implements Comparable<Unit>{
        public final int predictLen;
        public final int doneLen;
        public final String s;
        public final int hv;
        public Unit(int predictLen,int doneLen,int hv,String s){
            this.predictLen=predictLen;
            this.doneLen=doneLen;
            this.hv=hv;
            this.s=s;
        }
        public int compareTo(Unit u){
            if(u.predictLen!=this.predictLen){
                return this.predictLen-u.predictLen;
            }
            if(u.doneLen!=this.doneLen){
                return u.doneLen-this.doneLen;
            }
            if(u.hv!=this.hv){
                return this.hv-u.hv;
            }
            return this.s.compareTo(u.s);
        }
    }

}
