import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("[[1,1],2,[1,1]]",new Integer[]{1,1,2,1,1});
        test("[1,[4,[6]]]",new Integer[]{1,4,6});
        // my case
        test("[]",new Integer[]{});
        test("[1,[]]",new Integer[]{1});
        test("[[],[]]",new Integer[]{});
    }
    
    public static void test(String niString,Integer[] expected){
        System.out.println(String.format("nestedList=%s, expected=%s",niString,join(expected)));
        NestedInteger ni = NestedInteger.deserialize(niString);
        NestedIterator nItr = new NestedIterator(ni.getList());
        LinkedList<Integer> intList = new LinkedList<>();
        while(nItr.hasNext()){
            intList.addLast(nItr.next());
        }
        Integer[] intAry = intList.toArray(new Integer[0]);
        System.out.println(String.format("result=%s",join(intAry)));
        aassert(Arrays.equals(expected,intAry));
    }
    
    public static String join(int[][] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int[] v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(join(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Integer.toString(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(Object v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(v.toString());
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
