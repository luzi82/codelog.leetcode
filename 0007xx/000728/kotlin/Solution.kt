import java.util.*

class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val retList:LinkedList<Int> =LinkedList<Int>()
        for(i in left..right){
            if(isSelfDiv(i)){
                retList.add(i)
            }
        }
        return retList
    }
    
    fun isSelfDiv(i:Int):Boolean{
        val iStr:String = Integer.toString(i)
        val iCharAry:CharArray = iStr.toCharArray()
        for(c in iCharAry){
            val cInt = c-'0'
            if(cInt==0)return false
            if(i%cInt!=0)return false
        }
        return true
    }
}
