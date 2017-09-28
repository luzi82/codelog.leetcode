from collections import deque

PAIR={
    '(':')',
    '{':'}',
    '[':']',
}

PAIR_REV = {
    v:k
    for k,v in PAIR.items()
}

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = deque()
        
        for c in s:
            if c in PAIR.keys():
                stack.append(c)
                continue
            elif c in PAIR_REV.keys():
                if len(stack)<=0:
                    return False
                cc = stack.pop()
                if cc != PAIR_REV[c]:
                    return False
            else:
                return False
        
        if len(stack)!=0:
            return False
        
        return True
