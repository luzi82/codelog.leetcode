import java.util.*

class Solution {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val N=board.size
        val idxToCellAry = IntArray(N*N){0}
        var idx=0
        for(i in board.indices.reversed()){
           val jItr = if((N-i)%2==1){board[i].indices}else{board[i].indices.reversed()}
           for(j in jItr){
               val v = board[i][j]
               idxToCellAry[idx] = if(v==-1){idx}else{v-1}
               ++idx
           }
        }
        
        //for(v in idxToCellAry){
        //    print("%d ".format(v))
        //}
        //println("")
        
        val BIG = N*N+N
        var idxToMoveAry = IntArray(N*N){BIG}
        val idxQueue=LinkedList<Int>()
        idxToMoveAry[0]=0
        idxQueue.addLast(0)
        
        while(idxQueue.size>0){
            val idx0 = idxQueue.removeFirst()
            val move0 = idxToMoveAry[idx0]
            for(i in 1..6){
                var idx1 = idx0+i
                if(idx1>=N*N){continue}
                idx1 = idxToCellAry[idx0+i]
                val move1 = move0+1
                if(idxToMoveAry[idx1]<=move1){continue}
                idxToMoveAry[idx1]=move1
                idxQueue.addLast(idx1)
                if(idxToMoveAry[N*N-1]!=BIG){break}
            }
            if(idxToMoveAry[N*N-1]!=BIG){break}
        }
        
        val rett = idxToMoveAry[N*N-1]
        return if(rett==BIG){-1}else{rett}
    }
}
