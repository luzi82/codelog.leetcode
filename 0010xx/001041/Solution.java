import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isRobotBounded(String instructions) {
        char[] cAry = instructions.toCharArray();
        int x=0,y=0;
        int dx=0,dy=1,d=0;
        
        for(int c:cAry){
            if(c=='G'){
                x+=dx;y+=dy;
            }else if(c=='L'){
                int ddx=dx;int ddy=dy;
                dx=-ddy;dy=ddx;
                d+=1;d%=4;
            }else if(c=='R'){
                int ddx=dx;int ddy=dy;
                dx=ddy;dy=-ddx;
                d+=3;d%=4;
            }
        }
        
        if((x==0)&&(y==0))return true;
        if(d!=0)return true;
        return false;
    }
}
