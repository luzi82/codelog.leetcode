import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        Solution solution = new Solution();

        NestedInteger ni = solution.deserialize("324");
        aassert(ni.getInteger()==324);

        ni = solution.deserialize("[123,[456,[789]]]");
        aassert(ni.getList().size()==2);
        aassert(ni.getList().get(0).getInteger()==123);
        aassert(ni.getList().get(1).getList().size()==2);
        aassert(ni.getList().get(1).getList().get(0).getInteger()==456);
        aassert(ni.getList().get(1).getList().get(1).getList().size()==1);
        aassert(ni.getList().get(1).getList().get(1).getList().get(0).getInteger()==789);

        ni = solution.deserialize("-3");
        aassert(ni.getInteger()==-3);
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
