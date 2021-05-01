class ListNode(var `val`: Int) {
  var next: ListNode? = null
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
