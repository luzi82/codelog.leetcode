fun main() {
  test("32",3)
  test("82734",8)
  test("27346209830709182346",9)
}

fun test(n: String, expected: Int) {
  println("n=%s, expected=%d".format(n, expected))
  var solution: Solution = Solution()
  var result: Int = solution.minPartitions(n)
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
