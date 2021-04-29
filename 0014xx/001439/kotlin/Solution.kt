class Solution {
    fun kthSmallest(mat: Array<IntArray>, k: Int): Int {
        val m:Int = mat.size
        val n:Int = mat[0].size
        
        var vAry:IntArray=mat[0]
        if(vAry.size>k){
            vAry = vAry.copyOf(k)
        }
        for(mi in 1..(m-1)){
            val ary = mat[mi]
            var vAry0:IntArray = IntArray(vAry.size*n)
            var i=0
            for(a in vAry){
                for(b in ary){
                    vAry0[i]=a+b
                    i+=1
                }
            }
            vAry = vAry0
            vAry.sort()
            if(vAry.size>k){
                vAry = vAry.copyOf(k)
            }
        }
        return vAry[k-1]
    }
}
