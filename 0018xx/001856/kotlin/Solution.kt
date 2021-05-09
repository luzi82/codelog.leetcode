import java.util.*

class Solution {
    fun maxSumMinProduct(nums: IntArray): Int {
        // nums[start]+...+nums[end-1] = sumAry[end] - sumAry[start]
        val sumAry = LongArray(nums.size+1){0}
        for(i in nums.indices){
            sumAry[i+1] = sumAry[i] + nums[i]
        }
        
        val leftAry = IntArray(nums.size)
        val vToIdxMap = TreeMap<Int, Int>()
        for(i in nums.indices){
            val v = nums[i]
            val leftMeQ = vToIdxMap.lowerEntry(v)
            leftAry[i] = if(leftMeQ==null){0}else{leftMeQ.value+1}
            val greaterList = vToIdxMap.tailMap(v,false).keys.toList()
            for(greater in greaterList){vToIdxMap.remove(greater)}
            vToIdxMap.put(v,i)
        }
        
        val rightAry = IntArray(nums.size)
        vToIdxMap.clear()
        for(i in nums.indices.reversed()){
            val v = nums[i]
            val rightMeQ = vToIdxMap.lowerEntry(v)
            rightAry[i] = if(rightMeQ==null){nums.size}else{rightMeQ.value}
            val greaterList = vToIdxMap.tailMap(v,false).keys.toList()
            for(greater in greaterList){vToIdxMap.remove(greater)}
            vToIdxMap.put(v,i)
        }
        
        var bestMp = 0L
        for(i in nums.indices){
            val v = nums[i]
            val left = leftAry[i]
            val right = rightAry[i]
            val mp = v * (sumAry[right]-sumAry[left])
            if(mp>bestMp){
                bestMp=mp
            }
        }
        
        return (bestMp%(1000000000+7)).toInt()
    }
}
