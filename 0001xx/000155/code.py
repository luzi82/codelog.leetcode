class Node(object):
    def __init__(self,v,mmin,prev):
        self.v = v
        self.mmin = mmin
        self.prev = prev

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.ptr = None
        self.mmin = None

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.ptr = Node(x,self.mmin,self.ptr)
        self.mmin = self._min(self.mmin,x)

    def pop(self):
        """
        :rtype: void
        """
        if self.ptr is not None:
            self.mmin = self.ptr.mmin
            self.ptr = self.ptr.prev

    def top(self):
        """
        :rtype: int
        """
        return self.ptr.v

    def getMin(self):
        """
        :rtype: int
        """
        return self.mmin
        
    def _min(self,a,b):
        if a is None:
            return b
        if b is None:
            return a
        return min(a,b)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
