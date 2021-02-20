import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(
          new String[]{"pes","fifa","gta","pes(2019)"},
          new String[]{"pes","fifa","gta","pes(2019)"}
        );
        test(
          new String[]{"gta","gta(1)","gta","avalon"},
          new String[]{"gta","gta(1)","gta(2)","avalon"}
        );
        test(
          new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"},
          new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"}
        );
        test(
          new String[]{"wano","wano","wano","wano"},
          new String[]{"wano","wano(1)","wano(2)","wano(3)"}
        );
        test(
          new String[]{"kaido","kaido(1)","kaido","kaido(1)"},
          new String[]{"kaido","kaido(1)","kaido(2)","kaido(1)(1)"}
        );
    }
    
    public static void test(String[] names,String[] expected){
        System.out.println(String.format("names=%s, expected=%s",join(names),join(expected)));
        Solution solution = new Solution();
        String[] result = solution.getFolderNames(names);
        System.out.println(String.format("result=%s",join(result)));
        // aassert(result == expected);
        aassert(Arrays.equals(result, expected));
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
