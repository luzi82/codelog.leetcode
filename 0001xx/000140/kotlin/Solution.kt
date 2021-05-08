import java.util.*

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val wordSet=wordDict.toSet()

        val goodIdxAryList = LinkedList<IntArray>()
        
        val idxAryQueue = LinkedList<IntArray>()
        idxAryQueue.addLast(intArrayOf(0))
        while(idxAryQueue.size>0){
            val idxAry=idxAryQueue.removeLast()
            val idx = idxAry[idxAry.size-1]
            if(idx>=s.length){
                goodIdxAryList.addLast(idxAry)
                continue
            }
            for(idx1 in (idx+1)..(s.length)){
                val subStr = s.substring(idx,idx1)
                if(!wordSet.contains(subStr)){continue}
                val idxAry1=IntArray(idxAry.size+1){if(it<idxAry.size){idxAry[it]}else{idx1}}
                idxAryQueue.addLast(idxAry1)
            }
        }
        
        val retStrList=LinkedList<String>()
        for(idxAry in goodIdxAryList){
            val sb=StringBuilder()
            for(i in 0..(idxAry.size-2)){
                val idx0 = idxAry[i]
                val idx1 = idxAry[i+1]
                if(i>0){sb.append(" ")}
                sb.append(s.substring(idx0,idx1))
            }
            retStrList.addLast(sb.toString())
        }
        return retStrList
    }
}
