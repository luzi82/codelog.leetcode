import java.util.*

class Solution(val w: IntArray) {

    var sum = 0
    var lVToIdxMap = TreeMap<Int,Int>()
    val rand = Random()
    
    init {
        for(idx in w.indices){
            lVToIdxMap.put(sum,idx)
            val v = w[idx]
            sum += v
        }
    }
    
    fun pickIndex(): Int {
        val r = rand.nextInt(sum)
        //println("UJTFACQO %d".format(r))
        return lVToIdxMap.floorEntry(r).value
    }

}
