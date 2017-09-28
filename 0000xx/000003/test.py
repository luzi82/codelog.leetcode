import code

def tt(s,l):
    print(s,l)
    xx = code.Solution()
    vv = xx.lengthOfLongestSubstring(s)
    print(vv)
    assert(vv==l)

    
tt('abcabcbb',3)
tt('bbbbb',1)
tt('b',1)
tt('pwwkew',3)
tt('abababababa',2)
tt('',0)
