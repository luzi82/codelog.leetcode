from collections import deque

DIGI_DICT = {
    '2':'abc',
    '3':'def',
    '4':'ghi',
    '5':'jkl',
    '6':'mno',
    '7':'pqrs',
    '8':'tuv',
    '9':'wxyz',
    '0':' ',
}

class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        # contains test case of empty input
        if len(digits) == 0:
            return []
        
        ret = deque()
        ret.append('')
        
        for d in digits:
            c_list = DIGI_DICT[d]
            
            ret0 = ret
            ret = deque()
            
            for r in ret0:
                for c in c_list:
                    ret.append(r+c)

        return list(ret)
