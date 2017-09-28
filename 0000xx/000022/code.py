from collections import deque

class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if n == 0:
            return []
        ret = deque()
        self.gp('',0,n,ret)
        ret = list(ret)
        return ret

    def gp(self,s,lv,nn,ret):
        if nn > 0:
            self.gp(s+'(',lv+1,nn-1,ret)
        if lv > 0:
            self.gp(s+')',lv-1,nn,ret)
        if (lv == 0) and (nn == 0):
            ret.append(s)
