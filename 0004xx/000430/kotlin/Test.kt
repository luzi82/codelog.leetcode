import java.util.*

fun main() {
  test("[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]","[1,2,3,7,8,11,12,9,10,4,5,6]")
  test("[1,2,null,3]","[1,3,2]")
  test("[]","[]")
}

fun test(roott: String, expected: String) {
  println("root=%s, expected=%s".format(roott, expected))

  val intQAry:Array<Int?> = toIntQAryQ(roott.toCharArray(),0).second!!
  val root = toNode(intQAry,0).second

  var solution: Solution = Solution()
  var result: Node? = solution.flatten(root)

  var ptr = result
  // check prev vs next, no child
  ptr = result
  while(ptr!=null){
    if(ptr.next!=null){
      aassert(ptr.next!!.prev==ptr)
    }
    aassert(ptr.child==null)
    ptr = ptr.next
  }

  val intList=LinkedList<Int>()
  ptr = result
  while(ptr!=null){
    intList.addLast(ptr.`val`)
    ptr = ptr.next
  }

  println("result=%s".format(join(intList)))
  aassert(join(intList) == expected)
}

fun toNode(intQAry:Array<Int?>, start:Int): Pair<Int,Node?> {
  //println("NHYGZXED start=%d".format(start))
  var i=start
  if(i>=intQAry.size){return Pair<Int,Node?>(i,null)}
  if(intQAry[i]==null){return Pair<Int,Node?>(i+1,null)}
  val nodeList:LinkedList<Node> = LinkedList<Node>()
  while(true){
    if(i>=intQAry.size){break}
    if(intQAry[i]==null){i+=1;break}
    nodeList.addLast(Node(intQAry[i]!!))
    i+=1
  }
  val nodeAry:Array<Node> = nodeList.toArray(Array<Node>(0){Node(0)})
  for(j in 0..(nodeAry.size-2)){
    nodeAry[j].next = nodeAry[j+1]
    nodeAry[j+1].prev = nodeAry[j]
  }
  for(j in 0..(nodeAry.size-1)){
    if(i>=intQAry.size){break}
    var retPair = toNode(intQAry,i)
    i = retPair.first
    nodeAry[j].child = retPair.second
  }
  return Pair<Int,Node?>(i,nodeAry[0])
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

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}
