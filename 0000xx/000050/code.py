class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1
        
        if n < 0:
            x = 1/x
            n = -n
        
        ret = 1
        xx = x
        while n > 0:
            if n%2 == 1:
                ret *= xx
            
            n >>= 1
            xx = xx * xx
            
        return ret
