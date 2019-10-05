import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.kConcatenationMaxSum(*input)
    print(result)
    assert(result == expected)

# given
test(([1,2],3),9)
test(([1,-2,1],5),2)
test(([-1,-2],7),0)
