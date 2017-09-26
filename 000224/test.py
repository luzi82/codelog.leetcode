import code

def test(s,expected):
    print(s,expected)
    solution = code.Solution()
    result = solution.calculate(s)
    print(result)
    assert(result == expected)

assert(code.to_token_list("1 + 1")==[1,'+',1])
assert(code.to_token_list(" 2-1 + 2 ")==[2,'-',1,'+',2])
token = code.to_token_list("(1+(4+5+2)-3)+(6+8)")
t2 = ['(',1,'+','(',4,'+',5,'+',2,')','-',3,')','+','(',6,'+',8,')']
assert(token == t2)

    
test("1 + 1", 2)
test(" 2-1 + 2 ", 3)
test("(1+(4+5+2)-3)+(6+8)", 23)
