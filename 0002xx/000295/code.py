import heapq

class MedianFinder(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.center = None   # None if odd
        self.left_heap = []  # max heap < center, negative value
        self.right_heap = [] # min heap > center, positive value

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        if self.center is None: # even to odd
            # handle edge cases
            if len(self.left_heap) == 0: 
                self.center = num
                return

            left_max = self._peek_left()
            right_min = self._peek_right()
            # fact: left_max <= right_min

            # go through all cases num compare to left_max and right_min

            if num < left_max:
                self._pop_left()
                self._push_left(num)
                self.center = left_max
            elif num <= left_max:
                self.center = num
            elif num < right_min:
                self.center = num
            elif num == right_min:
                self.center = num
            else:
                self._pop_right()
                self._push_right(num)
                self.center = right_min
        else: # odd to even
            # edge case
            if len(self.left_heap) == 0:
                if num < self.center:
                    self._push_left(num)
                    self._push_right(self.center)
                    self.center = None
                elif num == self.center:
                    self._push_left(num)
                    self._push_right(self.center)
                    self.center = None
                else:
                    self._push_left(self.center)
                    self._push_right(num)
                    self.center = None
                return
            
            left_max = self._peek_left()
            right_min = self._peek_right()
            # fact: left_max <= center <= right_min

            # go through all cases num compare to left_max, center and right_min
            
            if num < left_max:
                self._push_left(num)
                self._push_right(self.center)
                self.center = None
            elif num == left_max:
                self._push_left(num)
                self._push_right(self.center)
                self.center = None
            elif num < self.center:
                self._push_left(num)
                self._push_right(self.center)
                self.center = None
            elif num == self.center:
                self._push_left(num)
                self._push_right(self.center)
                self.center = None
            elif num < right_min:
                self._push_left(self.center)
                self._push_right(num)
                self.center = None
            elif num == right_min:
                self._push_left(self.center)
                self._push_right(num)
                self.center = None
            else:
                self._push_left(self.center)
                self._push_right(num)
                self.center = None


    def _push_left(self,v):
        heapq.heappush(self.left_heap,-v)

    def _peek_left(self):
        return -self.left_heap[0]
    
    def _pop_left(self):
        return -heapq.heappop(self.left_heap)

    def _push_right(self,v):
        heapq.heappush(self.right_heap,v)

    def _peek_right(self):
        return self.right_heap[0]
    
    def _pop_right(self):
        return heapq.heappop(self.right_heap)


    def findMedian(self):
        """
        :rtype: float
        """
        if self.center is None:
            left_max = self._peek_left()
            right_min = self._peek_right()
            return (left_max+right_min)/2.0
        else:
            return self.center


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
