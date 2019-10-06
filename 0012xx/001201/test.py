import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.nthUglyNumber(*input)
    print(result)
    assert(result == expected)

# given
test((3,2,3,5),4)
test((4,2,3,4),6)
test((5,2,11,13),10)
test((1000000000,2, 217983653 , 336916467 ),1999999984)
