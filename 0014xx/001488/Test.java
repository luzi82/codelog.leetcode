import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{1,2,3,4},true);
        test(new int[]{1,2,0,0,2,1},true);
        test(new int[]{1,2,0,1,2},false);
        test(new int[]{69,0,0,0,69},true);
        test(new int[]{10,20,20},false);
    }
    
    public static void test(int[] rains,boolean pass){
        System.out.println(String.format("rains=%s, pass=%s",join(rains),pass));
        Solution solution = new Solution();
        int[] result = solution.avoidFlood(rains);
        System.out.println(String.format("result=%s",join(result)));
        if(pass){
          aassert(result.length == rains.length);
          HashSet<Integer> fullLake = new HashSet<>();
          for(int i=0;i<rains.length;++i){
            int rain = rains[i];
            int empty = result[i];
            if(rain==0){
              if(empty!=-1){
                fullLake.remove(empty);
              }
            }else{
              aassert(empty==-1);
              aassert(!fullLake.contains(rain));
              fullLake.add(rain);
            }
          }
        }else{
          aassert(result.length==0);
        }
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
            if(v==null){
                sb.append("null");
            }else{
                sb.append(v.toString());
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
