import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.func(input)
    print(result)
    assert(result == expected)

test(a,b)
