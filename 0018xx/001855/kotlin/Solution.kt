class Solution {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var ret = 0
        for(i in nums1.indices){
            val a = nums1[i]
            val j = findJ(nums2,a)
            if(j<0){continue}
            if(j<=i){continue}
            val k=j-i
            if(k<=ret){continue}
            ret = k
        }
        return ret
    }
    
    // find right most j which nums2[j] >= a
    fun findJ(nums2: IntArray, a:Int): Int{
        if(a>nums2[0]){return -1}
        if(a<=nums2[nums2.size-1]){return nums2.size-1}
        var left=0 // nums2[left] >= a
        var right=nums2.size-1 // nums[right] < a
        while(true){
            if(left==right-1){return left}
            val mid = (left+right)/2
            val midV = nums2[mid]
            if(midV>=a){
                left=mid
            }else{
                right=mid
            }
        }
    }
}
