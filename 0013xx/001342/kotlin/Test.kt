fun main() {
  test(14,6)
  test(8,4)
  test(123,12)
}

fun test(num: Int, expected: Int) {
  println("num=%d, expected=%d".format(num, expected))
  var solution: Solution = Solution()
  var result: Int = solution.numberOfSteps(num)
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
