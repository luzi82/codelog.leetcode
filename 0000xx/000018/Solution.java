import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public static class I2{
        public int cIdx,dIdx;
        public int hashCode(){
            return Arrays.hashCode(new int[]{cIdx,dIdx});
        }
        public boolean equals(Object otherO){
            if(!(otherO instanceof I2))return false;
            I2 other = (I2) otherO;
            if(this.cIdx!=other.cIdx)return false;
            if(this.dIdx!=other.dIdx)return false;
            return true;
        }
    }
    public static class I4{
        public int a,b,c,d;
        public int hashCode(){
            return Arrays.hashCode(new int[]{a,b,c,d});
        }
        public boolean equals(Object otherO){
            if(!(otherO instanceof I4))return false;
            I4 other = (I4) otherO;
            if(this.a!=other.a)return false;
            if(this.b!=other.b)return false;
            if(this.c!=other.c)return false;
            if(this.d!=other.d)return false;
            return true;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // sort nums
        Arrays.sort(nums);
        
        // reduce dup number to 4
        int[] numList0 = new int[nums.length];
        int numList0Size = 0;
        for(int i=0;i<nums.length;++i){
            if((i>=4)&&(nums[i]==nums[i-4]))continue;
            numList0[numList0Size] = nums[i];
            ++numList0Size;
        }
        
        HashMap<Integer,HashSet<I2>> cdSumToI2Set = new HashMap<>();
        // create cd table
        for(int cIdx=2;cIdx<numList0Size-1;++cIdx){
            for(int dIdx=cIdx+1;dIdx<numList0Size;++dIdx){
                int cdSum = numList0[cIdx]+numList0[dIdx];
                I2 i2 = new I2();i2.cIdx=cIdx;i2.dIdx=dIdx;
                put(cdSumToI2Set, cdSum, i2);
            }
        }
        
        HashSet<I4> ansI4Set = new HashSet<>();
        // scan ab
        for(int bIdx=1;bIdx<numList0Size-2;++bIdx){
            if(bIdx>=2){
                for(int b2Idx=bIdx+1;b2Idx<numList0Size;++b2Idx){
                    int sum = numList0[bIdx]+numList0[b2Idx];
                    I2 i2 = new I2();i2.cIdx=bIdx;i2.dIdx=b2Idx;
                    remove(cdSumToI2Set, sum, i2);
                }
            }
            for(int aIdx=0;aIdx<bIdx;++aIdx){
                int a = numList0[aIdx];
                int b = numList0[bIdx];
                int cdSum = target-a-b;
                if(!cdSumToI2Set.containsKey(cdSum))continue;
                for(I2 i2:cdSumToI2Set.get(cdSum)){
                    int c = numList0[i2.cIdx];
                    int d = numList0[i2.dIdx];
                    I4 i4 = new I4();
                    i4.a=a;i4.b=b;i4.c=c;i4.d=d;
                    ansI4Set.add(i4);
                }
            }
        }
        
        LinkedList<List<Integer>> ret = new LinkedList<>();
        for(I4 i4:ansI4Set){
            LinkedList<Integer> u=new LinkedList<>();
            u.addLast(i4.a);
            u.addLast(i4.b);
            u.addLast(i4.c);
            u.addLast(i4.d);
            ret.addLast(u);
        }

        return ret;
    }
    
    void put(HashMap<Integer,HashSet<I2>>cdSumToI2Set,int cdSum,I2 i2){
        if(!cdSumToI2Set.containsKey(cdSum)){
            cdSumToI2Set.put(cdSum,new HashSet<I2>());
        }
        HashSet<I2> i2Set = cdSumToI2Set.get(cdSum);
        i2Set.add(i2);
    }

    void remove(HashMap<Integer,HashSet<I2>>cdSumToI2Set,int cdSum,I2 i2){
        HashSet<I2> i2Set = cdSumToI2Set.get(cdSum);
        i2Set.remove(i2);
        if(i2Set.isEmpty()){
            cdSumToI2Set.remove(cdSum);
        }
    }
}
