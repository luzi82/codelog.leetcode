class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val maxCandy = candies.max() ?: 0
        return candies.map{it+extraCandies}.map{it>=maxCandy}.toBooleanArray()
    }
}
