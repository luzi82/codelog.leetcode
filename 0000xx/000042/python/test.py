import code

def tt(n,v):
    print(n,v)
    xx = code.Solution()
    vv = xx.trap(n)
    print(vv)
    assert(vv==v)

    
tt([0,1,0,2,1,0,1,3,2,1,2,1],6)
tt([],0)
