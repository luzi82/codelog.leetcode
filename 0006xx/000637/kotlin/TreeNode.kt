import java.util.LinkedList

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}

fun toTreeNode(s: String):TreeNode?{
  return toTreeNode(toIntQAryQ(s.toCharArray(),0).second!!)
}

fun toTreeNode(vAry: Array<Int?>):TreeNode?{
  if(vAry.size==0)return null

  var ret = TreeNode(vAry[0]!!)

  var bfsQueue: LinkedList<TreeNode> = LinkedList<TreeNode>()
  bfsQueue.addLast(ret)
  
  var readIdx: Int = 1
  while(true){
      if(readIdx >= vAry.size)break
      var node: TreeNode = bfsQueue.pollFirst()
      if(vAry[readIdx]!=null){
          node.left = TreeNode(vAry[readIdx]!!)
          bfsQueue.addLast(node.left)
      }
      ++readIdx
      if(readIdx >= vAry.size)break
      if(vAry[readIdx]!=null){
          node.right = TreeNode(vAry[readIdx]!!)
          bfsQueue.addLast(node.right)
      }
      ++readIdx
  }
  
  return ret
}
