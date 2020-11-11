import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.validSquare(*input)
    print(result)
    assert(result == expected)

# given
test(([0,0],[1,1],[1,0],[0,1]),True)
