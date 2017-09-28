from collections import deque

class Solution(object):

    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        height = len(matrix)
        if height <= 0:
            return []
        
        width = len(matrix[0])
        if width <= 0:
            return []
        
        q = deque()
        
        self.sp(matrix,0,width,0,height,q)
        
        return list(q)

    # recursive
    # 11111
    # 12221
    # 12321
    # 12221
    # 11111
    def sp(self,matrix,x0,x1,y0,y1,q):
        
        if x0==x1:
            return
        if y0==y1:
            return
        
        if x0+1==x1:
            for y in range(y0,y1):
                q.append(matrix[y][x0])
            return
        
        if y0+1==y1:
            for x in range(x0,x1):
                q.append(matrix[y0][x])
            return

        # OOO.
        # ....
        # ....
        # ....
        for x in range(x0,x1-1):
            q.append(matrix[y0][x])

        # ...O
        # ...O
        # ...O
        # ....
        for y in range(y0,y1-1):
            q.append(matrix[y][x1-1])

        # ....
        # ....
        # ....
        # .OOO
        for x in reversed(range(x0+1,x1)):
            q.append(matrix[y1-1][x])
            
        # ....
        # O...
        # O...
        # O...
        for y in reversed(range(y0+1,y1)):
            q.append(matrix[y][x0])
        
        self.sp(matrix,x0+1,x1-1,y0+1,y1-1,q)
