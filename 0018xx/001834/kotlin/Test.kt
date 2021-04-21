fun main() {
  test(
    arrayOf(intArrayOf(1,2),intArrayOf(2,4),intArrayOf(3,2),intArrayOf(4,1)),
    intArrayOf(0,2,3,1)
  )
  test(
    arrayOf(intArrayOf(7,10),intArrayOf(7,12),intArrayOf(7,5),intArrayOf(7,4),intArrayOf(7,2)),
    intArrayOf(4,3,2,0,1)
  )
}

fun test(tasks: Array<IntArray>, expected: IntArray) {
  println("tasks=%s, expected=%s".format(join(tasks), join(expected)))
  var solution: Solution = Solution()
  var result: IntArray = solution.getOrder(tasks)
  println("result=%s".format(join(result)))
  aassert(join(result) == join(expected))
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
