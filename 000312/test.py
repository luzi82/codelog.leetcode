import code

def test(nums,expected):
    print(nums,expected)
    solution = code.Solution()
    result = solution.maxCoins(nums)
    print(result)
    assert(result == expected)

test([8],8)
test([3,8],3*8+8)
test([3,5,8],3*5*8+3*8+8)

test([3, 1, 5, 8],167)

test([],0)
test([10],10)
