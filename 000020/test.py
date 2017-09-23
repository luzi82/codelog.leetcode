import code

def tt(s,b):
    print(s,b)
    xx = code.Solution()
    vv = xx.isValid(s)
    print(vv)
    assert(vv==b)

tt('()',True)
tt('()[]{}',True)
tt('(]',False)
tt('([)]',False)
tt('((((((',False)
tt(']]]]',False)
tt('',True)
