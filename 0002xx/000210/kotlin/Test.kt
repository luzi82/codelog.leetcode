fun main() {
  test(2,arrayOf<IntArray>(intArrayOf(1,0)),true)
  test(4,arrayOf<IntArray>(intArrayOf(1,0),intArrayOf(2,0),intArrayOf(3,1),intArrayOf(3,2)),true)
  test(1,arrayOf<IntArray>(),true)
  // my case
  test(2,arrayOf<IntArray>(intArrayOf(1,0),intArrayOf(0,1)),false)
}

fun test(numCourses: Int, prerequisites: Array<IntArray>, notEmpty: Boolean) {
  println("numCourses=%d, prerequisites=%s, notEmpty=%s".format(numCourses, join(prerequisites), notEmpty))
  var solution: Solution = Solution()
  var result: IntArray = solution.findOrder(numCourses,prerequisites)
  println("result=%s".format(join(result)))
  if(notEmpty){
    aassert(result.size==numCourses)
    val valueToPosAry:IntArray=IntArray(numCourses){i->-1}
    for(i in result.indices){
      val v=result[i]
      aassert(valueToPosAry[v]==-1)
      valueToPosAry[v]=i
    }
    for(pair in prerequisites){
      val left=pair[0]
      val right=pair[1]
      aassert(valueToPosAry[left]>valueToPosAry[right])
    }
  }else{
    aassert(result.size==0)
  }
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
