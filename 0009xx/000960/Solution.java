import java.util.Arrays;

class Solution {

    public int minDeletionSize(String[] A) {
        char[][] charAryAry = new char[A.length][];
        for(int i=0;i<A.length;++i){
            charAryAry[i] = A[i].toCharArray();
        }

        int[] seqLenAry = new int[charAryAry[0].length];
        
        // build seqLenAry, DP
        for(int i=0;i<seqLenAry.length;++i){
            int seqLen = 1;
            
            for(int j=i-1;j>=0;--j){
                if(seqLenAry[j]+1 <= seqLen) continue; // fast skip
                if(!lte(charAryAry,j,i)) continue;
                seqLen = seqLenAry[j]+1;
            }
            
            seqLenAry[i] = seqLen;
        }
        
        int seqLenMax = Arrays.stream(seqLenAry).max().getAsInt();
        
        int ret = seqLenAry.length - seqLenMax;
        
        return ret;
    }
    
    public static boolean lte(char[][] charAryAry,int a,int b){
        for(int i=0;i<charAryAry.length;++i){
            if(charAryAry[i][a] >= charAryAry[i][b])return false;
        }
        
        return true;
    }

}
