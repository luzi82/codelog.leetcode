class Solution {
    fun maximumPopulation(logs: Array<IntArray>): Int {
        val YR=1950
        val deltaAry = IntArray(101)
        for(bd in logs){
            deltaAry[bd[0]-YR]++
            deltaAry[bd[1]-YR]--
        }
        
        var cnt=0
        var bestCnt = Integer.MIN_VALUE
        var bestYr = -1
        for(yr in deltaAry.indices){
            val delta = deltaAry[yr]
            cnt += delta
            if(cnt>bestCnt){
                bestCnt=cnt
                bestYr = yr
            }
        }
        
        return bestYr+YR
    }
}
