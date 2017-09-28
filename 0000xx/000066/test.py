import code

def tt(n,v):
    print(n,v)
    xx = code.Solution()
    vv = xx.plusOne(n)
    print(vv)
    assert(vv[0],v)

    
tt([1,2,3],[1,2,4])
tt([9],[1,0])
tt([9,9,9],[1,0,0,0])
tt([0],[1])

for i in range(1000):
    j = i+1
    
    ii = str(i)
    ii = list(ii)
    ii = [int(u)for u in ii]
    
    jj = str(j)
    jj = list(jj)
    jj = [int(u)for u in jj]
    
    tt(ii,jj)
