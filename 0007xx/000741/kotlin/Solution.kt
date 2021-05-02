class Solution {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val n = grid.size
        var abToCAryAry:Array<IntArray> = Array(n){i->IntArray(n){j->-1}}
        abToCAryAry[0][0] = 0
        for(cAry in grid){
            val abToCAryAry0:Array<IntArray> = Array(n){i->IntArray(n){j->-1}}
            for(b in 0..(n-1)){
                for(a in 0..b){
                    for(bb in 0..b){
                        for(aa in 0..min(a,bb)){
                            var c = abToCAryAry[aa][bb]
                            if(c<0){continue}
                            if(a<bb){
                                var good=true
                                for(i in aa..a){
                                    if(cAry[i]<0){good=false;break}
                                    c += cAry[i]
                                }
                                if(!good){continue}
                                for(i in bb..b){
                                    if(cAry[i]<0){good=false;break}
                                    c += cAry[i]
                                }
                                if(!good){continue}
                                abToCAryAry0[a][b] = max(abToCAryAry0[a][b],c)
                            }else{
                                var good=true
                                for(i in aa..b){
                                    if(cAry[i]<0){good=false;break}
                                    c += cAry[i]
                                }
                                if(!good){continue}
                                abToCAryAry0[a][b] = max(abToCAryAry0[a][b],c)
                            }
                        }
                    }
                }
            }
            abToCAryAry = abToCAryAry0
            //println(abToCAryAry)
        }
        if(abToCAryAry[n-1][n-1]<0)return 0
        return abToCAryAry[n-1][n-1]
    }
    
    fun max(a:Int,b:Int):Int{
        return kotlin.math.max(a,b)
    }
    fun min(a:Int,b:Int):Int{
        return kotlin.math.min(a,b)
    }
}
