class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val sumAry: IntArray = IntArray(nums.size)
        var sum = 0
        for((i,v) in nums.withIndex()){
          sum += v
          sumAry[i] = sum 
        }
        return sumAry
    }
}
