import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.goodIndices(input[0],input[1])
    print(result)
    assert(result == expected)

# given
test([[2,1,1,1,3,4,1],2],[2,3])
test([[2,1,1,2],2],[])
test([[440043,276285,336957],1],[1])
