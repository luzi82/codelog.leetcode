import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    static final long BIG = 1000000000L+7;

    public int numDecodings(String s) {
        char[] charAry = s.toCharArray();
        
        long[] cntAry = new long[charAry.length+1];
        cntAry[0] = 1;
        
        cntAry[1] = (charAry[0]=='*') ? 9 : 
                    (charAry[0]=='0') ? 0 :
                    1;
        //System.err.println(cntAry[1]);

        for(int i=1;i<charAry.length;++i){
            long cnt1 = cntAry[i-1];
            long cnt0 = cntAry[i];
            char char1 = charAry[i-1];
            char char0 = charAry[i];
            
            long cnt = 0;

            if(char1=='*'&&char0=='*'){
                cnt += 15*cnt1;
            }else if(char1=='*'&&char0<='6'){
                cnt += 2*cnt1;
            }else if(char1=='*'){
                cnt += 1*cnt1;
            }else if(char1=='2'&&char0=='*'){
                cnt += 6*cnt1;
            }else if(char1=='2'&&char0<='6'){
                cnt += 1*cnt1;
            }else if(char1=='1'&&char0=='*'){
                cnt += 9*cnt1;
            }else if(char1=='1'){
                cnt += 1*cnt1;
            }

            //System.err.println("YWVHODXUYV "+cnt);
            
            if(char0=='*') cnt+=9*cnt0;
            else if(char0=='0') cnt+=0;
            else cnt+=1*cnt0;
            
            cnt%=BIG;
            
            cntAry[i+1] = cnt;
            //System.err.println(cntAry[i+1]);
        }
        
        return (int)cntAry[charAry.length];
    }
}
