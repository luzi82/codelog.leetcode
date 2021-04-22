// Try to solve using divide and conquer, TLE
class Solution {
  fun countDifferentSubsequenceGCDs(nums: IntArray): Int {
    val numArray:IntArray = nums.distinct().toIntArray()
    val gcdSet:Set<Int> = getGcdSet(numArray,0,numArray.size)
    return gcdSet.size
  }

  fun getGcdSet(numArray:IntArray, start:Int, end:Int):HashSet<Int>{
    if(end==start+1){
      return HashSet(intArrayOf(numArray[start]).toSet())
    }
    val mid:Int = (start+end)/2
    val leftGcdSet:HashSet<Int> = getGcdSet(numArray, start, mid)
    val rightGcdSet:HashSet<Int> = getGcdSet(numArray, mid, end)

    val retGcdSet:HashSet<Int> = HashSet<Int>(leftGcdSet.union(rightGcdSet))

    val commonGcdSet:Set<Int> = leftGcdSet.intersect(rightGcdSet)
    leftGcdSet.removeAll(commonGcdSet)
    rightGcdSet.removeAll(commonGcdSet)

    for(left in leftGcdSet){
      for(right in rightGcdSet){
        val gcd = getGcd(left,right)
        retGcdSet.add(gcd)
      }
    }

    return retGcdSet
  }

  fun getGcd(a:Int, b:Int):Int{
    var aa:Int = Math.min(a,b)
    var bb:Int = Math.max(a,b)
    while(aa!=0){
      var cc = bb%aa
      bb = aa
      aa = cc
    }
    return bb
  }
}
