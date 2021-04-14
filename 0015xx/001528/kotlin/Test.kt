fun main() {
  test("codeleet",intArrayOf(4,5,6,7,0,2,1,3),"leetcode")
  test("abc",intArrayOf(0,1,2),"abc")
  test("aiohn",intArrayOf(3,1,4,2,0),"nihao")
  test("aaiougrt",intArrayOf(4,0,2,6,7,3,1,5),"arigatou")
  test("art",intArrayOf(1,0,2),"rat")
}

fun test(s: String, indices: IntArray, expected: String) {
  println("s=%s, indices=%s expected=%s".format(s, join(indices), expected))
  var solution: Solution = Solution()
  var result: String = solution.restoreString(s, indices)
  println("result=%s".format(result))
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
