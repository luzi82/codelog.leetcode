class Solution {
    fun hIndex(citations: IntArray): Int {
        val cToPCountAry:IntArray = IntArray(1001){0}
        for(c in citations){
            cToPCountAry[c]+=1
        }
        
        for(i in cToPCountAry.indices.reversed()){
            if(i==cToPCountAry.size-1){continue}
            cToPCountAry[i] += cToPCountAry[i+1]
        }
        
        for(i in cToPCountAry.indices.reversed()){
            if(cToPCountAry[i]>=i)return i
        }
        return 0
    }
}
