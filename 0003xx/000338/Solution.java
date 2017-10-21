class Solution {
    public int[] countBits(int num) {
        /* theory: (binary number)
        f(101) = f(1) + 1 = f(0)+1+1 = 0+1+1 = 2
        use past result to do the math
        101: done = 100, ptr = 01
        */
    
        // hardcode
        if(num==0){
            return new int[]{0};
        }
        
        int[] result = new int[num+1]; // answer
        int done=0; // increase in 1,2,4,8...
        int ptr=0;  // ptr<done
        
        for(int i=0;i<=num;++i){
            // hardcode
            if(i==0){
                result[i] = 0;
                continue;
            }else if(i==1){
                result[i] = 1;
                done = 1;
                ptr = 0;
                continue;
            }
            
            ++ptr;
            if(ptr==done){
                done *= 2;
                ptr = 0;
            }
            
            result[i] = result[ptr] + 1;
        }
        
        return result;
    }
}
