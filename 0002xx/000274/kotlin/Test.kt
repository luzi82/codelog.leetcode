import java.util.*

fun main() {
  test(intArrayOf(3,0,6,1,5),3)
  test(intArrayOf(1,3,1),1)
}

fun test(citations: IntArray, expected: Int) {
  println("citations=%s, expected=%d".format(join(citations), expected))
  var solution: Solution = Solution()
  var result: Int = solution.hIndex(citations)
  println("result=%d".format(result))
  aassert(result == expected)
}

fun toIntArray(intAry:Array<Int?>):IntArray{
  val ret:IntArray = IntArray(intAry.size)
  for(i in intAry.indices){
    ret[i] = intAry[i]!!
  }
  return ret
}

fun toAry(str:String): Array<Int?>{
  val intList:LinkedList<Int?> = LinkedList<Int?>()
  val cAry = str.toCharArray()
  var i=1
  while(true){
    if(cAry[i]==']'){
      break
    }
    if(cAry[i]=='n'){ // null
      intList.add(null)
      i+=4
      if(cAry[i]==','){
        i+=1
        continue
      }
      if(cAry[i]==']'){
        break
      }
      aassert(false)
    }
    var v=0
    while(true){
      if(cAry[i]==','){
        intList.add(v)
        i+=1
        break
      }
      if(cAry[i]==']'){
        intList.add(v)
        break
      }
      v*=10
      v+=(cAry[i]-'0')
      i+=1
    }
  }
  return intList.toArray(arrayOf<Int?>())
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
