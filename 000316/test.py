import code

def test(s,expected):
    print(s,expected)
    result = code.Solution().removeDuplicateLetters(s)
    print(result)
    assert(result == expected)

    
test("bcabc","abc")
test("cbacdcbc","acdb")
test("aaaaaabbbbbbbcccccccdcba","abcd")
test("aaaaaabbbbbbbdcba","abdc")
test("","")
