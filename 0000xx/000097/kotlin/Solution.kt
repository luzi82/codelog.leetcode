class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if(s3.length!=s1.length+s2.length)return false
        
        val c1Ary = s1.toCharArray()
        val c2Ary = s2.toCharArray()
        val c3Ary = s3.toCharArray()
        
        var goodAry = BooleanArray(s2.length+1){false}
        var nextGoodAry = BooleanArray(s2.length+1){false}
        
        goodAry[0] = true
        for(i2 in c2Ary.indices){
            goodAry[i2+1] = goodAry[i2] && (c2Ary[i2] == c3Ary[i2])
        }
        //trace(goodAry)
        
        for(i1 in c1Ary.indices){
            nextGoodAry[0] = goodAry[0] && (c1Ary[i1] == c3Ary[i1])
            for(i2 in c2Ary.indices){
                val c3 = c3Ary[i1+i2+1]
                nextGoodAry[i2+1] = (nextGoodAry[i2] && (c2Ary[i2] == c3) ) || (goodAry[i2+1] && (c1Ary[i1] == c3) )
            }
            val tmpGoodAry = goodAry
            goodAry = nextGoodAry
            nextGoodAry = tmpGoodAry
            //trace(goodAry)
        }
        
        return goodAry[s2.length]
    }
    
    fun trace(goodAry:BooleanArray){
        for(b in goodAry){
            print(if(b){"1 "}else{"0 "})
        }
        println("")
    }
}
