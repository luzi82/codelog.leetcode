import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        for(int i=0;i<100;++i){
            Solution solution = new Solution();
            int[] result = solution.countBits(i);
            aassert(result.length == i+1);
            System.out.println(String.format("%d: %s", i, Arrays.toString(result)));
            for(int j=0;j<result.length;++j){
                int c = 0;
                int jj = j;
                while(jj>0){
                    if((jj&1)==1){
                        ++c;
                    }
                    jj >>= 1;
                }
                aassert(result[j]==c);
            }
        }
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
