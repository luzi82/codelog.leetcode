import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class JTest{

    static class OArray{
        public final Object[] vList;
        public OArray(Object[] vList){
            this.vList=vList;
        }
        public int hashCode(){ // must
            return Arrays.hashCode(vList);
        }
        public boolean equals(Object obj){ // must
            if (obj instanceof OArray){
                OArray o = (OArray)obj;
                return Arrays.deepEquals(this.vList,o.vList);
            }
            return false;
        }
    }
    
    static class I{
        public int i;
        public I(int i){
            this.i=i;
        }
        public boolean equals(Object obj){ // must
            if (obj instanceof I){
                I o = (I)obj;
                return i==o.i;
            }
            return false;
        }
    }

    public static void main(String[] argv){
        HashSet<OArray> intListSet = new HashSet<>();
        intListSet.add(new OArray(new Object[]{1,3}));
        intListSet.add(new OArray(new Object[]{2,4,6}));
        aassert(intListSet.contains(new OArray(new Object[]{1,3})));
        aassert(!intListSet.contains(new OArray(new Object[]{3,1})));
        aassert(!intListSet.contains(new OArray(new Object[]{2,3})));
        aassert(intListSet.size()==2);
        
        I i0 = new I(1);
        I i1 = new I(1);
        aassert(i0.equals(i1));
        
        aassert("a".split("a").length==0);
        aassert("aba".split("a").length==2);
        aassert("aba".split("a")[0].equals(""));
        aassert("aba".split("a")[1].equals("b"));
    }

    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
