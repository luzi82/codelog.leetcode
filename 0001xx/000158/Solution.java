import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class Solution extends Reader4 {

    char[] buf4 = new char[4];
    
    boolean isFirstReadDone = false;
    int buf4Len = 0;
    int done = 4;

    boolean isEnded = false;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        n = Math.min(n, buf.length);
        if(isEnded){
            return 0;
        }

        if(n<=0)return 0;

        if(!isFirstReadDone){
            buf4Len = read4(buf4);
            done = 0;
            isFirstReadDone = true;
        }
        
        int outLen = 0;
        
        while(n>0){
            if((buf4Len==4)&&(done==4)){
                buf4Len = read4(buf4);
                done = 0;
            }
            if(done==buf4Len){
                isEnded = true;
                break;
            }

            buf[outLen] = buf4[done];
            ++outLen;
            ++done;
            --n;
        }
        
        return outLen;
    }
}
