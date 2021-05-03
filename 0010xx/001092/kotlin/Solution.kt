class Solution {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        val c1Ary=str1.toCharArray()
        val c2Ary=str2.toCharArray()
        //val abToStrQAryAry:Array<Array<String?> > = Array(c1Ary.size+1){Array<String?>(c2Ary.size+1){_ -> null}}
        var bToStrQAry:Array<String?> = Array<String?>(c2Ary.size+1){null}

        // for(a in 0..c1Ary.size){
        //     abToStrQAryAry[a][0] = str1.substring(0,a)
        // }

        for(b in 0..c2Ary.size){
            bToStrQAry[b] = str2.substring(0,b)
        }

        for(a in 1..c1Ary.size){
            var nextBToStrQAry:Array<String?> = Array<String?>(c2Ary.size+1){null}
            nextBToStrQAry[0] = str1.substring(0,a)
            for(b in 1..c2Ary.size){
                val s1 = bToStrQAry[b]!!
                var s2 = nextBToStrQAry[b-1]!!
                if(s1.length<s2.length){
                    nextBToStrQAry[b] = s1 + c1Ary[a-1]
                }else{
                    nextBToStrQAry[b] = s2 + c2Ary[b-1]
                }
                if(c1Ary[a-1]==c2Ary[b-1]){
                    if(bToStrQAry[b-1]!!.length<nextBToStrQAry[b]!!.length-1){
                        nextBToStrQAry[b] = bToStrQAry[b-1] + c1Ary[a-1]
                    }
                }
            }
            bToStrQAry = nextBToStrQAry
        }
        return bToStrQAry[c2Ary.size]!!
    }
}
