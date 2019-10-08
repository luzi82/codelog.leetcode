import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.lastSubstring(*input)
    print(result)
    assert(result == expected)

# given
test(("abab",),"bab")
test(("leetcode",),"tcode")
