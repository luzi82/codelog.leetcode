class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val maxCandy = candies.max() ?: 0
        val passCandy = maxCandy - extraCandies
        return candies.map{it>=passCandy}.toBooleanArray()
    }
}
