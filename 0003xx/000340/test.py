import code

def test(s,k,expected):
    print(s,k,expected)
    solution = code.Solution()
    result = solution.lengthOfLongestSubstringKDistinct(s,k)
    print(result)
    assert(result == expected)

test("eceba",2,3)
test("eceba",1,1)
test("eceba",3,4)
test("eceba",4,5)
