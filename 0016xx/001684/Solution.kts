import kotlin.text.*

class Solution {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val charIdxToAllowedAry: BooleanArray = BooleanArray(26){false}
        for(allow in allowed){
          val charIdx = allow.toInt() - 'a'.toInt()
          charIdxToAllowedAry[charIdx] = true
        }

        var ret: Int = 0;
        for(word in words){
          val consistent = isConsistentString(charIdxToAllowedAry, word)
          if(consistent){
            ret += 1
          }
        }

        return ret
    }

    fun isConsistentString(charIdxToAllowedAry: BooleanArray, word: String): Boolean {
      for(c in word){
          val charIdx = c.toInt() - 'a'.toInt()
          if(!charIdxToAllowedAry[charIdx])return false
      }
      return true
    }
}
