import code

def test(buildings,expected):
    print(buildings,expected)
    solution = code.Solution()
    result = solution.getSkyline(buildings)
    print(result)
    assert(result == expected)

test([[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]],[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]])
test([],[])
test([[1,2,1],[2,3,1]],[[1,1],[3,0]])
