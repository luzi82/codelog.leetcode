import kotlin.math.sqrt

class Solution {

  fun maxValue(n: Int, index: Int, maxSum: Int): Int {
    return maxValue0(n, index, maxSum-n)+1
  }

  // WA-ed, not noticed num[i]!=0
  fun maxValue0(n: Int, index: Int, maxSum: Int): Int {
    val aa:Long = (index+1).toLong()
    val bb:Long = (n-index).toLong()
    val a:Long = Math.min(aa,bb)
    val b:Long = Math.max(aa,bb)
    val s:Long = maxSum.toLong()

    val s0:Long = a*a
    val s1:Long = b*(b+1)/2 + a*(a+1)/2 + a*(b-a) - b
    println("s0=%d, s1=%d".format(s0,s1))

    if(s<=s0){
      return sqrt(s.toDouble()).toInt()
    }else if(s<=s1){
      //println("b-4ac=%d".format(8*a*a-8*a+8*s.toLong()+1))
      //println("b-4ac=%f".format(sqrt((8*a*a-8*a+8*s+1).toDouble())))
      //println("2a=%d".format(2*a))
      return ((1-2*a+sqrt((8*a*a-8*a+8*s+1).toDouble()))/2).toInt()
    }else{
      return (b+((s-s1)/n)).toInt()
    }
  }
}
