class Solution {
    fun myAtoi(s: String): Int {
        val BIG_POS:Long = Integer.MAX_VALUE.toLong()
        val SMALL_POS:Long = Integer.MIN_VALUE.toLong()*(-1)
        val cAry = s.toCharArray()
        
        var i=0

        // step 1
        while(i<cAry.size){
            if(cAry[i]!=' '){break}
            ++i
        }
        
        // step 2
        var sign:Char='+'
        if(i<cAry.size){
            if((cAry[i]=='+')||(cAry[i]=='-')){
                sign=cAry[i]
                ++i
            }
        }
        
        // step 3
        var ret:Long=0
        while(i<cAry.size){
            val c=cAry[i]
            if(c<'0'){break}
            if(c>'9'){break}
            ret*=10
            ret+=(c-'0')
            if((sign=='+')&&(ret>BIG_POS)){break}
            if((sign=='-')&&(ret>SMALL_POS)){break}
            ++i
        }
        
        // ret
        if(sign=='-'){
            ret*=-1
        }
        ret = kotlin.math.min(ret,Integer.MAX_VALUE.toLong())
        ret = kotlin.math.max(ret,Integer.MIN_VALUE.toLong())
        
        return ret.toInt()
    }
}
