import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(
          new int[]{
            2,1,
            2,2,
            3,3
          },
          90,
          new int[]{1,1},
          3
        );
        test(
          new int[]{
            2,1,
            2,2,
            3,4,
            1,1
          },
          90,
          new int[]{1,1},
          4
        );
        test(
          new int[]{
            1,0,
            2,1
          },
          13,
          new int[]{1,1},
          1
        );
    }

    public static void test(int[] ppoints,int angle,int[] llocation,int expected){
        System.out.println(String.format("ppoints=%s, angle=%d, llocation=%s expected=%d",join(ppoints),angle,join(llocation),expected));
        List<List<Integer>> points = toPoints(ppoints);
        List<Integer> location = toPoint(llocation);
        Solution solution = new Solution();
        int result = solution.visiblePoints(points,angle,location);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static List<List<Integer>> toPoints(int[] vAry){
      List<List<Integer>> ret = new Vector<>();
      for(int i=0;i<vAry.length;i+=2){
        int x = vAry[i];
        int y = vAry[i+1];
        Vector<Integer> xy = new Vector<>();
        xy.add(x);
        xy.add(y);
        ret.add(xy);
      }
      return ret;
    }
    
    public static List<Integer> toPoint(int[] xy){
      Vector<Integer> ret = new Vector<>();
      ret.add(xy[0]);
      ret.add(xy[1]);
      return ret;
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
