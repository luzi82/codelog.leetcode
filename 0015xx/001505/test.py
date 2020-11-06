import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.minInteger(*input)
    print(result)
    assert(result == expected)

# given
test(('4321',4),'1342')
test(('100',1),'010')
test(('36789',1000),'36789')
test(('22',22),'22')
test(('9438957234785635408',23),'0345989723478563548')
