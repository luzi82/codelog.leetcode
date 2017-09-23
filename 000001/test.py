import code

def tt(n,t):
    print(n,t)
    xx = code.Solution()
    vv = xx.twoSum(n,t)
    print(vv)
    assert(vv[0]!=vv[1])
    assert(n[vv[0]]+n[vv[1]]==t)

    
tt([2, 7, 11, 15],9)
tt([2, 7, 11, 15],18)
tt([2, 7, 11, 15],17)
tt([3, 2, 4],6)
