import code

def test(nums,expected):
    print(nums,expected)
    solution = code.Solution()
    result = solution.countSmaller(nums)
    print(result)
    assert(result == expected)

test([5, 2, 6, 1],[2, 1, 1, 0])

test([0],[0])
test([],[])

test([-1,-1],[0,0])
