class Solution {
    fun subtractProductAndSum(n: Int): Int {
        var product: Int = 1
        var sum: Int = 0
        var nn: Int = n
        while(true){
          var n0 = nn%10
          product *= n0
          sum += n0
          nn/=10
          if(nn==0)break
        }
        return product - sum
    }
}
