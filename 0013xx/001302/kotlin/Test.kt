fun main() {
  test(arrayOf<Int?>(1,2,3,4,5,null,6,7,null,null,null,null,8),15)
  test(arrayOf<Int?>(6,7,8,2,7,1,3,9,null,1,4,null,null,null,5),19)
}

fun test(vAry: Array<Int?>, expected: Int) {
  println("vAry=%s, expected=%d".format(join(vAry), expected))
  var treenode: TreeNode = toTreeNode(vAry)!!
  var solution: Solution = Solution()
  var result: Int = solution.deepestLeavesSum(treenode)
  println("result=%d".format(result))
  aassert(result == expected)
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
