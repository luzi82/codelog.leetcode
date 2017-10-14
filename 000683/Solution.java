import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public int kEmptySlots(int[] flowers, int k) {
        // convert the flowers into flower_day_ary
        // flowers[i] = j -> flower_day_ary[j] = i
        // 
        // on flower_day_ary, for suitable array:
        // left, i0, i1 ... i(k-1), right
        // i(x) > left, i(x) > right for all x
        //
        // to find suitable left/right
        // we scan flower_day_ary
        // if i(x) < left or i(x) > right, i(x) become new left
        
        // edge cases
        if (flowers.length<2) return -1;
        if (flowers.length<k+2) return -1;
        
        // convert the flowers into flower_day_ary
        int[] flower_day_ary=new int[flowers.length];
        for(int i=0;i<flowers.length;++i){
            flower_day_ary[flowers[i]-1] = i;
        }
        
        // scan flower_day_ary
        int left_ptr=-1;
        int left_v=-1;
        int right_ptr=-1;
        int right_v=-1;

        int best_ans = flowers.length+10;

        boolean is_find_done = false;
        
        for(int i=0;i<flower_day_ary.length;++i){
            boolean reset_mark = false;
            if(left_ptr==-1){
                reset_mark = true;
            }else if(i==right_ptr){
                is_find_done = true;
                int ans = Math.max(left_v,right_v);
                if(ans<best_ans){
                    best_ans = ans;
                }
                reset_mark = true;
            }else{
                int v = flower_day_ary[i];
                if(v<left_v)reset_mark=true;
                if(v<right_v)reset_mark=true;
            }
            
            if(reset_mark){
                left_ptr = i;
                right_ptr = left_ptr+k+1;
                if(right_ptr>=flower_day_ary.length){
                    break;
                }
                left_v = flower_day_ary[left_ptr];
                right_v = flower_day_ary[right_ptr];
            }
        }
        
        // return
        if(is_find_done){
            return best_ans+1;
        }
        return -1;
    }
    
    public static void main(String[] argv){
        test(new int[]{1,3,2},1,2);
        test(new int[]{1,2,3},1,-1);
        test(new int[]{3,9,2,8,1,6,10,5,4,7},1,6);
    }
    
    public static void test(int[] flowers, int k,int expected){
        System.out.println(String.format("flowers=%s, k=%d, expected=%d",Arrays.toString(flowers),k,expected));
        Solution solution = new Solution();
        int result = solution.kEmptySlots(flowers, k);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
