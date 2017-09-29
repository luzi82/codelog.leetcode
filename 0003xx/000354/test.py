import code

def test(envelopes,expected):
    print(envelopes,expected)
    solution = code.Solution()
    result = solution.maxEnvelopes(envelopes)
    print(result)
    assert(result == expected)

test([[5,4],[6,4],[6,7],[2,3]],3)
