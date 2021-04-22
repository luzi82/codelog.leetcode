// using 4 hints, still TLE
class Solution {
  fun countDifferentSubsequenceGCDs(nums: IntArray): Int {
    val numArray:IntArray = nums.distinct().toIntArray()
    val gcdSet:MutableSet<Int> = numArray.toMutableSet()

    val baseGcd:Int = getGcd(numArray)
    //val max = numArray.maxOrNull()!!
    val max:Int = numArray.max()!! // leetcode unable to use maxOrNull

    for(i in baseGcd..max step baseGcd){
      if(gcdSet.contains(i))continue
      val vgcd = verifyGcd(i,numArray)
      if(vgcd!=-1)gcdSet.add(vgcd)
    }

    //print(join(gcdSet.toIntArray()))

    return gcdSet.size
  }

  fun verifyGcd(gcd:Int, numArray:IntArray):Int{
    var v = -1
    for(num in numArray){
      if(num%gcd!=0)continue
      if(v==-1){
        v=num
      }else{
        v=getGcd(v,num)
      }
      if(v==gcd)return gcd
    }
    return v
  }

  fun getGcd(numArray:IntArray):Int{
    var v = numArray[0]
    for(num in numArray){
      v = getGcd(v,num)
      if(v==1)break
    }
    return v
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
