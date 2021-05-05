import java.util.*

class Solution {
    fun kSimilarity(s1: String, s2: String): Int {
        c1Ary = s1.toCharArray()
        val c2Ary = s2.toCharArray()

        val notDoneIdxSet=HashSet<Int>()
        for(idx in c1Ary.indices){
          if(c1Ary[idx]==c2Ary[idx]){continue}
          notDoneIdxSet.add(idx)
        }

        val c2ToIdxSetMap = HashMap<Char,HashSet<Int>>()
        for(c in 'a'..'f'){
          c2ToIdxSetMap.put(c,HashSet<Int>())
        }
        for(idx in c2Ary.indices){
          if(c1Ary[idx]==c2Ary[idx]){continue}
          val c2=c2Ary[idx]
          c2ToIdxSetMap.get(c2)!!.add(idx)
        }

        return _kSimilarity(s2, notDoneIdxSet, c2ToIdxSetMap)
    }

    var c1Ary=CharArray(0)
    var s2ToRetMap=HashMap<String,Int>()
    fun _kSimilarity(s2: String,notDoneIdxSet:HashSet<Int>,c2ToIdxSetMap:HashMap<Char,HashSet<Int>>): Int {
      if(s2ToRetMap.contains(s2)){
        return s2ToRetMap.get(s2)!!
      }
      val ret = __kSimilarity(s2,notDoneIdxSet,c2ToIdxSetMap)
      s2ToRetMap.put(s2,ret)
      return ret
    }

    fun __kSimilarity(s2: String,notDoneIdxSet:HashSet<Int>,c2ToIdxSetMap:HashMap<Char,HashSet<Int>>): Int {
      if(notDoneIdxSet.size==0){return 0}
      val c2Ary = s2.toCharArray()
      val idx = notDoneIdxSet.elementAt(0)
      val c2=c2Ary[idx]
      val c1=c1Ary[idx]

      c2Ary[idx] = c1
      c2ToIdxSetMap.get(c2)!!.remove(idx)
      notDoneIdxSet.remove(idx)

      var ret = Integer.MAX_VALUE
      val idxSet = c2ToIdxSetMap.get(c1)!!
      val idxList = idxSet.toList()
      for(idx0 in idxList){
        if(c2==c1Ary[idx0]){
          c2Ary[idx0] = c2
          c2ToIdxSetMap.get(c1)!!.remove(idx0)
          notDoneIdxSet.remove(idx0)

          ret = kotlin.math.min(ret,1+_kSimilarity(c2Ary.joinToString(""),notDoneIdxSet,c2ToIdxSetMap))

          notDoneIdxSet.add(idx0)
          c2ToIdxSetMap.get(c1)!!.add(idx0)
          c2Ary[idx0] = c1
        }else{
          c2Ary[idx0] = c2
          c2ToIdxSetMap.get(c1)!!.remove(idx0)
          c2ToIdxSetMap.get(c2)!!.add(idx0)

          ret = kotlin.math.min(ret,1+_kSimilarity(c2Ary.joinToString(""),notDoneIdxSet,c2ToIdxSetMap))

          c2ToIdxSetMap.get(c2)!!.remove(idx0)
          c2ToIdxSetMap.get(c1)!!.add(idx0)
          c2Ary[idx0] = c1
        }
      }

      notDoneIdxSet.add(idx)
      c2ToIdxSetMap.get(c2)!!.add(idx)
      c2Ary[idx] = c2

      return ret
    }

}
