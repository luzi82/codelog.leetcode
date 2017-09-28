from collections import deque

class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        
        ans_q = deque()
        carry = 1
        
        for i in reversed(digits):
            i = i+carry
            carry = i//10
            i = i%10
            ans_q.appendleft(i)
        
        if carry == 1:
            ans_q.appendleft(1)
        
        return list(ans_q)
