import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(new int[]{1,3,2,3,1},2);
        test(new int[]{2,4,3,5,1},3);
        test(new int[]{},0);
        Random random=new Random(0);
        for(int c=0;c<100;++c){
            int[] nums=random.ints(100,-100,100).toArray();
            int ans=0;
            for(int j=0;j<nums.length;++j){
                for(int i=0;i<j;++i){
                    if((long)nums[i]>2*(long)nums[j])++ans;
                }
            }
            test(nums,ans);
        }
        for(int c=0;c<100;++c){
            int[] nums=random.ints(10000).toArray();
            int ans=0;
            for(int j=0;j<nums.length;++j){
                for(int i=0;i<j;++i){
                    if((long)nums[i]>2*(long)nums[j])++ans;
                }
            }
            test(nums,ans);
        }
    }
    
    public static void test(int[] sums,int expected){
        System.out.println(String.format("sums.length=%d, expected=%s",sums.length,expected));
        //for(int i=0;i<sums.length;++i){
        //    System.out.println(""+sums[i]);
        //}
        Solution solution = new Solution();
        int result = solution.reversePairs(sums);
        //System.out.println(String.format("result=%s",result));
        aassert(result == expected);
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
