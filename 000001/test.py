import code

def test(n,t,expected):
    print(n,t)
    solution = code.Solution()
    result = solution.twoSum(n,t)
    print(result)
    assert(result == expected)
    assert(result[0]!=result[1])
    assert(n[result[0]]+n[result[1]]==t)

    
test([2, 7, 11, 15],9,[0,1])
test([2, 7, 11, 15],18,[1,2])
test([2, 7, 11, 15],17,[0,3])
test([3, 2, 4],6,[1,2])
