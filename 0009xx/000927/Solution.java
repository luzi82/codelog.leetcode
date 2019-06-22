import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] threeEqualParts(int[] A) {
        if(A.length<3){return new int[]{-1,-1};}
        
        int oneCount = 0;
        for(int a:A){
            oneCount += a;
        }
        
        if(oneCount%3!=0){return new int[]{-1,-1};}
        
        if(oneCount==0){
            return new int[]{0,2};
        }

        //System.err.println(String.format("oneCount=%d",oneCount));
        
        int u=0;int v=0;int w=0;
        int oneCount3 = oneCount/3;

        //System.err.println(String.format("oneCount3=%d",oneCount3));

        oneCount = 0;
        for(int t=0;t<A.length;++t){
            int a = A[t];
            if(a==1){
                if(oneCount%oneCount3==oneCount3-1){
                    if(oneCount/oneCount3==0){
                        u=t;
                    }else if(oneCount/oneCount3==1){
                        v=t;
                    }else if(oneCount/oneCount3==2){
                        w=t;
                    }
                }
            }
            oneCount+=a;
        }
        
        //System.err.println(String.format("u=%d v=%d w=%d",u,v,w));
        
        // check right zero
        for(int wd=w+1;wd<A.length;++wd){
            int d = wd-w;
            if(A[u+d]!=0){return new int[]{-1,-1};}
            if(A[v+d]!=0){return new int[]{-1,-1};}
        }
        
        int i1=u+A.length-w;
        int j=v+A.length-w;
        
        //System.err.println(String.format("i1=%d j=%d",i1,j));
        
        // check left same
        for(int wd=w;;--wd){
            int d = wd-w;
            int ud = u+d;
            int vd = v+d;
            if(ud<0)break;
            if(vd<i1)break;
            if(wd<j)break;
            if(A[ud]!=A[wd]){return new int[]{-1,-1};}
            if(A[vd]!=A[wd]){return new int[]{-1,-1};}
        }
        
        return new int[]{i1-1,j};
    }
}
