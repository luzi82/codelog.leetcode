import code

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.invalidTransactions(*input)
    print(result)
    assert(result == expected)

# given
test((["alice,20,800,mtv","alice,50,100,beijing"],),["alice,20,800,mtv","alice,50,100,beijing"])
test((["alice,20,800,mtv","alice,50,1200,mtv"],),["alice,50,1200,mtv"])
test((["alice,20,800,mtv","bob,50,1200,mtv"],),["bob,50,1200,mtv"])

# my case
test((["alice,20,800,mtv","alice,50,1000,mtv"],),[])
