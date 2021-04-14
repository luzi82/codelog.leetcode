class Solution {
    fun restoreString(s: String, indices: IntArray): String {
        var retCharAry: CharArray = CharArray(s.length)
        var sCharAry: CharArray = s.toCharArray()
        for(idx in indices.indices){
          var iidx = indices[idx]
          retCharAry[iidx] = sCharAry[idx]
        }
        var ret = String(retCharAry)
        return ret
    }
}
