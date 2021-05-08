class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet=wordDict.toSet()
        
        val idxToGoodAry=BooleanArray(s.length+1)
        idxToGoodAry[0]=true
        
        for(idx in idxToGoodAry.indices){
            if(!idxToGoodAry[idx]){continue}
            if(idx>=s.length){continue}
            for(idx1 in (idx+1)..(s.length)){
                val subStr = s.substring(idx,idx1)
                if(!wordSet.contains(subStr)){continue}
                idxToGoodAry[idx1]=true
            }
        }
        
        return idxToGoodAry[s.length]
    }
}
