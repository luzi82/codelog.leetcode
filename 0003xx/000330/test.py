import code

def test(nums, n,expected):
    print(nums, n,expected)
    solution = code.Solution()
    result = solution.minPatches(nums, n)
    print(result)
    assert(result == expected)

test([1,3],6,1)
test([1,5,10],20,2)
test([1,2,2],5,0)
