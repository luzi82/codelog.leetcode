class Solution {
    fun minPartitions(n: String): Int {
        var charAry: CharArray = n.toCharArray()
        var ret = 0
        for(c in charAry){
          var i: Int = c-'0'
          ret = Math.max(ret,i)
        }
        return ret
    }
}