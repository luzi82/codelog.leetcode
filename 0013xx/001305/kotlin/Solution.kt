import java.util.*

class Solution {
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val ant1:LinkedList<TreeNode> = left(root1)
        val ant2:LinkedList<TreeNode> = left(root2)
        
        val retList:LinkedList<Int> = LinkedList<Int>()
        while(true){
            if(ant1.size+ant2.size<=0)return retList
            if(ant1.size<=0){
                retList.addLast(next(ant2))
                continue
            }
            if(ant2.size<=0){
                retList.addLast(next(ant1))
                continue
            }
            val v1:Int = peek(ant1)
            val v2:Int = peek(ant2)
            if(v1<v2){
                retList.addLast(v1)
                next(ant1)
                continue
            }else{
                retList.addLast(v2)
                next(ant2)
                continue
            }
        }
    }
    
    fun left(root: TreeNode?): LinkedList<TreeNode> {
        var r:TreeNode? = root
        val ret:LinkedList<TreeNode> = LinkedList<TreeNode>()
        if(r==null)return ret
        ret.addLast(r!!)
        while(true){
            if(r!!.left==null)return ret
            r=r!!.left
            ret.addLast(r!!)
        }
    }

    fun peek(ant:LinkedList<TreeNode>):Int{
        return ant.getLast().`val`
    }

    fun next(ant:LinkedList<TreeNode>):Int{
        val ret:Int = ant.getLast().`val`
        if(ant.getLast().right==null){
            ant.removeLast()
            return ret
        }
        val right0 = ant.getLast().right
        ant.removeLast()
        ant.addLast(right0)
        while(ant.getLast().left!=null){
            ant.addLast(ant.getLast().left)
        }
        return ret
    }
}
