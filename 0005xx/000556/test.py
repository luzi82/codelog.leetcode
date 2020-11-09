import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.nextGreaterElement(input)
    print(result)
    assert(result == expected)

# given
test(12,21)
test(21,-1)

# my test
test(12345,12354)
test(12354,12435)
test(12435,12453)
test(12453,12534)
test(12534,12543)

test(12223,12232)
test(12232,12322)
test(12322,13222)
test(13222,21223)

test(2**31-1,-1)
