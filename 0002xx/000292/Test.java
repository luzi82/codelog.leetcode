import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // no test for it
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
