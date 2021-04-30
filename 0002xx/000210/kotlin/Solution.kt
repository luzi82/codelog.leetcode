class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val leftToRightSetAry:Array<HashSet<Int>> = Array<HashSet<Int>>(numCourses){i -> HashSet<Int>()}
        val rightToLeftSetAry:Array<HashSet<Int>> = Array<HashSet<Int>>(numCourses){i -> HashSet<Int>()}
        val noRightSet:HashSet<Int> = HashSet<Int>()
        for(c in 0..(numCourses-1)){
            noRightSet.add(c)
        }
        
        for(p in prerequisites){
            val left = p[0]
            val right = p[1]
            leftToRightSetAry[left].add(right)
            rightToLeftSetAry[right].add(left)
            noRightSet.remove(left)
        }
        
        var doneCount = 0
        val retAry:IntArray = IntArray(numCourses)
        while(true){
            if(doneCount>=numCourses)return retAry
            if(noRightSet.size<=0)return IntArray(0)
            val noRightAry:IntArray = noRightSet.toIntArray()
            for(right in noRightAry){
                for(left in rightToLeftSetAry[right]){
                    leftToRightSetAry[left].remove(right)
                    if(leftToRightSetAry[left].size<=0)noRightSet.add(left)
                }
                noRightSet.remove(right)
                retAry[doneCount]=right
                doneCount+=1
            }
        }
    }
}
