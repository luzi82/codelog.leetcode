class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        var vAry: IntArray = nums.sortedArray()
        var valueToIdxMap: HashMap<Int,Int> = HashMap<Int,Int>()
        for(i in vAry.indices){
          var v: Int = vAry[i]
          if(valueToIdxMap.contains(v))continue
          valueToIdxMap.put(v,i)
        }

        var retAry: IntArray = IntArray(nums.size)
        for(i in nums.indices){
          retAry[i] = valueToIdxMap.getValue(nums[i])
        }

        return retAry
    }
}
