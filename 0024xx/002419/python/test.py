import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.longestSubarray(input)
    print(result)
    assert(result == expected)

# given
test([1,2,3,3,2,2],2)
test([1,2,3,4],1)
