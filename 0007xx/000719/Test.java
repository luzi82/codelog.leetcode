import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // sub test
        {
            int[] nums=new int[]{2,0,3,2,2,3,5,5,7};
            TreeMap<Integer,Integer> nToCountMap = Solution.createNToCountMap(nums);
            //for(Map.Entry<Integer,Integer> me:nToCountMap.entrySet()){
            //    System.out.println(String.format("%d %d",me.getKey(),me.getValue()));
            //}
            aassert(Arrays.equals(Solution.getRankRange(0,nToCountMap),new int[]{0,5}));
            aassert(Arrays.equals(Solution.getRankRange(1,nToCountMap),new int[]{5,11}));
            aassert(on2(nums,10+1)==1);
            aassert(on2(nums,11+1)==2);
            aassert(on2(nums,19+1)==2);
            aassert(on2(nums,20+1)==3);
            aassert(Arrays.equals(Solution.getRankRange(2,nToCountMap),new int[]{11,20}));
            aassert(Arrays.equals(Solution.getRankRange(3,nToCountMap),new int[]{20,28}));
        }
    
        // given
        test(new int[]{1,3,1},1,0);
        // my case
        test(new int[]{1,3,1},2,2);
        test(new int[]{1,3,1},3,2);
        test(new int[]{1,2,3,4},1,1);
        test(new int[]{1,2,3,4},2,1);
        test(new int[]{1,2,3,4},3,1);
        test(new int[]{1,2,3,4},4,2);
        test(new int[]{1,2,3,4},5,2);
        test(new int[]{1,2,3,4},6,3);
        // monkey test
        Random random = new Random(0);
        for(int cc=0;cc<1000;++cc){
            int[] nums = new int[2+random.nextInt(100)];
            for(int i=0;i<nums.length;++i){
                nums[i] = random.nextInt(100);
            }
            int k = 1+random.nextInt((nums.length)*(nums.length-1)/2);
            int expected = on2(nums,k);
            test(nums,k,expected);
        }
    }
    
    public static int on2(int[] nums, int k){
        int[] lenAry = new int[(nums.length)*(nums.length-1)/2];
        int offset = 0;
        for(int i=0;i<nums.length;++i){
            for(int j=0;j<i;++j){
                lenAry[offset++] = Math.abs(nums[i]-nums[j]);
            }
        }
        aassert(offset==lenAry.length);
        Arrays.sort(lenAry);
        //System.out.println(join(lenAry));
        return lenAry[k-1];
    }
    
    public static void test(int[] nums, int k,int expected){
        System.out.println(String.format("nums=%s, k=%d, expected=%d",join(nums),k,expected));
        Solution solution = new Solution();
        int result = solution.smallestDistancePair(nums,k);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
        //aassert(on2(nums,k)==expected);
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
