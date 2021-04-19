fun main() {
  // given
  test(4,2,6,2)
  test(6,1,10,3)

  // my case
  test(7,2,15,3)
  test(7,2,16,4)
  test(7,2,17,4)

  test(7,2,21,4)
  test(7,2,22,5)
  test(7,2,23,5)

  test(7,2,28,5)
  test(7,2,29,6)
  test(7,2,30,6)

  // WA
  test(4,0,4,1)
  test(92394,70880,952706856,31693)
}

fun test(n: Int, index: Int, maxSum: Int, expected: Int) {
  println("n=%d, index=%d, maxSum=%d, expected=%d".format(n, index, maxSum, expected))
  var solution: Solution = Solution()
  var result: Int = solution.maxValue(n, index, maxSum)
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
