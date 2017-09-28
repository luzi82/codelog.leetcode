import code

def test(num,target,expected):
    print(num,target,expected)
    solution = code.Solution()
    result = solution.addOperators(num,target)
    print(result)
    assert(sorted(result) == sorted(expected))

    
test("123", 6,["1+2+3", "1*2*3"])
test("232", 8 , ["2*3+2", "2+3*2"])
test("105", 5 , ["1*0+5","10-5"])
test("00", 0 , ["0+0", "0-0", "0*0"])
test("3456237490", 9191 , [])
test("2147483647", 2147483647, ['2147483647'])
