import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class NumArray {

    int[][] vAA;

    public NumArray(int[] nums) {
        int layerCount = 1;
        int t = 1;
        while(t<nums.length){
            t*=2;
            ++layerCount;
        }
        
        vAA = new int[layerCount][];
        t = nums.length;
        vAA[0] = nums.clone();
        ++t;t/=2;
        for(int i=1;i<layerCount;++i){
            vAA[i]=new int[t];
            for(int j=0;j<vAA[i-1].length;++j){
                vAA[i][j/2]+=vAA[i-1][j];
            }
            ++t;t/=2;
        }
    }
    
    public void update(int i, int val) {
        vAA[0][i] = val;
        i/=2;
        for(int l=1;l<vAA.length;++l){
            int lhsIdx = i*2;
            int lhs = vAA[l-1][lhsIdx];
            int rhsIdx = lhsIdx+1;
            int rhs = (rhsIdx<vAA[l-1].length)?vAA[l-1][rhsIdx]:0;
            vAA[l][i] = lhs + rhs;
            i/=2;
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(vAA.length-1,0,i,j+1);
    }
    
    int sumRange(int layer,int idx,int i,int k){
        if(layer==0){
            if((i<=idx)&&(idx<k))return vAA[0][idx];
        }
        int s = idx<<layer;
        int e = (idx+1)<<layer;
        if((i<=s)&&(e<=k)) return vAA[layer][idx];
        int m = (s+e)/2;
        int ret = 0;
        if(i<m){
            ret += sumRange(layer-1,idx*2,i,k);
        }
        if(k>m){
            ret += sumRange(layer-1,idx*2+1,i,k);
        }
        return ret;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
 