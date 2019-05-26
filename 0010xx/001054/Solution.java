import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> codeToCountMap = new HashMap<>();
        for(int code:barcodes){
            if(!codeToCountMap.containsKey(code)){
                codeToCountMap.put(code,1);
            }else{
                codeToCountMap.put(code,codeToCountMap.get(code)+1);
            }
        }
        
        int[][] countCodeAry = new int[codeToCountMap.size()][2];
        int offset=0;
        for(Map.Entry<Integer,Integer> codeToCount : codeToCountMap.entrySet()){
            countCodeAry[offset] = new int[]{codeToCount.getValue(),codeToCount.getKey()};
            ++offset;
        }
        
        Arrays.sort(countCodeAry,new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                for(int i=0;i<o1.length;++i){
                    if(o1[i]<o2[i])return 1;
                    if(o1[i]>o2[i])return -1;
                }
                return 0;
            }
        });
        
        int[] tmp0Ary = new int[barcodes.length];
        offset=0;
        for(int[] countCode:countCodeAry){
            int count = countCode[0];
            int code = countCode[1];
            for(int i=0;i<count;++i){
                tmp0Ary[offset++]=code;
            }
        }
        
        int[] tmp1Ary = new int[barcodes.length];
        offset=0;
        for(int i=0;i<tmp0Ary.length;++i){
            tmp1Ary[offset] = tmp0Ary[i];
            offset+=2;
            if(offset>=tmp0Ary.length)offset=1;
        }
        
        return tmp1Ary;
    }
}
