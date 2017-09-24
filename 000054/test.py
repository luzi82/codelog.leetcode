import code

def tt(n,t):
    print(n,t)
    xx = code.Solution()
    vv = xx.spiralOrder(n)
    print(vv)
    assert(vv == t)

    
tt([
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
],[1,2,3,6,9,8,7,4,5])

tt([
    [1,2,3,4],
    [5,6,7,8],
    [9,10,11,12],
    [13,14,15,16]
],[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10])

tt([
 [ 1, 2, 3 ],
 [ 4, 5, 6 ]
],[1,2,3,6,5,4])

tt([
 [ 1, 2],
 [ 3,4],
 [ 5,6]
],[1,2,4,6,5,3])