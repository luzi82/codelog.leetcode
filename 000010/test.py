import code

def tt(t,r,v):
    print(t,r,v)
    xx = code.Solution()
    vv = xx.isMatch(t,r)
    print(vv)
    assert(vv==v)

    
tt('aa','a',False)
tt("aa","aa",True)
tt("aaa","aa",False)
tt("aa", "a*",True)
tt("aa", ".*",True)
tt("ab", ".*",True)
tt("aab", "c*a*b",True)
tt("aab", "aabc*",True)
tt("aab", "aabc*d*",True)
tt("ab", ".*c",False)
