class Solution {
    fun numberOfSteps(num: Int): Int {
        var ret: Int = 0
        var nnum: Int = num
        while(true){
          if(nnum==0)break
          if(nnum%2==0)nnum/=2
          else nnum-=1
          ret += 1
        }
        return ret
    }
}
