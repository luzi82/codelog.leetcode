import java.util.*

fun main() {
  test("[[0,1,-1],[1,0,-1],[1,1,1]]",5)
  test("[[1,1,-1],[1,-1,1],[-1,1,1]]",0)
  // judge
  test("[[1,1,1,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,0,0,1],[1,0,0,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,1,1,1]]",15)
}

fun test(gridd: String, expected: Int) {
  println("grid=%s, expected=%s".format(gridd, expected))
  val grid0:Array<Array<Int?>?>? = toIntQAryQAryQ(gridd.replace(" ","").toCharArray(),0).second
  val grid:Array<IntArray> = Array<IntArray>(grid0!!.size){i->
    IntArray(grid0!![i]!!.size){j->
      grid0!![i]!![j]!!
    }
  }
  var solution: Solution = Solution()
  var result: Int = solution.cherryPickup(grid)
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
