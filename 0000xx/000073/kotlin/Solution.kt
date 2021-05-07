class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val ii=matrix.size
        val jj=matrix[0].size

        // find any zI,zJ where matrix[zI][zJ] == 0
        var zI = -1
        var zJ = -1
        for(i in 0..(ii-1)){
            for(j in 0..(jj-1)){
                if(matrix[i][j]!=0){continue}
                zI=i
                zJ=j
                break
            }
            if(zI!=-1){break}
        }

        if(zI==-1){return}

        // use matrix[zI][..] matrix[..][zJ] as storage

        for(i in 0..(ii-1)){
          if(i==zI){continue}
            for(j in 0..(jj-1)){
              if(j==zJ){continue}
              if(matrix[i][j]!=0){continue}
              matrix[zI][j]=0
              matrix[i][zJ]=0
            }
        }

        for(i in 0..(ii-1)){
          if(i==zI){continue}
            for(j in 0..(jj-1)){
              if(j==zJ){continue}
              if((matrix[zI][j]!=0)&&(matrix[i][zJ]!=0)){continue}
              matrix[i][j] = 0
            }
        }

        for(i in 0..(ii-1)){
          matrix[i][zJ]=0
        }
        for(j in 0..(jj-1)){
          matrix[zI][j]=0
        }
    }
}
