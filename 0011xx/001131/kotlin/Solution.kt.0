class Solution {
    fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
        val size=arr1.size
        var ret=0
        for(i in 0..(size-1)){
            for(j in 0..i){
                val d1=abs(arr1[i]-arr1[j])
                val d2=abs(arr2[i]-arr2[j])
                val d3=abs(i-j)
                ret = max(ret,d1+d2+d3)
            }
        }
        return ret
    }
    
    fun abs(x:Int):Int{
        return kotlin.math.abs(x)
    }
    fun max(a:Int,b:Int):Int{
        return kotlin.math.max(a,b)
    }
}
