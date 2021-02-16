class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        return (0..(2*n-1)).map{(it/2,it%2==0)}.map{nums[it[0]+it[1]*n]}.toIntArray()
    }
}
