fun main() {
  // given
  test(5,6)
  test(8,18)
  // my case
  test(1,1)
  test(2,2)
  test(3,3)
  // WA
  test(18, 729)
}

fun test(primeFactors: Int, expected: Int) {
  println("x=%d, expected=%d".format(primeFactors, expected))
  var solution: Solution = Solution()
  var result: Int = solution.maxNiceDivisors(primeFactors)
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
