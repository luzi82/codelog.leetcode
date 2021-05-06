import java.util.*

class Node(var `val`: Int) {
  var left: Node? = null
  var right: Node? = null
  var next: Node? = null
}

fun toNode(s: String):Node?{
  val vAry: Array<Int?> = toIntQAryQ(s.toCharArray(),0).second!!
  return toNode(vAry)
}

fun toNode(vAry: Array<Int?>):Node?{
  if(vAry.size==0)return null

  var ret = Node(vAry[0]!!)

  var bfsQueue: LinkedList<Node> = LinkedList<Node>()
  bfsQueue.addLast(ret)
  
  var readIdx: Int = 1
  while(true){
      if(readIdx >= vAry.size)break
      var node: Node = bfsQueue.pollFirst()
      if(vAry[readIdx]!=null){
          node.left = Node(vAry[readIdx]!!)
          bfsQueue.addLast(node.left)
      }
      ++readIdx
      if(readIdx >= vAry.size)break
      if(vAry[readIdx]!=null){
          node.right = Node(vAry[readIdx]!!)
          bfsQueue.addLast(node.right)
      }
      ++readIdx
  }
  
  return ret
}
