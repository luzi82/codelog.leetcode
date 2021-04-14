fun main() {
  test("110",intArrayOf(1,1,3))
  test("001011",intArrayOf(11,8,5,4,3,4))
}

fun test(boxes: String, expected: IntArray) {
  println("boxes=%s, expected=%s".format(boxes, join(expected)))
  var solution: Solution = Solution()
  var result: IntArray = solution.minOperations(boxes)
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
