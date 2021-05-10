import java.util.*

class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val srcToDestAryAry = graph
        val nodeCnt = graph.size
        val nodeToColorAry = IntArray(nodeCnt){0}
        
        val notDoneNodeSet = HashSet<Int>()
        for(node in 0..(nodeCnt-1)){
            notDoneNodeSet.add(node)
        }
        
        val nodeQueue = LinkedList<Int>()
        while(notDoneNodeSet.size>0){
            val notDoneNode = notDoneNodeSet.elementAt(0)
            notDoneNodeSet.remove(notDoneNode)
            nodeQueue.add(notDoneNode)
            nodeToColorAry[notDoneNode]=1
            while(nodeQueue.size>0){
                val node = nodeQueue.removeFirst()
                val color = nodeToColorAry[node]
                val destColor = -color
                for(dest in srcToDestAryAry[node]){
                    if(nodeToColorAry[dest]==color){return false}
                    if(nodeToColorAry[dest]==destColor){continue}
                    notDoneNodeSet.remove(dest)
                    nodeQueue.add(dest)
                    nodeToColorAry[dest]=destColor
                }
            }
        }
        
        return true
    }
}
