fun main() {
  test(arrayOf<IntArray>(intArrayOf(1,3,11),intArrayOf(2,4,6)),5,7)
  test(arrayOf<IntArray>(intArrayOf(1,3,11),intArrayOf(2,4,6)),9,17)
  test(arrayOf<IntArray>(intArrayOf(1,10,10),intArrayOf(1,4,5),intArrayOf(2,3,6)),7,9)
  test(arrayOf<IntArray>(intArrayOf(1,1,10),intArrayOf(2,2,9)),7,12)
}

fun test(mat: Array<IntArray>, k: Int, expected: Int) {
  println("mat=%s, k=%d, expected=%d".format(join(mat), k, expected))
  var solution: Solution = Solution()
  var result: Int = solution.kthSmallest(mat, k)
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

fun join(ary: Array<Int?>): String {
  var sb: StringBuffer = StringBuffer()
  sb.append("[")
  var isFirst: Boolean=true
  for(v in ary){
    if(!isFirst){sb.append(",")}
    isFirst=false
    if(v==null){
      sb.append("null")
    }else{
      sb.append(Integer.toString(v))
    }
  }
  sb.append("]")
  return sb.toString()
}

fun join(ary: List<Int>): String {
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
