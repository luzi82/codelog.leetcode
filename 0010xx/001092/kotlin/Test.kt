import java.util.*

fun main() {
  test("abac","cab",5)
}

fun test(str1: String, str2: String, expected: Int) {
  println("str1=%s, str2=%s, expected=%d".format(str1, str2, expected))
  var solution: Solution = Solution()
  var result: String = solution.shortestCommonSupersequence(str1, str2)
  println("result=%s".format(result))
  aassert(result.length == expected)
  aassert(isSub(str1,result))
  aassert(isSub(str2,result))
}

fun isSub(a:String, b:String):Boolean{
  var done=0
  val aCAry = a.toCharArray()
  for(bc in b.toCharArray()){
    if(done>=a.length)return true
    if(bc==aCAry[done]){
      done+=1
    }
  }
  return done>=a.length
}

fun toIntQAryQAryQ(cAry:CharArray,start:Int): Pair<Int,Array<Array<Int?>?>?>{
  val intQAryQList:LinkedList<Array<Int?>?> = LinkedList<Array<Int?>?>()
  var i=start
  if(cAry[i]=='n'){ // null
    return Pair<Int,Array<Array<Int?>?>?>(i+4,null)
  }
  aassert(cAry[i]=='[')
  i+=1
  if(cAry[i]==']'){i+=1} // empty ary
  else{
    while(true){
      var ret:Pair<Int,Array<Int?>?> = toIntQAryQ(cAry,i)
      i = ret.first
      intQAryQList.add(ret.second)
      if(cAry[i]==']'){i+=1;break}
      aassert(cAry[i]==',')
      i+=1
    }
  }
  return Pair<Int,Array<Array<Int?>?>?>(i,intQAryQList.toArray(Array<Array<Int?>?>(0){null}))
}

fun toIntQAryQ(cAry:CharArray,start:Int): Pair<Int,Array<Int?>?>{
  val intQList:LinkedList<Int?> = LinkedList<Int?>()
  var i=start
  if(cAry[i]=='n'){ // null
    return Pair<Int,Array<Int?>?>(i+4,null)
  }
  aassert(cAry[i]=='[')
  i+=1
  if(cAry[i]==']'){i+=1} // empty ary
  else{
    while(true){
      var ret:Pair<Int,Int?> = toIntQ(cAry,i)
      i = ret.first
      intQList.add(ret.second)
      if(cAry[i]==']'){i+=1;break}
      aassert(cAry[i]==',')
      i+=1
    }
  }
  return Pair<Int,Array<Int?>?>(i,intQList.toArray(Array<Int?>(0){null}))
}

fun toIntQ(cAry:CharArray,start:Int): Pair<Int,Int?>{
  var i=start
  if(cAry[i]=='n'){ // null
    return Pair<Int,Int?>(i+4,null)
  }
  var v=0
  var m=1
  if(cAry[i]=='-'){
    m=-1
    i+=1
  }
  while(true){
    if((i>=cAry.size)||(cAry[i]<'0')||(cAry[i]>'9')){break}
    v*=10
    v+=(cAry[i]-'0')
    i+=1
  }
  return Pair<Int,Int?>(i,v*m)
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
