class Solution {
    fun minOperations(boxes: String): IntArray {
        var leftOpt: Int = 0
        var leftBall: Int = 0
        var rightOpt: Int = 0
        var rightBall: Int = 0

        var boxCharAry: CharArray = boxes.toCharArray()
        for(idx in boxCharAry.indices){
          if(idx==0)continue
          var boxChar: Char = boxCharAry[idx]
          if(boxChar=='0')continue
          rightOpt = rightOpt+idx
          rightBall = rightBall+1
        }

        var ret: IntArray = IntArray(boxes.length)
        for(idx in boxCharAry.indices){
          var boxChar: Char = boxCharAry[idx]
          if(idx!=0){
            rightOpt = rightOpt - rightBall
            if(boxChar=='1')rightBall = rightBall-1
          }
          ret[idx] = rightOpt + leftOpt
          if(boxChar=='1')leftBall = leftBall+1
          leftOpt = leftOpt + leftBall
        }

        return ret
    }
}