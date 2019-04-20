import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// this code pass, but can be improved by cache and greedy
// Dijkstra is no need

class Solution {
    public static final int SMALL = Integer.MIN_VALUE/4;

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(n1==0)return 0;
        int[][] transformTable = createTransformTable(s1,s2);
        //System.err.println("JDNAOYNXFP "+Test.join(transformTable));
        int ceilLogN1 = getCeilLog(n1);
        int[][][] transformTable2Power = createTransformTable2Power(transformTable,ceilLogN1);
        //System.err.println("RTCPGZZPVQ "+Test.join(transformTable2Power));
        int result = calMaxRepetitions(transformTable2Power,n1);
        result /= n2;
        
        return result;
    }
    
    public static int[][] createTransformTable(String s1,String s2){
        int[][] ret = new int[s2.length()][];
        for(int i=0;i<s2.length();++i){
            ret[i] = createTransformTableOne(s1,s2,i);
        }
        return ret;
    }
    
    public static int[] createTransformTableOne(String s1,String s2,int idx){
        int[] retAry = new int[s2.length()];
        int[] nxtAry = new int[s2.length()];
        for(int i=0;i<s2.length();++i){retAry[i]=SMALL;}
        retAry[idx]=0;
        for(int i=0;i<s1.length();++i){
            char c1 = s1.charAt(i);
            for(int j=0;j<s2.length();++j){
                char c2 = s2.charAt(j);
                int j1=(j+1)%s2.length();
                if(c1==c2){
                    nxtAry[j1] = Math.max(retAry[j1],retAry[j]+((j1==0)?1:0));
                }else{
                    nxtAry[j1] = retAry[j1];
                }
            }
            int[] tmpAry=retAry;retAry=nxtAry;nxtAry=tmpAry;
            //System.err.println("QINQPMEZCA "+Test.join(retAry));
        }
        return retAry;
    }
    
    public static int getCeilLog(int v){
        int ret=0;
        while(v>0){
            v>>=1;
            ++ret;
        }
        return ret;
    }
    
    public static int[][][] createTransformTable2Power(int[][] transformTable,int len){
        int[][][] retAryAryAry = new int[len][][];
        int sLen = transformTable.length;
        retAryAryAry[0] = transformTable;
        for(int i=1;i<len;++i){
            int[][] retAryAry1 = retAryAryAry[i-1];
            int[][] retAryAry0 = new int[sLen][sLen];
            for(int a=0;a<sLen;++a)for(int b=0;b<sLen;++b){
                int ret = SMALL;
                for(int c=0;c<sLen;++c){
                    ret = Math.max(ret,retAryAry1[a][c]+retAryAry1[c][b]);
                }
                retAryAry0[a][b] = ret;
            }
            retAryAryAry[i] = retAryAry0;
        }
        return retAryAryAry;
    }
    
    public static int calMaxRepetitions(int[][][] transformTable2Power,int n1){
        int s2Len = transformTable2Power[0].length;
        int[] ary = new int[s2Len];
        int[] nxtAry = new int[s2Len];
        for(int i=0;i<ary.length;++i){ary[i]=SMALL;}
        ary[0] = 0;
        int idx=0;
        while(n1>0){
            if((n1&1)==1){
                int[][] ttAryAry = transformTable2Power[idx];
                for(int i=0;i<s2Len;++i){ // to
                    int nxt=SMALL;
                    for(int j=0;j<s2Len;++j){ // from
                        nxt = Math.max(nxt,ary[j]+ttAryAry[j][i]);
                    }
                    nxtAry[i] = nxt;
                }
                int[] tmpAry=ary;ary=nxtAry;nxtAry=tmpAry;
            }
            //System.err.println("PBWDELCWRR "+Test.join(ary));
            n1>>=1;
            ++idx;
        }
        int ret = SMALL;
        for(int i:ary){ret=Math.max(ret,i);}
        return ret;
    }
    
}