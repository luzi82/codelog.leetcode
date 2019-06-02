import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class IntAryToVector{

    public static Vector<Integer> intAryToVector(int[] ary){
        Vector<Integer> ret = new Vector<>(ary.length);
        for(int i=0;i<ary.length;++i){
            ret.add(ary[i]);
        }
        return ret;
    }
    
    public static void main(String[] argv){
        Vector<Integer> intVec = intAryToVector(new int[]{1,2,3});
        aassert(intVec.size()==3);
        aassert(intVec.get(0)==1);
        aassert(intVec.get(1)==2);
        aassert(intVec.get(2)==3);
    }

    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }

}
