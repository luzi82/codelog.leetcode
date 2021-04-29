class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        val size4:Int = arr.size/4
        
        var lastValue:Int = arr[0]
        var lastCount:Int = 0
        for(v in arr){
            if(v!=lastValue){
                lastValue=v
                lastCount=0
            }
            lastCount+=1
            if(lastCount>size4)return lastValue
        }
        return -1
    }
}
