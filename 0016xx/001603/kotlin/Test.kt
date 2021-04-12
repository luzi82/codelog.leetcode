fun main() {
  test(
    arrayOf("ParkingSystem", "addCar", "addCar", "addCar", "addCar"),
    arrayOf(intArrayOf(1, 1, 0), intArrayOf(1), intArrayOf(2), intArrayOf(3), intArrayOf(1)),
    arrayOf(null, true, true, false, false)
  )
}

fun test(funcNameAry:Array<String>, argAryAry:Array<IntArray>, expectedAry:Array<Boolean?>) {
  var ps: ParkingSystem? = null
  for(i in funcNameAry.indices){
    var funcName: String = funcNameAry[i]
    var argAry: IntArray = argAryAry[i]
    var expected: Boolean? = expectedAry[i]
    println("funcName=%s, argAry=%s, expected=%s".format(funcName,join(argAry),expected))
    var result: Boolean? = null
    if(false){
    }else if(funcName=="ParkingSystem"){
      ps = ParkingSystem(argAry[0],argAry[1],argAry[2])
    }else if(funcName=="addCar"){
      result = ps!!.addCar(argAry[0])
    }else{
      aassert(false)
    }
    println("result=%s".format(result))
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
