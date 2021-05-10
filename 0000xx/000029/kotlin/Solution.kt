class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        // check zero
        if(dividend==0){return 0}
        
        // get neg
        val isNeg = (dividend<0)!=(divisor<0)
        
        // abs long
        var upLong = dividend.toLong()
        upLong = kotlin.math.abs(upLong)
        var downLong = divisor.toLong()
        downLong = kotlin.math.abs(downLong)

        // div
        var retLong = div(upLong,downLong).q
        
        // ret
        if(isNeg){retLong=-retLong}
        if(retLong>Integer.MAX_VALUE){retLong=Integer.MAX_VALUE.toLong()}
        if(retLong<Integer.MIN_VALUE){retLong=Integer.MAX_VALUE.toLong()}
        return retLong.toInt()
    }
    
    fun div(upLong:Long,downLong:Long):DivRet{
        if(upLong<downLong){return DivRet(0,upLong)}
        val ret = div(upLong,downLong*2)
        ret.q *= 2
        if(ret.remain>=downLong){
            ret.q++
            ret.remain-=downLong
        }
        return ret
    }
}

data class DivRet(var q:Long,var remain:Long)
