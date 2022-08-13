import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.getConcatenation(input)
    print(result)
    assert(result == expected)

# given
test([1,2,1],[1,2,1,1,2,1])
