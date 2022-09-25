import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.numberOfGoodPaths(input[0],input[1])
    print(result)
    assert(result == expected)

# given
test(
  [
    [1,3,2,1,3],
    [[0,1],[0,2],[2,3],[2,4]],
  ],
  6
)
test(
  [
    [1,1,2,2,3],
    [[0,1],[1,2],[2,3],[2,4]],
  ],
  7
)
test(
  [
    [1],
    [],
  ],
  1
)
