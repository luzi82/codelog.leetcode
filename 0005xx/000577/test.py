import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.reverseWords(input)
    print(result)
    assert(result == expected)

# given
test("Let's take LeetCode contest","s'teL ekat edoCteeL tsetnoc")
