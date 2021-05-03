class Solution {
    fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
        val size=arr1.size
        var ret=0
        
        var l0 =  arr1[0]+arr2[0]
        var l1 =  arr1[0]-arr2[0]
        var l2 = -arr1[0]+arr2[0]
        var l3 = -arr1[0]-arr2[0]

        for(i in 1..(size-1)){
          ret = max(ret,l0-arr1[i]-arr2[i]+i)
          ret = max(ret,l1-arr1[i]+arr2[i]+i)
          ret = max(ret,l2+arr1[i]-arr2[i]+i)
          ret = max(ret,l3+arr1[i]+arr2[i]+i)
          l0 = max(l0, arr1[i]+arr2[i]-i)
          l1 = max(l1, arr1[i]-arr2[i]-i)
          l2 = max(l2,-arr1[i]+arr2[i]-i)
          l3 = max(l3,-arr1[i]-arr2[i]-i)
        }
        return ret
    }
    
    fun max(a:Int,b:Int):Int{
        return kotlin.math.max(a,b)
    }
}
