class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        return (0..(2*n-1)).map{nums[it/2+(it%2)*n]}.toIntArray()
    }
}
