fun main() {
  test(intArrayOf(1,2,2,6,6,6,6,7,10),6)
  test(intArrayOf(1,1),1)
}

fun test(arr: IntArray, expected: Int) {
  println("arr=%s, expected=%d".format(join(arr), expected))
  var solution: Solution = Solution()
  var result: Int = solution.findSpecialInteger(arr)
  println("result=%d".format(result))
  aassert(result == expected)
}

fun join(ary: Array<IntArray>): String {
  var sb: StringBuffer = StringBuffer()
  sb.append("[")
  var isFirst: Boolean=true
  for(v in ary){
      if(!isFirst){sb.append(",")}
      isFirst=false
      sb.append(join(v))
  }
  sb.append("]")
  return sb.toString()
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
