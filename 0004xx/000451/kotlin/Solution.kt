class Solution {
    fun frequencySort(s: String): String {
        val charToCountMap:HashMap<Char,Int> = HashMap<Char,Int>()
        
        for(c in s.toCharArray()){
            val oldCnt:Int = if(charToCountMap.contains(c)){charToCountMap.get(c)!!}else{0}
            charToCountMap.put(c,oldCnt+1)
        }
        
        val cntCharAry : Array<Pair<Int,Char>> = Array<Pair<Int,Char>>(charToCountMap.size){Pair<Int,Char>(0,'_')}
        var idx = 0
        for(c in charToCountMap.keys){
            cntCharAry[idx] = Pair<Int,Char>(charToCountMap.get(c)!!,c)
            idx+=1
        }
        
        cntCharAry.sortWith(compareBy({-it.first},{it.second}))
        
        val sb:StringBuilder = StringBuilder()
        for(p in cntCharAry){
            for(i in 1..p.first){
                sb.append(p.second)
            }
        }
        return sb.toString()
    }
}
