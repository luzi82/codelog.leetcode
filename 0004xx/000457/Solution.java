import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int numsLen = nums.length;
        
        // make all num in (-len,len) range
        // dependency of [QPIPYJZUQI]
        for(int i=0;i<numsLen;++i){
            nums[i]%=numsLen;
        }
        
        // go forward, mark visited node +len or -len
        // when get a visited node (-len,+len), good, [QPIPYJZUQI]
        // when get a dead node or reverse node, mark all passed node dead (not the end node)
        // mark node dead by = 0
        for(int i=0;i<numsLen;++i){
            // ignore dead node
            if(nums[i]==0)continue;
            
            int positive = (nums[i]>0)?1:-1;
            
            int ptr = i;
            while(true){
                int num = nums[ptr];

                // see dead node, bad
                if(num==0) break;

                // see reversed node, bad
                if(num*positive<0) break;

                // see visited node, good
                if(num*positive>=numsLen) return true;

                // mark node visited
                nums[ptr] += positive*numsLen;
                
                // go next 
                ptr += num;
                ptr += numsLen;
                ptr %= numsLen;
            }
            
            // mark node dead
            ptr=i;
            while(true){
                int num = nums[ptr];

                // see dead node, end
                if(num==0) break;

                // see reversed node, end
                if(num*positive<0) break;

                // mark node dead
                nums[ptr] = 0;
                
                // go next 
                ptr += num;
                ptr += numsLen*2;
                ptr %= numsLen;
            }
        }
        
        // no loop is found
        return false;
    }
}
