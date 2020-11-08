import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.maxProductPath(input)
    print(result)
    assert(result == expected)

# given
test(
[[-1,-2,-3],
 [-2,-3,-3],
 [-3,-3,-2]],
-1)

test(
[[1,-2,1],
 [1,-2,1],
 [3,-4,1]],
 8)

test(
[[1, 3],
 [0,-4]],
 0)

test(
[[ 1, 4,4,0],
 [-2, 0,0,1],
 [ 1,-1,1,1]],
 2)
