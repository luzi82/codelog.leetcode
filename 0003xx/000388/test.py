import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.lengthLongestPath(input)
    print("result={0}".format(result))
    assert(result == expected)

test("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext",20)
test("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext",32)
