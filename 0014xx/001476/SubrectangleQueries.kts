class SubrectangleQueries(rectangle: Array<IntArray>) {

    val rectangle: Array<IntArray> = rectangle
    val subrectHistoryList: LinkedList<IntArray> = LinkedList()

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        subrectHistoryList.addFirst(intArrayOf(row1,col1,row2,col2,newValue))
    }

    fun getValue(row: Int, col: Int): Int {
        for(subrectHistory in subrectHistoryList){
          if(row<subrectHistory[0])continue
          if(col<subrectHistory[1])continue
          if(row>subrectHistory[2])continue
          if(col>subrectHistory[3])continue
          return subrectHistory[4]
        }
        return rectangle[row][col]
    }

}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * var obj = SubrectangleQueries(rectangle)
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue)
 * var param_2 = obj.getValue(row,col)
 */
