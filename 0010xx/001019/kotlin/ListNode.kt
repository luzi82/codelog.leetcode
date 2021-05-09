class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

fun toStr(head: ListNode?): String{
  val sb=StringBuilder()
  sb.append("[")
  var isFirst = false
  var ptr = head
  while(ptr!=null){
    if(!isFirst){sb.append(",")}
    sb.append(ptr.`val`.toString())
    ptr = ptr.next
  }
  sb.append("]")
  return sb.toString()  
}

fun toListNode(str: String): ListNode?{
  val vIntQAry = toIntQAryQ(str.toCharArray(),0).second!!
  return toListNode(vIntQAry)
}

fun toListNode(intAry: IntArray):ListNode?{
  if(intAry.size==0){return null}
  var ret:ListNode? = null
  for(i in intAry.indices.reversed()){
    //println("i=%d".format(i))
    var prev = ListNode(intAry[i])
    prev.next = ret
    ret = prev
  }
  return ret
}

fun toListNode(intAry: Array<Int?>):ListNode?{
  if(intAry.size==0){return null}
  var ret:ListNode? = null
  for(i in intAry.indices.reversed()){
    //println("i=%d".format(i))
    var prev = ListNode(intAry[i]!!)
    prev.next = ret
    ret = prev
  }
  return ret
}
