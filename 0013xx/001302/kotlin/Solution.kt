import java.util.LinkedList
import java.util.*

class Solution {
  fun deepestLeavesSum(root: TreeNode?): Int {
    val nodeQueue: LinkedList<TreeNode> = LinkedList<TreeNode>()
    val depthQueue: LinkedList<Int> = LinkedList<Int>()

    nodeQueue.addLast(root)
    depthQueue.addLast(0)

    var ret: Int = 0
    var maxDepth: Int = 0
    while(true){
      if(nodeQueue.size==0)break
      val node: TreeNode = nodeQueue.pollFirst()
      val depth: Int = depthQueue.pollFirst()
      if(node.left!=null){
        nodeQueue.addLast(node.left)
        depthQueue.addLast(depth+1)
      }
      if(node.right!=null){
        nodeQueue.addLast(node.right)
        depthQueue.addLast(depth+1)
      }
      if((node.left==null)&&(node.right==null)){
        if(depth>maxDepth){
          maxDepth=depth
          ret=0
        }
        if(depth==maxDepth){
          ret+=node.`val`
        }
      }
    }

    return ret
  }
}
