import kotlin.text.*

class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        val sb1 = StringBuilder()
        for(word in word1){
          sb1.append(word)
        }

        val sb2 = StringBuilder()
        for(word in word2){
          sb2.append(word)
        }

        val str1 = sb1.toString();
        val str2 = sb2.toString();

        return str1 == str2;
    }
}
