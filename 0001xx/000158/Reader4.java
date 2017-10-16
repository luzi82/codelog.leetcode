import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class Reader4{
    
    public char[] _contentAry;
    public int _done=0;
    
    public int read4(char[] buf){
        int len=Math.min(4,_contentAry.length-_done);
        for(int i=0;i<len;++i){
            buf[i] = _contentAry[_done];
            ++_done;
        }
        return len;
    }
    
}
