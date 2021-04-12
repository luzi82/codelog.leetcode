fun main() {
  test(intArrayOf(1,2,3,1,1,3),4)
  test(intArrayOf(1,1,1,1),6)
  test(intArrayOf(1,2,3),0)
}

fun test(nums: IntArray, expected: Int) {
  println("nums=%s, expected=%s".format(join(nums), expected))
  var solution: Solution = Solution()
  var result: Int = solution.numIdenticalPairs(nums)
  println("result=%d".format(result))
  aassert(result == expected)
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
