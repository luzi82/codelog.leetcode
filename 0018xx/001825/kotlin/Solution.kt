import java.util.*

class MKAverage(val m: Int, val k: Int) {

  val lessValueToCountMap:TreeMap<Int,Int> = TreeMap<Int,Int>()
  val midValueToCountMap:TreeMap<Int,Int> = TreeMap<Int,Int>()
  val greatValueToCountMap:TreeMap<Int,Int> = TreeMap<Int,Int>()

  val historyList:LinkedList<Int> = LinkedList<Int>()
  var midSum:Int = 0

  fun addElement(num: Int) {
    if(historyList.size>=m){
      val last = historyList.removeLast()
      if(last>=greatValueToCountMap.firstKey()){
        remove(last,greatValueToCountMap)
      }else if(last>=midValueToCountMap.firstKey()){
        remove(last,midValueToCountMap)
        midSum-=last
        val g0 = greatValueToCountMap.firstKey()
        remove(g0,greatValueToCountMap)
        add(g0,midValueToCountMap)
        midSum+=g0
      }else{
        remove(last,lessValueToCountMap)
        val m0 = midValueToCountMap.firstKey()
        remove(m0,midValueToCountMap)
        add(m0,lessValueToCountMap)
        midSum-=m0
        val g0 = greatValueToCountMap.firstKey()
        remove(g0,greatValueToCountMap)
        add(g0,midValueToCountMap)
        midSum+=g0
      }
    }
    historyList.addFirst(num)

    // assume fill lessValueToCountMap first, then midValueToCountMap, then greatValueToCountMap
    add(num,lessValueToCountMap)
    if(historyList.size>k){
      val l1 = lessValueToCountMap.lastKey()
      remove(l1,lessValueToCountMap)
      add(l1,midValueToCountMap)
      midSum+=l1
    }
    if(historyList.size>m-k){
      val m1 = midValueToCountMap.lastKey()
      remove(m1,midValueToCountMap)
      add(m1,greatValueToCountMap)
      midSum-=m1
    }
  }

  fun calculateMKAverage(): Int {
    if(historyList.size<m)return -1
    return midSum/(m-2*k)
  }

  fun trace() {
    for(me in lessValueToCountMap.entries){
      println("%d: %d".format(me.key,me.value))
    }
    for(me in midValueToCountMap.entries){
      println("%d: %d".format(me.key,me.value))
    }
    for(me in greatValueToCountMap.entries){
      println("%d: %d".format(me.key,me.value))
    }
    println("%d".format(midSum))
  }

}

fun add(value:Int, valueToCountMap:TreeMap<Int,Int>){
  if(valueToCountMap.contains(value)){
    var count: Int = valueToCountMap.get(value)!!
    count += 1
    valueToCountMap.put(value,count)
  }else{
    valueToCountMap.put(value,1)
  }
}

fun remove(value:Int, valueToCountMap:TreeMap<Int,Int>){
  var count: Int = valueToCountMap.get(value)!!
  count -= 1
  if(count<=0){
    valueToCountMap.remove(value)
  }else{
    valueToCountMap.put(value,count)
  }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * var obj = MKAverage(m, k)
 * obj.addElement(num)
 * var param_2 = obj.calculateMKAverage()
 */
