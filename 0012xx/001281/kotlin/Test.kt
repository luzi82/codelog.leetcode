fun main() {
  // given
  test(234,15)
  test(4421,21)
}

fun test(n: Int, expected: Int) {
  println("n=%d, expected=%d".format(n, expected))
  var solution: Solution = Solution()
  var result: Int = solution.subtractProductAndSum(n)
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
