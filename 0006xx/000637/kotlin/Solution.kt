import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val levelToSumVec = Vector<Long>()
        val levelToCountVec = Vector<Int>()
        
        dfs(levelToSumVec,levelToCountVec,root,0)
        
        val retAry=DoubleArray(levelToSumVec.size){(levelToSumVec[it]).toDouble()/(levelToCountVec[it]).toDouble()}
        return retAry
    }
    
    fun dfs(levelToSumVec:Vector<Long>,levelToCountVec:Vector<Int>,root:TreeNode?,level:Int){
        if(root==null)return
        val v=root.`val`
        if(levelToSumVec.size<=level){
            levelToSumVec.add(v.toLong())
            levelToCountVec.add(1)
        }else{
            levelToSumVec.set(level,v+levelToSumVec.get(level))
            levelToCountVec.set(level,1+levelToCountVec.get(level))
        }
        dfs(levelToSumVec,levelToCountVec,root.left,level+1)
        dfs(levelToSumVec,levelToCountVec,root.right,level+1)
    }
}
