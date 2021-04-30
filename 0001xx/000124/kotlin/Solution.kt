import java.util.*

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        val unitStack:LinkedList<Unit> = LinkedList<Unit>()
        val rootUnit:Unit=Unit(null,root!!,false)
        unitStack.add(rootUnit)
        while(unitStack.size>0){
            val lastUnit:Unit=unitStack.getLast()
            if((!lastUnit.leftDone)&&(lastUnit.node.left!=null)){
                unitStack.add(Unit(lastUnit,lastUnit.node.left!!,true))
                continue
            }
            if((!lastUnit.rightDone)&&(lastUnit.node.right!=null)){
                unitStack.add(Unit(lastUnit,lastUnit.node.right!!,false))
                continue
            }

            var myPlus:Int = lastUnit.node.`val`
            if(lastUnit.node.left!=null){
                myPlus = kotlin.math.max(myPlus,lastUnit.node.`val`+lastUnit.leftPlus)
            }
            if(lastUnit.node.right!=null){
                myPlus = kotlin.math.max(myPlus,lastUnit.node.`val`+lastUnit.rightPlus)
            }

            var myMax:Int = lastUnit.node.`val`
            if(lastUnit.node.left!=null){
                myMax = kotlin.math.max(myMax,lastUnit.node.`val`+lastUnit.leftPlus)
                myMax = kotlin.math.max(myMax,lastUnit.leftMax)
            }
            if(lastUnit.node.right!=null){
                myMax = kotlin.math.max(myMax,lastUnit.node.`val`+lastUnit.rightPlus)
                myMax = kotlin.math.max(myMax,lastUnit.rightMax)
            }
            if((lastUnit.node.left!=null)&&(lastUnit.node.right!=null)){
                myMax = kotlin.math.max(myMax,lastUnit.node.`val`+lastUnit.leftPlus+lastUnit.rightPlus)
            }
            lastUnit.myPlus = myPlus
            lastUnit.myMax = myMax
            if(lastUnit.parent!=null){
                val last1Unit:Unit=lastUnit.parent
                if(lastUnit.isLeft){
                    last1Unit.leftDone=true
                    last1Unit.leftPlus=myPlus
                    last1Unit.leftMax=myMax
                }else{
                    last1Unit.rightDone=true
                    last1Unit.rightPlus=myPlus
                    last1Unit.rightMax=myMax
                }
            }
            unitStack.removeLast()
        }
        return rootUnit.myMax
    }
}

class Unit(val parent:Unit?,val node:TreeNode,val isLeft:Boolean) {
    var myPlus: Int=0
    var myMax: Int=0
    var leftDone:Boolean = false
    var leftPlus:Int = 0
    var leftMax:Int = 0
    var rightDone:Boolean = false
    var rightPlus:Int = 0
    var rightMax:Int = 0
}
