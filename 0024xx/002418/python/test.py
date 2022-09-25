import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.sortPeople(input[0],input[1])
    result = list(result)
    print(result)
    assert(result == expected)

# given
test([["Mary","John","Emma"],[180,165,170]],["Mary","Emma","John"])
test([["Alice","Bob","Bob"],[155,185,150]],["Bob","Alice","Bob"])
