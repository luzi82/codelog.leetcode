import code

def test(matrix,expected):
    print(matrix,expected)
    solution = code.Solution()
    result = solution.longestIncreasingPath(matrix)
    print(result)
    assert(result == expected)

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
e=4
test(nums,e)

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
e=4
test(nums,e)
