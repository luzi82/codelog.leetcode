class Solution {
    fun countSubstrings(s: String): Int {
        val cAry = s.toCharArray()
        var ret:Int=0
        
        // odd case
        for(i in 0..(cAry.size-1)){
            var j=i
            var k=i
            while(true){
                if(j<0)break
                if(k>=cAry.size)break
                if(cAry[j]!=cAry[k])break
                ret+=1
                j-=1
                k+=1
            }
        }
        
        // even case
        for(i in 0..(cAry.size-2)){
            var j=i
            var k=i+1
            while(true){
                if(j<0)break
                if(k>=cAry.size)break
                if(cAry[j]!=cAry[k])break
                ret+=1
                j-=1
                k+=1
            }
        }
        
        return ret
    }
}
