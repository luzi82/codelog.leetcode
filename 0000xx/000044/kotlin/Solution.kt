class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val sCAry=s.toCharArray() // i
        val pCAry=p.toCharArray() // j
        val ii = sCAry.size
        val jj = pCAry.size
        
        var goodAry = BooleanArray(ii+1){false}
        goodAry[0] = true

        for(j in 0..(jj-1)){
          val nextGoodAry = BooleanArray(ii+1){false}
          val pChar=pCAry[j]
          for(i in 0..ii){
            if(!goodAry[i]){continue}
            if(pChar=='*'){
                for(ix in i..ii){
                    nextGoodAry[ix]=true
                }
                break
            }
            if(i>=ii){continue}
            val sChar=sCAry[i]
            if(pChar=='?'){
                nextGoodAry[i+1]=true
            }
            if(sChar==pChar){
                nextGoodAry[i+1]=true
            }
          }
          goodAry = nextGoodAry
        }
        
        return goodAry[ii]
    }
}