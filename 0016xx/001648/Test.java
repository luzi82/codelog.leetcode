import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new int[]{2,5},4,14);
        test(new int[]{3,5},6,19);
        test(new int[]{2,8,4,10,6},20,110);
        test(new int[]{1000000000},1000000000,21);
        // WA
        test(
          new int[]{
            848746746,340195275,492168282,328348365,242585070,
            52608287,718002298,109954194,237128277,162852362,
            873355851,864794350,654375225,829781405,787400871,
            200626843,686955275,410478411,918475720,559924081,
            136905228,507461785,232092333,245137944,574926714,
            30812168,317465965,962778112,378816249,197879242,
            294040474,402909117,761755931,611500033,865072256,
            754028421,43869624,454915661,867116568,184444791,
            727022869,95161346,520668662,148445219,223034302,
            817098329,239006355,722638484,799757830,173295272,
            333763113
          },
          166769628,
          720724435
        );
        test(
          new int[]{
            90,24,49,18,88,50,88,84,48,51,
            85,84,53,61,60,90,33,41,75,22,
            43,32,20,87,1,34,36,58,92,93,
            52,18,41,79,17,46,12,31,62,58,
            67,3,60,76,62,87,10,81,70,10,
            23,64,13,29,4,66,62,73,48,29,
            21,13,24,61,28,44,28,91,79,79,
            99,95,40,27,60,35,19,89,33
          }, 26, 2410
        );
    }
    
    public static void test(int[] inventory, int orders,int expected){
        System.out.println(String.format("inventory=%s, orders=%d expected=%d",join(inventory),orders,expected));
        Solution solution = new Solution();
        int result = solution.maxProfit(inventory,orders);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
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
