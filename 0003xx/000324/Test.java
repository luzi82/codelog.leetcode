import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // description sample
        aassert(test(new int[]{1,5,1,1,6,4}));
        aassert(test(new int[]{1,3,2,2,3,1}));
        // my case
        aassert(test(new int[]{1,2}));
        aassert(test(new int[]{2,1}));
        aassert(test(new int[]{0}));
        aassert(test(new int[]{}));
        // monkey
        Random rand = new Random(0);
        for(int i=0;i<10000;++i){
            while(true){
                int[] nums=new int[3+rand.nextInt(8)];
                for(int j=0;j<nums.length;++j){
                    nums[j]=rand.nextInt(4);
                }
                if(!possible(nums))continue;
                aassert(test(nums));
                break;
            }
        }
    }
    
    public static boolean possible(int[] nums){
        int[] n2Ary = nums.clone();
        Arrays.sort(n2Ary);
        int[] output = new int[nums.length];
        int medIdx = (nums.length-1)/2;
        for(int i=0;i<nums.length;i+=2){
            output[i] = n2Ary[medIdx];
            --medIdx;
        }
        medIdx = nums.length-1;
        for(int i=1;i<nums.length;i+=2){
            output[i] = n2Ary[medIdx];
            --medIdx;
        }
        System.err.println(String.format("possible? %s",join(output)));
        return test(output);
    }
    
    public static boolean test(int[] nums){
        System.out.println(String.format("input  nums=%s",join(nums)));
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        System.out.println(String.format("output nums=%s",join(nums)));
        for(int i=0;i<nums.length-1;++i){
            if(i%2==0){
                if(nums[i]>=nums[i+1])return false;
            }else{
                if(nums[i]<=nums[i+1])return false;
            }
        }
        return true;
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
