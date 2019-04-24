import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        NumArray na = new NumArray(new int[]{1,3,5});
        aassertEq(9,na.sumRange(0,2));
        na.update(1,2);
        aassertEq(8,na.sumRange(0,2));
        
        // monkey
        Random random = new Random(0);
        for(int i=0;i<100;++i){
            int len = 1+random.nextInt(10);
            int[] vA = new int[len];
            for(int j=0;j<len;++j){
                vA[j] = random.nextInt(21)-10;
            }
            System.err.println("init "+join(vA));
            na = new NumArray(vA.clone());

            for(int k=0;k<100;++k){
                int t = random.nextInt(2);
                if(t==0){
                    int t0 = random.nextInt(len);
                    int t1 = random.nextInt(len);
                    int s = Math.min(t0,t1);
                    int e = Math.max(t0,t1);
                    int result = na.sumRange(s,e);
                    int expected = 0;
                    for(int j=s;j<=e;++j){
                        expected += vA[j];
                    }
                    aassertEq(expected,result);
                }else{
                    int idx = random.nextInt(len);
                    int val = random.nextInt(21)-10;
                    vA[idx] = val;
                    System.err.println(String.format("%d = %d",idx,val));
                    na.update(idx,val);
                }
            }
        }
    }
    
//    public static void test(int x,boolean expected){
//        System.out.println(String.format("x=%d, expected=%s",x,expected));
//        Solution solution = new Solution();
//        boolean result = solution.func(x);
//        System.out.println(String.format("result=%s",result));
//        aassert(result == expected);
//    }

    public static void aassertEq(int expected,int result){
        System.out.println(String.format("expected=%d, result=%d",expected,result));
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
