fun main() {
  test(intArrayOf(8,1,2,2,3),intArrayOf(4,0,1,1,3))
  test(intArrayOf(6,5,4,8),intArrayOf(2,1,0,3))
  test(intArrayOf(7,7,7,7),intArrayOf(0,0,0,0))
}

fun test(nums: IntArray, expected: IntArray) {
  println("nums=%s, expected=%s".format(join(nums), join(expected)))
  var solution: Solution = Solution()
  var result: IntArray = solution.smallerNumbersThanCurrent(nums)
  println("result=%s".format(join(result)))
  aassert(join(result) == join(expected))
}

fun join(ary: IntArray): String {
  var sb: StringBuffer = StringBuffer()
  sb.append("[")
  var isFirst: Boolean=true
  for(v in ary){
      if(!isFirst){sb.append(",")}
      isFirst=false
      sb.append(Integer.toString(v))
  }
  sb.append("]")
  return sb.toString()
}

fun aassert(cond: Boolean){
    if(!cond)throw AssertionError()
}
