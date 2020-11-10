import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.flipAndInvertImage(input)
    print(result)
    assert(result == expected)

# given
test([[1,1,0],[1,0,1],[0,0,0]],[[1,0,0],[0,1,0],[1,1,1]])
test(
    [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]],
    [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
)
