class Solution {
  fun numIdenticalPairs(nums: IntArray): Int {
    var numToCountMap: HashMap<Int, Int> = HashMap<Int, Int>()
    for(num in nums){
      var count: Int = numToCountMap.getOrDefault(num,0)
      count = count + 1
      numToCountMap.put(num,count)
    }

    var ret: Int = 0
    for(count in numToCountMap.values){
      ret += (count * (count-1))/2
    }

    return ret
  }
}
