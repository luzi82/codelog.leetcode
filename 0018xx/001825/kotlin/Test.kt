fun main() {
  test(
    arrayOf("MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", "calculateMKAverage", "addElement", "addElement", "addElement", "calculateMKAverage"),
    arrayOf(intArrayOf(3,1),intArrayOf(3),intArrayOf(1),intArrayOf(),intArrayOf(10),intArrayOf(),intArrayOf(5),intArrayOf(5),intArrayOf(5),intArrayOf()),
    arrayOf(null, null, null, -1, null, 3, null, null, null, 5)
  )
}

fun test(funcNameAry:Array<String>, argAryAry:Array<IntArray>, expectedAry:Array<Int?>) {
  var ps: MKAverage? = null
  for(i in funcNameAry.indices){
    var funcName: String = funcNameAry[i]
    var argAry: IntArray = argAryAry[i]
    var expected: Int? = expectedAry[i]
    println("funcName=%s, argAry=%s, expected=%s".format(funcName,join(argAry),expected))
    var result: Int? = null
    if(false){
    }else if(funcName=="MKAverage"){
      ps = MKAverage(argAry[0],argAry[1])
    }else if(funcName=="addElement"){
      ps!!.addElement(argAry[0])
    }else if(funcName=="calculateMKAverage"){
      result = ps!!.calculateMKAverage()
    }else{
      aassert(false)
    }
    ps!!.trace()
    println("result=%d".format(result))
    aassert(result == expected)
  }
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
