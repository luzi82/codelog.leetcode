import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("1.1.1.1","1[.]1[.]1[.]1");
        test("255.100.50.0","255[.]100[.]50[.]0");
    }
    
    public static void test(String address,String expected){
        System.out.println(String.format("address=%s, expected=%s",address,expected));
        Solution solution = new Solution();
        String result = solution.defangIPaddr(address);
        System.out.println(String.format("result=%s",result));
        aassert(result.equals(expected));
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

    public static String join(boolean[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(boolean v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Boolean.toString(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(long[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(long v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Long.toString(v));
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
            if(v==null){
                sb.append("null");
            }else{
                sb.append(v.toString());
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static int[][] to2D(int[] vAry, int l){
      int[][] ret = new int[vAry.length/l][l];
      for(int i=0;i<vAry.length;++i){
        ret[i/l][i%l]=vAry[i];
      }
      return ret;
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
