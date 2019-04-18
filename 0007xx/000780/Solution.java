import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(true){
            // obvious
            if(tx<sx)return false;
            if(ty<sy)return false;
            // break look and perform O(1) check
            if(tx==sx)break;
            if(ty==sy)break;
            // gcd(tx,ty)!=gcd(sx,sy)
            if(ty%tx==0)return false;
            if(tx%ty==0)return false;
            // reduce tx,ty
            if(ty>tx){ty%=tx;}else{tx%=ty;}
        }
        if((tx==sx)&&(ty>=sy)&&((ty-sy)%sx==0))return true;
        if((ty==sy)&&(tx>=sx)&&((tx-sx)%sy==0))return true;
        return false;
    }
}
