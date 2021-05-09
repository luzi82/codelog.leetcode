class Solution {
    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val noDestNodeSet = HashSet<Int>()
        for(node in colors.indices){
            noDestNodeSet.add(node)
        }
        
        val srcToDestSetAry = Array(colors.length){HashSet<Int>()}
        for(sd in edges){
            noDestNodeSet.remove(sd[1])
            srcToDestSetAry[sd[0]].add(sd[1])
        }

        if(noDestNodeSet.size==0){return -1}
        
        val colorNameToColorIdxAry = Array(26){-1}
        var colorCnt = 0
        for(color in colors){
            val cI = color-'a'
            if(colorNameToColorIdxAry[cI]!=-1){continue}
            colorNameToColorIdxAry[cI] = colorCnt
            colorCnt++
        }
        val nodeToColorAry = IntArray(colors.length){colorNameToColorIdxAry[colors[it]-'a']}

        val noPassNodeSet = HashSet<Int>()
        for(node in colors.indices){
            noPassNodeSet.add(node)
        }

        var ret = 0
        val nodeToMaxColorCntAryQAry = Array<IntArray?>(colors.length){null}
        val nodeToPassedAry = BooleanArray(colors.length){false}
        for(node in noDestNodeSet){
            val dfsResult = dfs(node, nodeToColorAry, srcToDestSetAry, nodeToMaxColorCntAryQAry, nodeToPassedAry, colorCnt, noPassNodeSet)
            if(dfsResult.loopExist){return -1}
            ret = kotlin.math.max(ret, maxQ(dfsResult.maxColorCntAry)!!)
        }
        
        if(noPassNodeSet.size>0){return -1}
        
        return ret
    }

    fun dfs(node:Int, nodeToColorAry:IntArray, srcToDestSetAry:Array<HashSet<Int>>, nodeToMaxColorCntAryQAry:Array<IntArray?>, nodeToPassedAry:BooleanArray, colorCnt:Int, noPassNodeSet:HashSet<Int>):DfsResult{
        if(nodeToMaxColorCntAryQAry[node]!=null){
            return DfsResult(false, nodeToMaxColorCntAryQAry[node]!!)
        }
        val ret = _dfs(node, nodeToColorAry, srcToDestSetAry, nodeToMaxColorCntAryQAry, nodeToPassedAry, colorCnt, noPassNodeSet)
        if(ret.loopExist){return ret}
        nodeToMaxColorCntAryQAry[node] = ret.maxColorCntAry
        return ret
    }

    fun _dfs(node:Int, nodeToColorAry:IntArray, srcToDestSetAry:Array<HashSet<Int>>, nodeToMaxColorCntAryQAry:Array<IntArray?>, nodeToPassedAry:BooleanArray, colorCnt:Int, noPassNodeSet:HashSet<Int>):DfsResult{
        noPassNodeSet.remove(node)

        if(nodeToPassedAry[node]){
            return DfsResult(true,IntArray(nodeToColorAry.size))
        }
        
        val color = nodeToColorAry[node]
        
        val destSet = srcToDestSetAry[node]
        if(destSet.size<=0){
            return DfsResult(false,IntArray(colorCnt){if(it==color){1}else{0}})
        }
        
        nodeToPassedAry[node] = true
        
        val maxColorCntAry=IntArray(colorCnt)
        
        for(dest in destSet){
            val ret = dfs(dest, nodeToColorAry, srcToDestSetAry, nodeToMaxColorCntAryQAry, nodeToPassedAry, colorCnt, noPassNodeSet)
            if(ret.loopExist){return ret}
            fillMax(maxColorCntAry, ret.maxColorCntAry)
        }
        maxColorCntAry[color]++
        
        nodeToPassedAry[node] = false
        
        return DfsResult(false, maxColorCntAry)
    }
    
    data class DfsResult(val loopExist:Boolean, val maxColorCntAry:IntArray)
    
    fun fillMax(toAry:IntArray, fromAry:IntArray){
        for(i in toAry.indices){
            toAry[i] = kotlin.math.max(toAry[i],fromAry[i])
        }
    }

    fun maxQ(intAry:IntArray):Int?{
      // return intAry.max() // use this line in leetcode
      return intAry.maxOrNull()
    }
    
}
