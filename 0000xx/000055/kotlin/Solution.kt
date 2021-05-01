class Solution {
    fun canJump(nums: IntArray): Boolean {
        var possibleRange = 0
        
        for(i in nums.indices){
            if(i>possibleRange)break
            possibleRange = kotlin.math.max(possibleRange,i+nums[i])
        }
        
        return possibleRange >= (nums.size-1)
    }
}
