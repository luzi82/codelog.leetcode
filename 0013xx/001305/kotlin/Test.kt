fun main() {
  test(arrayOf<Int?>(2,1,4),arrayOf<Int?>(1,0,3),intArrayOf(0,1,1,2,3,4))
  test(arrayOf<Int?>(0,-10,10),arrayOf<Int?>(5,1,7,0,2),intArrayOf(-10,0,0,1,2,5,7,10))
  test(arrayOf<Int?>(),arrayOf<Int?>(5,1,7,0,2),intArrayOf(0,1,2,5,7))
  test(arrayOf<Int?>(0,-10,10),arrayOf<Int?>(),intArrayOf(-10,0,10))
}

fun test(root1x:Array<Int?>, root2x:Array<Int?>, expectedx:IntArray) {
  println("root1=%s, root2=%s, expected=%s".format(join(root1x), join(root2x), join(expectedx)))
  val root1:TreeNode? = toTreeNode(root1x)
  val root2:TreeNode? = toTreeNode(root2x)
  var solution: Solution = Solution()
  var result: List<Int> = solution.getAllElements(root1, root2)
  println("result=%s".format(join(result)))
  aassert(join(result) == join(expectedx))
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
