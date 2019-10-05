class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[] tmp0A = arr;
        int[] tmp1A = null;
        
        int ret=0;
        while(tmp0A.length>1){
            int minIdx = 0;
            int minSum = tmp0A[0]*tmp0A[1];
            for(int i=1;i<tmp0A.length-1;++i){
                int sum = tmp0A[i]*tmp0A[i+1];
                if(sum<minSum){
                    minIdx=i;minSum=sum;
                }
            }
            
            ret += minSum;
            
            tmp1A = tmp0A;
            tmp0A = new int[tmp1A.length-1];
            
            for(int i=0;i<minIdx;++i){
                tmp0A[i] = tmp1A[i];
            }
            tmp0A[minIdx] = Math.max(tmp1A[minIdx],tmp1A[minIdx+1]);
            for(int i=minIdx+1;i<tmp0A.length;++i){
                tmp0A[i] = tmp1A[i+1];
            }
        }
        
        return ret;
    }
}
